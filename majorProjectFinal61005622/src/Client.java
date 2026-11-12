import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * The text menu that demonstrates the Birthday Budget Planner.
 * It only reads input and prints output; all the real work is done
 * by BirthdayPlanner and the classes underneath it.
 */
public class Client {
    private static final String SAVE_FILE = "planner.csv";
    private static final String DEMO_FILE = "demoPlanner.csv";
    private static final int UPCOMING_DAYS = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date today = getToday();

        System.out.println("=== BIRTHDAY BUDGET PLANNER ===");
        BirthdayPlanner planner = startUp(scanner);

        boolean running = true;
        try {
            while(running) {
                showMenu();
                int choice = readInt(scanner, "Choose an option: ");
                System.out.println();
                switch(choice) {
                    case 1:
                        handleAddPerson(scanner, planner);
                        break;
                    case 2:
                        handleAddGift(scanner, planner);
                        break;
                    case 3:
                        handleMarkBought(scanner, planner);
                        break;
                    case 4:
                        handleViewMonth(scanner, planner, today);
                        break;
                    case 5:
                        handleUpcoming(planner, today);
                        break;
                    case 6:
                        handleListAll(planner);
                        break;
                    case 7:
                        handleRemove(scanner, planner);
                        break;
                    case 8:
                        handleChangeBudget(scanner, planner);
                        break;
                    case 9:
                        handleSave(planner);
                        break;
                    case 10:
                        planner = handleLoad(planner);
                        break;
                    case 11:
                        planner = handleDemo(scanner, planner);
                        break;
                    case 0:
                        handleExit(scanner, planner);
                        running = false;
                        break;
                    default:
                        System.out.println("That isn't an option, try again.");
                }
                System.out.println();
            }
        }
        catch(NoSuchElementException error) {
            System.out.println("Input ended, goodbye!"); //e.g. the input was piped in and ran out
        }
    }

    // ---------- start up and menu ----------

    /*
     * Loads the save file if there is one, otherwise starts a new
     * planner and asks for the monthly budget.
     */
    private static BirthdayPlanner startUp(Scanner scanner) {
        if(new File(SAVE_FILE).exists()) {
            try {
                BirthdayPlanner loaded = PlannerFileIO.load(SAVE_FILE);
                System.out.println("Loaded " + loaded.getAllPeople().size() + " friend(s) from " + SAVE_FILE + ".");
                return loaded;
            }
            catch(IOException error) {
                System.out.println("Couldn't read " + SAVE_FILE + " (" + error.getMessage() + "). Starting fresh.");
            }
        }
        else {
            System.out.println("No save file found, so let's start fresh.");
        }
        double amount = readMoney(scanner, "What's your monthly birthday budget? $");
        return new BirthdayPlanner(new Budget(amount));
    }

    private static void showMenu() {
        System.out.println("1.  Add a friend");
        System.out.println("2.  Add a gift idea for a friend");
        System.out.println("3.  Mark a gift as bought");
        System.out.println("4.  See a month's birthdays");
        System.out.println("5.  Upcoming birthdays (next " + UPCOMING_DAYS + " days)");
        System.out.println("6.  List all friends");
        System.out.println("7.  Remove a friend");
        System.out.println("8.  Change monthly budget");
        System.out.println("9.  Save");
        System.out.println("10. Load");
        System.out.println("11. Load demo data");
        System.out.println("0.  Exit");
    }

    // ---------- menu actions ----------

    private static void handleAddPerson(Scanner scanner, BirthdayPlanner planner) {
        String name = readName(scanner, "Friend's name: ");
        if(planner.findPerson(name) != null) {
            System.out.println(name + " is already in the planner.");
            return;
        }
        Date birthday = readDate(scanner);
        double budget = readMoney(scanner, "Gift budget for " + name + ": $");

        planner.addPerson(new Person(name, birthday, new Budget(budget)));
        System.out.println("Added " + name + ", birthday " + birthday.getDay() + " " + birthday.getMonthName() + ".");
    }

    private static void handleAddGift(Scanner scanner, BirthdayPlanner planner) {
        Person person = askForFriend(scanner, planner);
        if(person == null) {
            return;
        }
        String giftName = readName(scanner, "Gift idea: ");
        double price = readMoney(scanner, "Price: $");
        person.addGift(new Gift(giftName, price));

        if(person.isOverBudget()) {
            double over = -person.getRemainingBudget();
            System.out.println("Added, but heads up: gifts for " + person.getName() + " now cost "
                + Budget.format(person.getTotalGiftCost()) + ", which is " + Budget.format(over) + " over their budget.");
        }
        else {
            System.out.println("Added. " + Budget.format(person.getRemainingBudget()) + " left in "
                + person.getName() + "'s budget.");
        }
    }

    private static void handleMarkBought(Scanner scanner, BirthdayPlanner planner) {
        Person person = askForFriend(scanner, planner);
        if(person == null) {
            return;
        }
        ArrayList<Gift> unbought = person.getUnboughtGifts();
        if(unbought.isEmpty()) {
            System.out.println(person.getName() + " has no gifts left to buy.");
            return;
        }
        for(int i = 0; i < unbought.size(); i++) {
            System.out.println((i + 1) + ". " + unbought.get(i));
        }
        int choice = readIntInRange(scanner, "Which one did you buy? ", 1, unbought.size());
        unbought.get(choice - 1).markBought();
        System.out.println("Marked as bought!");
    }

    private static void handleViewMonth(Scanner scanner, BirthdayPlanner planner, Date today) {
        int month = readIntInRange(scanner, "Month (1-12): ", 1, 12);
        System.out.println();
        System.out.print(planner.getMonthSummary(month, today));
    }

    private static void handleUpcoming(BirthdayPlanner planner, Date today) {
        ArrayList<Person> upcoming = planner.getUpcoming(today, UPCOMING_DAYS);
        if(upcoming.isEmpty()) {
            System.out.println("Nobody has a birthday in the next " + UPCOMING_DAYS + " days.");
            return;
        }
        System.out.println("Coming up in the next " + UPCOMING_DAYS + " days:");
        for(Person person : upcoming) {
            System.out.println(describeUpcoming(person, today));
        }
    }

    private static void handleListAll(BirthdayPlanner planner) {
        ArrayList<Person> everyone = planner.getAllPeople();
        if(everyone.isEmpty()) {
            System.out.println("You haven't added any friends yet.");
            return;
        }
        for(Person person : everyone) {
            System.out.println(person);
        }
        System.out.println();
        System.out.println("Total gift budgets for the year: " + Budget.format(planner.yearlyBudgetTotal()));
    }

    private static void handleRemove(Scanner scanner, BirthdayPlanner planner) {
        Person person = askForFriend(scanner, planner);
        if(person == null) {
            return;
        }
        if(readYesNo(scanner, "Remove " + person.getName() + " and all their gift ideas? (y/n): ")) {
            planner.removePerson(person.getName());
            System.out.println("Removed " + person.getName() + ".");
        }
        else {
            System.out.println("Okay, nothing changed.");
        }
    }

    private static void handleChangeBudget(Scanner scanner, BirthdayPlanner planner) {
        double amount = readMoney(scanner, "New monthly budget: $");
        planner.setMonthlyBudget(new Budget(amount));
        System.out.println("Monthly budget is now " + planner.getMonthlyBudget() + ".");
    }

    private static void handleSave(BirthdayPlanner planner) {
        try {
            PlannerFileIO.save(planner, SAVE_FILE);
            System.out.println("Saved " + planner.getAllPeople().size() + " friend(s) to " + SAVE_FILE + ".");
        }
        catch(IOException error) {
            System.out.println("Couldn't save: " + error.getMessage());
        }
    }

    // Returns the loaded planner, or the current one if loading fails
    private static BirthdayPlanner handleLoad(BirthdayPlanner current) {
        return loadFile(SAVE_FILE, current);
    }

    /*
     * The demo lives in its own file, demoPlanner.csv, so loading it never
     * touches the user's own planner.csv.
     */
    private static BirthdayPlanner handleDemo(Scanner scanner, BirthdayPlanner current) {
        if(!current.getAllPeople().isEmpty()) {
            String warning = "Loading the demo replaces what's loaded now "
                + "(save first if you want to keep it). Continue? (y/n): ";
            if(!readYesNo(scanner, warning)) {
                System.out.println("Okay, nothing changed.");
                return current;
            }
        }
        BirthdayPlanner demo = loadFile(DEMO_FILE, current);
        if(demo != current) {
            System.out.println("Careful: Save (option 9) would write this demo data into " + SAVE_FILE + ".");
        }
        return demo;
    }

    // Shared by Load and Demo: returns the loaded planner, or the current one if loading fails
    private static BirthdayPlanner loadFile(String fileName, BirthdayPlanner current) {
        try {
            BirthdayPlanner loaded = PlannerFileIO.load(fileName);
            System.out.println("Loaded " + loaded.getAllPeople().size() + " friend(s) from " + fileName + ".");
            return loaded;
        }
        catch(IOException error) {
            System.out.println("Couldn't load " + fileName + ": " + error.getMessage());
            return current;
        }
    }

    private static void handleExit(Scanner scanner, BirthdayPlanner planner) {
        if(readYesNo(scanner, "Save before exiting? (y/n): ")) {
            handleSave(planner);
        }
        System.out.println("Bye! Don't forget the gifts.");
    }

    // ---------- helpers for printing and lookups ----------

    // e.g. "Jordan (turns 20) - 05 October - in 3 days"
    private static String describeUpcoming(Person person, Date today) {
        Date birthday = person.getBirthday();
        int daysAway = birthday.daysUntilNextBirthday(today);
        int turning = birthday.ageOn(today);
        String when = "in " + daysAway + " days";
        if(daysAway == 0) {
            when = "TODAY!";
        }
        else {
            turning++; //their birthday hasn't happened yet, so they're about to be a year older
            if(daysAway == 1) {
                when = "tomorrow";
            }
        }
        return "  " + person.getName() + " (turns " + turning + ") - "
            + birthday.getDay() + " " + birthday.getMonthName() + " - " + when;
    }

    // Asks for a name and looks the friend up; prints a message and returns null if not found
    private static Person askForFriend(Scanner scanner, BirthdayPlanner planner) {
        if(planner.getAllPeople().isEmpty()) {
            System.out.println("You haven't added any friends yet.");
            return null;
        }
        String name = readLine(scanner, "Friend's name: ");
        Person person = planner.findPerson(name);
        if(person == null) {
            System.out.println("Couldn't find anyone called " + name + ".");
        }
        return person;
    }

    // Uses the computer's clock, converted into our own Date class
    private static Date getToday() {
        LocalDate now = LocalDate.now();
        return new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
    }

    // ---------- input helpers: every one re-asks instead of crashing ----------

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while(true) {
            String text = readLine(scanner, prompt);
            try {
                return Integer.parseInt(text);
            }
            catch(NumberFormatException error) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static int readIntInRange(Scanner scanner, String prompt, int low, int high) {
        while(true) {
            int value = readInt(scanner, prompt);
            if(value >= low && value <= high) {
                return value;
            }
            System.out.println("Please enter a number from " + low + " to " + high + ".");
        }
    }

    // Accepts "25", "25.5" or "$25.50"
    private static double readMoney(Scanner scanner, String prompt) {
        while(true) {
            String text = readLine(scanner, prompt).replace("$", "");
            try {
                double value = Double.parseDouble(text);
                if(value >= 0 && !Double.isNaN(value) && !Double.isInfinite(value)) {
                    return value;
                }
                System.out.println("Please enter an amount of zero or more.");
            }
            catch(NumberFormatException error) {
                System.out.println("Please enter an amount like 25 or 25.50.");
            }
        }
    }

    // Commas are blocked because they would break the comma-separated save file
    private static String readName(Scanner scanner, String prompt) {
        while(true) {
            String text = readLine(scanner, prompt);
            if(text.isEmpty()) {
                System.out.println("That can't be empty.");
            }
            else if(text.contains(",")) {
                System.out.println("Please don't use commas.");
            }
            else {
                return text;
            }
        }
    }

    private static Date readDate(Scanner scanner) {
        while(true) {
            int day = readInt(scanner, "Birth day (1-31): ");
            int month = readInt(scanner, "Birth month (1-12): ");
            int year = readInt(scanner, "Birth year (e.g. 2005): ");
            try {
                return new Date(day, month, year);
            }
            catch(IllegalArgumentException error) {
                System.out.println(day + "/" + month + "/" + year + " isn't a real date, let's try again.");
            }
        }
    }

    private static boolean readYesNo(Scanner scanner, String prompt) {
        while(true) {
            String text = readLine(scanner, prompt).toLowerCase();
            if(text.equals("y") || text.equals("yes")) {
                return true;
            }
            if(text.equals("n") || text.equals("no")) {
                return false;
            }
            System.out.println("Please answer y or n.");
        }
    }
}