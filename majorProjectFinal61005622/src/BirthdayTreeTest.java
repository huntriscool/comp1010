import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BirthdayTreeTest {
    // Helper: a person with a fixed budget, born in the given year
    private Person makePerson(String name, int day, int month, int year) {
        return new Person(name, new Date(day, month, year), new Budget(50));
    }

    private Person makePerson(String name, int day, int month) {
        return makePerson(name, day, month, 2000);
    }

    private ArrayList<String> namesOf(ArrayList<Person> people) {
        ArrayList<String> names = new ArrayList<>();
        for(Person person : people) {
            names.add(person.getName());
        }
        return names;
    }

    @Test
    public void testEmptyTree() {
        BirthdayTree tree = new BirthdayTree();
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(0, tree.getInOrder().size());
        assertEquals(0, tree.getByMonth(3).size());
        assertNull(tree.findByName("Nobody"));
        assertFalse(tree.contains("Nobody"));
    }

    @Test
    public void testSinglePerson() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Jordan", 5, 10));
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        assertEquals(Arrays.asList("Jordan"), namesOf(tree.getInOrder()));
    }

    @Test
    public void testOutOfOrderInsertsComeBackInCalendarOrder() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Mar", 5, 3));
        tree.insert(makePerson("Jan", 9, 1));
        tree.insert(makePerson("Jul", 20, 7));
        tree.insert(makePerson("Feb", 14, 2));
        assertEquals(4, tree.size());
        assertEquals(Arrays.asList("Jan", "Feb", "Mar", "Jul"), namesOf(tree.getInOrder()));
    }

    @Test
    public void testDescendingInsertsStillSorted() {
        BirthdayTree tree = new BirthdayTree();
        //worst case for a tree: every insert goes down the left side
        for(int month = 12; month >= 1; month--) {
            tree.insert(makePerson("m" + month, 1, month));
        }
        ArrayList<String> expected = new ArrayList<>();
        for(int month = 1; month <= 12; month++) {
            expected.add("m" + month);
        }
        assertEquals(12, tree.size());
        assertEquals(expected, namesOf(tree.getInOrder()));
    }

    @Test
    public void testSameBirthdayKeepsBothPeople() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Alex", 10, 5));
        tree.insert(makePerson("Blake", 10, 5));
        assertEquals(2, tree.size());
        assertEquals(Arrays.asList("Alex", "Blake"), namesOf(tree.getInOrder())); //equal goes right
    }

    @Test
    public void testYearIsIgnoredWhenOrdering() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Old", 10, 1, 1950));
        tree.insert(makePerson("Young", 5, 1, 2015));
        assertEquals(Arrays.asList("Young", "Old"), namesOf(tree.getInOrder())); //Jan 5 before Jan 10
    }

    @Test
    public void testMonthBeatsDayWhenOrdering() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("DecFirst", 1, 12));
        tree.insert(makePerson("JanLast", 31, 1));
        assertEquals(Arrays.asList("JanLast", "DecFirst"), namesOf(tree.getInOrder()));
    }

    @Test
    public void testGetByMonth() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Jordan", 5, 10));
        tree.insert(makePerson("Sam", 21, 10));
        tree.insert(makePerson("Alex", 14, 2));
        tree.insert(makePerson("Dana", 31, 12));
        tree.insert(makePerson("Kai", 1, 1));

        assertEquals(Arrays.asList("Jordan", "Sam"), namesOf(tree.getByMonth(10)));
        assertEquals(Arrays.asList("Kai"), namesOf(tree.getByMonth(1)));   //first month
        assertEquals(Arrays.asList("Dana"), namesOf(tree.getByMonth(12))); //last month
        assertEquals(0, tree.getByMonth(6).size());                        //nobody in June
    }

    @Test
    public void testFindByNameInRootLeftAndRight() {
        BirthdayTree tree = new BirthdayTree();
        tree.insert(makePerson("Jordan", 5, 10)); //root
        tree.insert(makePerson("Alex", 14, 2));   //left of root
        tree.insert(makePerson("Dana", 31, 12));  //right of root

        assertEquals("Jordan", tree.findByName("Jordan").getName());
        assertEquals("Alex", tree.findByName("Alex").getName());
        assertEquals("Dana", tree.findByName("Dana").getName());
        assertNull(tree.findByName("Zed"));
        assertTrue(tree.contains("Alex"));
        assertFalse(tree.contains("Zed"));
    }
}