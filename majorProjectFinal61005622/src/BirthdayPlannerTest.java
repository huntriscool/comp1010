import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BirthdayPlannerTest {
    private Person makePerson(String name, int day, int month, double budget) {
        return new Person(name, new Date(day, month, 2005), new Budget(budget));
    }

    /*
     * Planner used by most tests:
     * October: Jordan ($60) and Sam ($40), February: Alex ($30),
     * December: Dana ($25), January: Kai ($20). Nobody is in June.
     */
    private BirthdayPlanner makePlanner(double monthlyBudget) {
        BirthdayPlanner planner = new BirthdayPlanner(new Budget(monthlyBudget));
        planner.addPerson(makePerson("Jordan", 5, 10, 60));
        planner.addPerson(makePerson("Sam", 21, 10, 40));
        planner.addPerson(makePerson("Alex", 14, 2, 30));
        planner.addPerson(makePerson("Dana", 31, 12, 25));
        planner.addPerson(makePerson("Kai", 1, 1, 20));
        return planner;
    }

    private ArrayList<String> namesOf(ArrayList<Person> people) {
        ArrayList<String> names = new ArrayList<>();
        for(Person person : people) {
            names.add(person.getName());
        }
        return names;
    }

    @Test
    public void testTotalBudgetForMonth() {
        BirthdayPlanner planner = makePlanner(150);
        assertEquals(100.0, planner.totalBudgetForMonth(10), 0.001); //two friends
        assertEquals(25.0, planner.totalBudgetForMonth(12), 0.001);  //December
        assertEquals(20.0, planner.totalBudgetForMonth(1), 0.001);   //January
        assertEquals(0.0, planner.totalBudgetForMonth(6), 0.001);    //empty month
    }

    @Test
    public void testTotalBudgetForMonthOnEmptyPlanner() {
        BirthdayPlanner planner = new BirthdayPlanner(new Budget(150));
        assertEquals(0.0, planner.totalBudgetForMonth(1), 0.001);
        assertEquals(0.0, planner.totalBudgetForMonth(12), 0.001);
    }

    @Test
    public void testZeroBudgetFriendAddsNothing() {
        BirthdayPlanner planner = makePlanner(150);
        planner.addPerson(makePerson("Zed", 15, 10, 0));
        assertEquals(100.0, planner.totalBudgetForMonth(10), 0.001);
        assertEquals(3, planner.getBirthdaysInMonth(10).size()); //Zed still counts as a birthday
    }

    @Test
    public void testYearlyBudgetTotal() {
        assertEquals(175.0, makePlanner(150).yearlyBudgetTotal(), 0.001);
        assertEquals(0.0, new BirthdayPlanner(new Budget(150)).yearlyBudgetTotal(), 0.001);
    }

    @Test
    public void testNextMonthWrapsAround() {
        assertEquals(2, BirthdayPlanner.nextMonth(1));
        assertEquals(12, BirthdayPlanner.nextMonth(11));
        assertEquals(1, BirthdayPlanner.nextMonth(12));
    }

    @Test
    public void testRemainingForMonth() {
        assertEquals(50.0, makePlanner(150).remainingForMonth(10), 0.001);
        assertEquals(125.0, makePlanner(150).remainingForMonth(12), 0.001);
        assertEquals(-10.0, makePlanner(90).remainingForMonth(10), 0.001); //negative = over
    }

    @Test
    public void testIsOverMonthlyBudget() {
        assertFalse(makePlanner(150).isOverMonthlyBudget(10));
        assertTrue(makePlanner(90).isOverMonthlyBudget(10));
        assertFalse(makePlanner(100).isOverMonthlyBudget(10)); //exactly on budget is not over
        assertTrue(makePlanner(24.99).isOverMonthlyBudget(12));
        assertFalse(makePlanner(0).isOverMonthlyBudget(6));    //nothing planned, nothing over
    }

    @Test
    public void testGetBirthdaysInMonthIsInCalendarOrder() {
        BirthdayPlanner planner = makePlanner(150);
        assertEquals("[Jordan, Sam]", namesOf(planner.getBirthdaysInMonth(10)).toString());
        assertEquals(0, planner.getBirthdaysInMonth(6).size());
    }

    @Test
    public void testFindPerson() {
        BirthdayPlanner planner = makePlanner(150);
        assertEquals("Alex", planner.findPerson("Alex").getName());
        assertNull(planner.findPerson("Zed"));
    }

    @Test
    public void testTotalGiftCostForMonth() {
        BirthdayPlanner planner = makePlanner(150);
        planner.findPerson("Jordan").addGift(new Gift("Headphones", 72.5));
        planner.findPerson("Jordan").addGift(new Gift("Card", 5.0));
        planner.findPerson("Sam").addGift(new Gift("Book", 25.0));
        assertEquals(102.5, planner.totalGiftCostForMonth(10), 0.001);
        assertEquals(0.0, planner.totalGiftCostForMonth(12), 0.001); //no gifts in December
    }

    @Test
    public void testGetUpcomingAcrossNewYear() {
        BirthdayPlanner planner = makePlanner(150);
        Date today = new Date(20, 12, 2025);
        ArrayList<String> names = namesOf(planner.getUpcoming(today, 30));
        assertEquals(2, names.size());
        assertTrue(names.contains("Dana")); //11 days away
        assertTrue(names.contains("Kai"));  //12 days away, in January
    }

    @Test
    public void testGetUpcomingBoundaries() {
        BirthdayPlanner planner = makePlanner(150);
        assertEquals(1, planner.getUpcoming(new Date(31, 12, 2025), 0).size()); //Dana is today
        assertEquals(1, planner.getUpcoming(new Date(1, 1, 2026), 0).size());   //Kai is today
        assertEquals(0, planner.getUpcoming(new Date(2, 1, 2026), 30).size());  //Alex is 43 days away
    }
}