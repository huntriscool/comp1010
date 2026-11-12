import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

/*
 * Saves and loads a whole planner as a text file, one record per line:
 *
 *   BUDGET,150.00
 *   PERSON,Jordan,5,10,2005,60.00
 *   GIFT,Headphones,72.50,false
 *
 * A GIFT line belongs to the PERSON line above it.
 */
public class PlannerFileIO {
    public static void save(BirthdayPlanner planner, String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("BUDGET," + formatMoney(planner.getMonthlyBudget().getAmount()));
            writer.newLine();
            for(Person person : planner.getAllPeople()) {
                writer.write(personToLine(person));
                writer.newLine();
                for(Gift gift : person.getGifts()) {
                    writer.write(giftToLine(gift));
                    writer.newLine();
                }
            }
        }
    }

    /*
     * Any problem with the file contents is reported as an IOException,
     * so the Client only has to catch one kind of error.
     */
    public static BirthdayPlanner load(String fileName) throws IOException {
        ArrayList<Person> people = new ArrayList<>();
        Budget monthlyBudget = new Budget(0);

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while(line != null) {
                line = line.trim();
                if(line.startsWith("BUDGET,")) {
                    monthlyBudget = lineToBudget(line);
                }
                else if(line.startsWith("PERSON,")) {
                    people.add(lineToPerson(line));
                }
                else if(line.startsWith("GIFT,")) {
                    if(people.isEmpty()) {
                        throw new IOException("Gift line comes before any person: " + line);
                    }
                    people.get(people.size() - 1).addGift(lineToGift(line));
                }
                else if(!line.isEmpty()) {
                    throw new IOException("Unrecognised line: " + line);
                }
                line = reader.readLine();
            }

            BirthdayPlanner planner = new BirthdayPlanner(monthlyBudget);
            addBalanced(planner, people, 0, people.size() - 1);
            return planner;
        }
        catch(IllegalArgumentException error) {
            throw new IOException("Save file is not in the expected format: " + error.getMessage(), error);
        }
    }

    /*
     * The file lists people in birthday order. Adding them one by one
     * in that order would build a lopsided tree (every person to the
     * right of the last), so we add the middle person first, then the
     * middle of each half, which keeps the tree balanced.
     */
    private static void addBalanced(BirthdayPlanner planner, ArrayList<Person> people, int low, int high) {
        if(low > high) {
            return;
        }
        int middle = (low + high) / 2;
        planner.addPerson(people.get(middle));
        addBalanced(planner, people, low, middle - 1);
        addBalanced(planner, people, middle + 1, high);
    }

    public static String personToLine(Person person) {
        Date birthday = person.getBirthday();
        return "PERSON," + person.getName() + ","
            + birthday.getDay() + "," + birthday.getMonth() + "," + birthday.getYear() + ","
            + formatMoney(person.getGiftBudget().getAmount());
    }

    public static String giftToLine(Gift gift) {
        return "GIFT," + gift.getName() + "," + formatMoney(gift.getPrice()) + "," + gift.isBought();
    }

    // Expects PERSON,name,day,month,year,budget
    public static Person lineToPerson(String line) {
        String[] parts = line.split(",");
        if(parts.length != 6) {
            throw new IllegalArgumentException("Bad PERSON line: " + line);
        }
        Date birthday = new Date(Integer.parseInt(parts[2].trim()),
            Integer.parseInt(parts[3].trim()), Integer.parseInt(parts[4].trim()));
        Budget giftBudget = new Budget(Double.parseDouble(parts[5].trim()));
        return new Person(parts[1], birthday, giftBudget);
    }

    // Expects GIFT,name,price,isBought
    public static Gift lineToGift(String line) {
        String[] parts = line.split(",");
        if(parts.length != 4) {
            throw new IllegalArgumentException("Bad GIFT line: " + line);
        }
        Gift gift = new Gift(parts[1], Double.parseDouble(parts[2].trim()));
        if(Boolean.parseBoolean(parts[3].trim())) {
            gift.markBought();
        }
        return gift;
    }

    // Expects BUDGET,amount
    private static Budget lineToBudget(String line) {
        String[] parts = line.split(",");
        if(parts.length != 2) {
            throw new IllegalArgumentException("Bad BUDGET line: " + line);
        }
        return new Budget(Double.parseDouble(parts[1].trim()));
    }

    // Locale.US so the decimal is always a dot, even on a computer set to a comma-decimal region
    private static String formatMoney(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }
}