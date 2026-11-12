import java.util.ArrayList;

/*
 * The "brain" of the app. It owns the tree of friends and the monthly
 * budget, and answers questions like who is in October or whether the
 * plan is over budget. The Client only ever talks to this class.
 */
public class BirthdayPlanner {
    private BirthdayTree tree;
    private Budget monthlyBudget;

    public BirthdayPlanner(Budget monthlyBudget) {
        this.tree = new BirthdayTree();
        this.monthlyBudget = monthlyBudget;
    }

    public Budget getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(Budget monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    // Names must be unique because findPerson and removePerson look people up by name
    public void addPerson(Person person) {
        if(tree.contains(person.getName())) {
            throw new IllegalArgumentException(person.getName() + " is already in the planner");
        }
        tree.insert(person);
    }

    public boolean removePerson(String name) {
        return tree.remove(name);
    }

    public Person findPerson(String name) {
        return tree.findByName(name);
    }

    // Everyone, in calendar order
    public ArrayList<Person> getAllPeople() {
        return tree.getInOrder();
    }

    public ArrayList<Person> getBirthdaysInMonth(int month) {
        return tree.getByMonth(month);
    }

    // December wraps round to January
    public static int nextMonth(int month) {
        return (month % 12) + 1;
    }

    // The plan: what you've promised to spend on friends born this month
    public double totalBudgetForMonth(int month) {
        return sumBudgets(getBirthdaysInMonth(month));
    }

    public double totalGiftCostForMonth(int month) {
        return sumGiftCosts(getBirthdaysInMonth(month));
    }

    public double yearlyBudgetTotal() {
        return sumBudgets(getAllPeople());
    }

    // Monthly budget minus the planned spend. Negative means the plan is too big
    public double remainingForMonth(int month) {
        return monthlyBudget.remainingAfter(totalBudgetForMonth(month));
    }

    // Budget decides what counts as "over", so rounding rules stay in one place
    public boolean isOverMonthlyBudget(int month) {
        return !monthlyBudget.canAfford(totalBudgetForMonth(month));
    }

    /*
     * Friends whose birthday is within the next 'days' days (0 = today only).
     * Sorted soonest first, so a Dec 31 birthday comes before Jan 1 when
     * today is in December, even though January is earlier in the calendar.
     */
    public ArrayList<Person> getUpcoming(Date today, int days) {
        ArrayList<Person> result = new ArrayList<>();
        for(Person person : getAllPeople()) {
            if(person.getBirthday().daysUntilNextBirthday(today) <= days) {
                result.add(person);
            }
        }
        result.sort((first, second) ->
            first.getBirthday().daysUntilNextBirthday(today)
            - second.getBirthday().daysUntilNextBirthday(today));
        return result;
    }

    /*
     * The printout for one month. 'today' is only used to work out
     * the age each friend is turning this year.
     */
    public String getMonthSummary(int month, Date today) {
        StringBuilder summary = new StringBuilder();
        summary.append("--- ").append(Date.MONTH_NAMES[month - 1]).append(" ---\n");

        ArrayList<Person> people = getBirthdaysInMonth(month);
        if(people.isEmpty()) {
            summary.append("No birthdays this month.\n");
        }
        for(Person person : people) {
            summary.append(describeLine(person, today)).append("\n");
        }

        summary.append("\n");
        summary.append("Planned spend this month: ")
            .append(Budget.format(totalBudgetForMonth(month))).append("\n");
        summary.append("Your monthly budget:      ").append(monthlyBudget).append("\n");
        double remaining = remainingForMonth(month);
        if(isOverMonthlyBudget(month)) {
            summary.append("OVER your monthly budget by ")
                .append(Budget.format(-remaining)).append("\n");
        }
        else {
            summary.append("Left over:                ")
                .append(Budget.format(remaining)).append("\n");
        }
        return summary.toString();
    }

    // One line for one friend, e.g. "Oct 05  Jordan  (turns 19)  budget $60.00  gifts $72.50  ok"
    private String describeLine(Person person, Date today) {
        Date birthday = person.getBirthday();
        String monthShort = birthday.getMonthName().substring(0, 3);
        int turning = today.getYear() - birthday.getYear();
        String status = "ok";
        if(person.isOverBudget()) {
            status = "OVER BUDGET";
        }
        return String.format("%s %02d  %-12s (turns %d)  budget %s  gifts %s  %s",
            monthShort, birthday.getDay(), person.getName(), turning,
            person.getGiftBudget(), Budget.format(person.getTotalGiftCost()), status);
    }

    private double sumBudgets(ArrayList<Person> people) {
        double total = 0;
        for(Person person : people) {
            total += person.getGiftBudget().getAmount();
        }
        return total;
    }

    private double sumGiftCosts(ArrayList<Person> people) {
        double total = 0;
        for(Person person : people) {
            total += person.getTotalGiftCost();
        }
        return total;
    }
}