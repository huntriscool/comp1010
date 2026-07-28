package practicePackage._05_arrayList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import serviceClasses.Rectangle;
import practicePackage._05_arrayList.attempts.*;

@SuppressWarnings("unused")
public class Stage1Test {
	public ArrayList<Integer> nullList, emptyList, singleItemList, list1, list2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(-7));
		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
		currentMethodName = null;
	}

	@Test @Graded(description = "getsumfirstlastitems", marks = 1)
	public void testGetSumFirstLastItems()  {
		assertEquals(null, Stage1.getSumFirstLastItems(nullList));
		assertEquals(null, Stage1.getSumFirstLastItems(emptyList));
		assertEquals((Integer)(-7), Stage1.getSumFirstLastItems(singleItemList));
		assertEquals((Integer)(100), Stage1.getSumFirstLastItems(list1));
		assertEquals((Integer)(0), Stage1.getSumFirstLastItems(list2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "samesize", marks = 1)
	public void testSameSize()  {
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		assertTrue(Stage1.sameSize(list1, list3));
		list3.add(10); //list3 now contains 5 items
		assertFalse(Stage1.sameSize(list1, list3));
		list3.remove(0); //list3 now contains 4 items
		assertTrue(Stage1.sameSize(list1, list3));
		list3.remove(0); //list3 now contains 3 items
		assertFalse(Stage1.sameSize(list1, list3));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getfirstitem", marks = 1)
	public void testGetFirstItem()  {
		ArrayList<Rectangle> list = null;
		assertNull(Stage1.getFirstItem(list));
		list = new ArrayList<Rectangle>();
		assertNull(Stage1.getFirstItem(list));
		list.add(new Rectangle(10));
		assertNotNull(Stage1.getFirstItem(list));
		assertEquals("10 by 10", Stage1.getFirstItem(list).toString());
		list.add(0, new Rectangle(20, 50));
		assertNotNull(Stage1.getFirstItem(list));
		assertEquals("20 by 50", Stage1.getFirstItem(list).toString());
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
