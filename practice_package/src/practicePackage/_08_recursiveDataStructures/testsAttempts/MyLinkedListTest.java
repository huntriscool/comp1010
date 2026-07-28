package practicePackage._08_recursiveDataStructures.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._08_recursiveDataStructures.attempts.*;

public class MyLinkedListTest {
	public MyLinkedList emptyList, emptyList2;
	public MyLinkedList singleItemList, list1, list2, list3, list4;

	public void ensureNoModify() {
		assertEquals("[]", emptyList.toString());
		assertEquals("[10]", singleItemList.toString());
		assertEquals("[12, 0, 3, -15, 7]", list1.toString());
		assertEquals("[-8, 0, 0, 0, 0, 6, 18, 5, 12]", list2.toString());
	}
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		emptyList = new MyLinkedList();
		emptyList2 = new MyLinkedList();
		singleItemList = new MyLinkedList();
		list1 = new MyLinkedList();
		list2 = new MyLinkedList();
		list3 = new MyLinkedList();
		list4 = new MyLinkedList();
		
		singleItemList.addAtFront(10); 

		list1.addAtFront(7); 
		list1.addAtFront(-15); 
		list1.addAtFront(3); 
		list1.addAtFront(0); 
		list1.addAtFront(12); 
		//12 -> 0 -> 3 -> -15 -> 7

		list2.addAtFront(12); 
		list2.addAtFront(5); 
		list2.addAtFront(18); 
		list2.addAtFront(6); 
		list2.addAtFront(0);
		list2.addAtFront(0);
		list2.addAtFront(0);
		list2.addAtFront(0);
		list2.addAtFront(-8);
		//-8 -> 0 -> 0 -> 0 -> 0 -> 6 -> 18 -> 5 -> 12
		currentMethodName = null;
	}

	@Test @Graded(description = "caninsertitemat", marks = 1)
	public void testCanInsertItemAt()  {
		assertFalse(emptyList.canInsertItemAt(1));
		assertFalse(singleItemList.canInsertItemAt(2));
		assertFalse(list1.canInsertItemAt(-2));
		assertFalse(list1.canInsertItemAt(6));
		assertTrue(emptyList.canInsertItemAt(0));
		assertTrue(list1.canInsertItemAt(5));
		assertTrue(list2.canInsertItemAt(4));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalpositives", marks = 1)
	public void testTotalPositives()  {
		assertEquals(0, emptyList.totalPositives());
		assertEquals(10, singleItemList.totalPositives());
		assertEquals(22, list1.totalPositives());
		assertEquals(41, list2.totalPositives());

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countoccurrences", marks = 1)
	public void testCountOccurrences()  {
		assertEquals(0, emptyList.countOccurrences(10));
		assertEquals(0, singleItemList.countOccurrences(5));
		assertEquals(1, singleItemList.countOccurrences(10));
		assertEquals(1, list2.countOccurrences(-8));
		assertEquals(1, list2.countOccurrences(12));
		assertEquals(4, list2.countOccurrences(0));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "alleven", marks = 1)
	public void testAllEven()  {
		assertTrue(emptyList.allEven());
		assertTrue(singleItemList.allEven());
		assertFalse(list1.allEven());
		assertFalse(list2.allEven());

		ensureNoModify();

		emptyList.addAtFront(-3); //emptyList is now [-3]
		assertFalse(emptyList.allEven());
		singleItemList.addAtFront(12); //singleItemList is now [12, 10]
		assertTrue(singleItemList.allEven());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsinrange", marks = 1)
	public void testContainsInRange()  {
		assertFalse(emptyList.containsInRange(0, 10));
		assertFalse(singleItemList.containsInRange(8, 9));
		assertFalse(list1.containsInRange(13, 20));
		assertFalse(list2.containsInRange(-18, -9));
		assertTrue(singleItemList.containsInRange(10, 10));
		assertTrue(list1.containsInRange(0, 5));
		assertTrue(list2.containsInRange(18, 50));
		assertTrue(list2.containsInRange(-8, -8));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "highest", marks = 1)
	public void testHighest()  {
		assertNull(emptyList.highest());
		assertEquals((Integer)10, singleItemList.highest());
		assertEquals((Integer)12, list1.highest());
		assertEquals((Integer)18, list2.highest());

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "get", marks = 1)
	public void testGet()  {
		assertNull(emptyList.get(0));
		assertNull(singleItemList.get(1));
		assertNull(list1.get(-1));
		assertEquals((Integer)10, singleItemList.get(0));
		assertEquals((Integer)7, list1.get(4));
		assertEquals((Integer)6, list2.get(5));
		assertEquals((Integer)0, list2.get(1));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "remove", marks = 1)
	public void testRemove()  {
		assertNull(emptyList.remove(0));
		assertNull(singleItemList.remove(1));
		assertNull(list1.remove(-2));
		assertEquals((Integer)10, singleItemList.remove(0));
		assertEquals("[]", singleItemList.toString());
		assertEquals((Integer)7, list1.remove(4));
		assertEquals("[12, 0, 3, -15]",list1.toString());
		assertEquals((Integer)0, list2.remove(4));
		assertEquals((Integer)6, list2.remove(4));
		assertEquals("[-8, 0, 0, 0, 18, 5, 12]", list2.toString());	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "join", marks = 1)
	public void testJoin()  {
		assertNotNull(emptyList.join(emptyList2));
		assertEquals("[]", emptyList.join(emptyList2).toString());
		assertNotNull(emptyList.join(singleItemList));
		assertEquals("[10]", emptyList.join(singleItemList).toString());
		assertNotNull(list1.join(list2));
		assertEquals("[12, 0, 3, -15, 7, -8, 0, 0, 0, 0, 6, 18, 5, 12]", list1.join(list2).toString());
		assertNotNull(list2.join(list1));
		assertEquals("[-8, 0, 0, 0, 0, 6, 18, 5, 12, 12, 0, 3, -15, 7]", list2.join(list1).toString());

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "same", marks = 1)
	public void testSame()  {
		list3.addAtFront(-15); 
		list3.addAtFront(7); 
		list3.addAtFront(12); 
		list3.addAtFront(0); 
		list3.addAtFront(3);
		//list3 = -15 -> 7 -> 12 -> 0 -> 3

		list4.addAtFront(3); 
		list4.addAtFront(12); 
		list4.addAtFront(7); 
		list4.addAtFront(-15); 
		list4.addAtFront(0);
		//0 -> -15 -> 7 -> 12 -> 3

		assertTrue(emptyList.same(emptyList2));
		assertFalse(emptyList.same(singleItemList));
		assertFalse(list1.same(list2));

		ensureNoModify();

		emptyList.addAtFront(10); //emptyList is now [10]
		assertTrue(emptyList.same(singleItemList));
		
		assertTrue(list1.same(list3));
		//list1 = 12 -> 0 -> 3 -> -15 -> 7
		//list3 = -15 -> 7 -> 12 -> 0 -> 3

		assertTrue(list1.same(list4));

		list4.addAtFront(2); //list4 is now [2, 0, -15, 7, 12, 3]
		assertFalse(list1.same(list4));

		list3.remove(0);
		list3.addAtFront(8); //list3 is now [8, 0, 3, -15, 7]
		assertFalse(list1.same(list3));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}


    @AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if (currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score += graded.marks();
            score = Math.min(score, 100);
			result += graded.description() + " passed. Marks awarded: " + graded.marks() + "\n";
		}
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		if (result.length() != 0) {
			result = result.substring(0, result.length() - 1); // remove the last "\n"
		}
		System.out.println(result);
		System.out.println("\nmethods passed: " + score);
	}
}
