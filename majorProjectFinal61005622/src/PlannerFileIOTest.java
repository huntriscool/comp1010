import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class PlannerFileIOTest {
    // Plain relative file name, no machine-specific paths
    private static final String TEST_FILE = "plannerTestTemp.csv";

    // Remove the temp file after every test so tests don't affect each other
    @After
    public void deleteTestFile() {
        File file = new File(TEST_FILE);
        if(file.exists()) {
            file.delete();
        }
    }

    private int countPeople(BirthdayPlanner planner) {
        int total = 0;
        for(int month = 1; month <= 12; month++) {
            total += planner.getBirthdaysInMonth(month).size();
        }
        return total;
    }

    // Nobody has a June birthday in these tests, so all of the monthly budget is left over
    private double monthlyBudgetOf(BirthdayPlanner planner) {
        return planner.remainingForMonth(6);
    }

    private BirthdayPlanner makePlannerWithGifts() {
        BirthdayPlanner planner = new BirthdayPlanner(new Budget(150));
        Person jordan = new Person("Jordan", new Date(5, 10, 2005), new Budget(60));
        Gift headphones = new Gift("Headphones", 72.5);
        Gift book = new Gift("Book", 25);
        book.markBought();
        jordan.addGift(headphones);
        jordan.addGift(book);
        planner.addPerson(jordan);
        planner.addPerson(new Person("Sam", new Date(21, 10, 2006), new Budget(40)));
        return planner;
    }

    @Test
    public void testRoundTripKeepsPeopleAndGifts() throws IOException {
        PlannerFileIO.save(makePlannerWithGifts(), TEST_FILE);
        BirthdayPlanner loaded = PlannerFileIO.load(TEST_FILE);

        assertEquals(2, countPeople(loaded));
        assertEquals(150.0, monthlyBudgetOf(loaded), 0.001);

        Person jordan = loaded.findPerson("Jordan");
        assertNotNull(jordan);
        assertEquals(new Date(5, 10, 2005), jordan.getBirthday());
        assertEquals(60.0, jordan.getGiftBudget().getAmount(), 0.001);
        assertEquals(2, jordan.getGifts().size());
        assertEquals("Headphones", jordan.getGifts().get(0).getName());
        assertEquals(72.5, jordan.getGifts().get(0).getPrice(), 0.001);
        assertFalse(jordan.getGifts().get(0).isBought());
        assertEquals("Book", jordan.getGifts().get(1).getName());
        assertTrue(jordan.getGifts().get(1).isBought());
    }

    @Test
    public void testPersonWithNoGiftsStaysEmpty() throws IOException {
        PlannerFileIO.save(makePlannerWithGifts(), TEST_FILE);
        BirthdayPlanner loaded = PlannerFileIO.load(TEST_FILE);

        Person sam = loaded.findPerson("Sam");
        assertNotNull(sam);
        assertEquals(0, sam.getGifts().size());
    }

    @Test
    public void testEmptyPlannerRoundTrip() throws IOException {
        PlannerFileIO.save(new BirthdayPlanner(new Budget(200)), TEST_FILE);
        BirthdayPlanner loaded = PlannerFileIO.load(TEST_FILE);

        assertEquals(0, countPeople(loaded));
        assertEquals(200.0, monthlyBudgetOf(loaded), 0.001);
    }

    @Test
    public void testSpacesLeapDayAndDecimalsSurvive() throws IOException {
        BirthdayPlanner planner = new BirthdayPlanner(new Budget(99.99));
        Person person = new Person("Mary Ann", new Date(29, 2, 2004), new Budget(12.34));
        person.addGift(new Gift("Gift card", 9.99));
        planner.addPerson(person);

        PlannerFileIO.save(planner, TEST_FILE);
        BirthdayPlanner loaded = PlannerFileIO.load(TEST_FILE);

        Person loadedPerson = loaded.findPerson("Mary Ann");
        assertNotNull(loadedPerson);
        assertEquals(new Date(29, 2, 2004), loadedPerson.getBirthday());
        assertEquals(12.34, loadedPerson.getGiftBudget().getAmount(), 0.001);
        assertEquals("Gift card", loadedPerson.getGifts().get(0).getName());
        assertEquals(9.99, loadedPerson.getGifts().get(0).getPrice(), 0.001);
        assertEquals(99.99, monthlyBudgetOf(loaded), 0.001);
    }

    @Test
    public void testSavingAgainOverwritesOldFile() throws IOException {
        PlannerFileIO.save(makePlannerWithGifts(), TEST_FILE);

        BirthdayPlanner smaller = new BirthdayPlanner(new Budget(50));
        smaller.addPerson(new Person("Kai", new Date(1, 1, 2007), new Budget(20)));
        PlannerFileIO.save(smaller, TEST_FILE);

        BirthdayPlanner loaded = PlannerFileIO.load(TEST_FILE);
        assertEquals(1, countPeople(loaded));
        assertNull(loaded.findPerson("Jordan")); //old data is gone
        assertNotNull(loaded.findPerson("Kai"));
    }

    @Test(expected = IOException.class)
    public void testLoadMissingFileThrows() throws IOException {
        PlannerFileIO.load("thisFileDoesNotExist.csv");
    }
}