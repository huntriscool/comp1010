package practicePackage._02_arrays.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._02_arrays.attempts.*;

public class Stage1Test {	
	private int[] empty;
	private int[] singleItemArray;
	private int[] multiplesTen1;
	private int[] nonNegSequential;
	private int[] mixed;
	private int[] multiplesTen2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		empty = new int[]{};
		singleItemArray = new int[]{888};
		multiplesTen1 = new int[]{10,70,20,90};
		nonNegSequential = new int[]{0,1,2,3,4,5,6,7,8,9,10};
		mixed = new int[]{-5,0,-12,3,7,6,-4,-8,0,0,0,2,6,9,-1};
		multiplesTen2 = new int[]{10,70,20,90};
		currentMethodName = null;
	}

	@Test @Graded(description = "isnull", marks = 1)
	public void testIsNull()  {
		assertTrue(Stage1.isNull(null));
		assertFalse(Stage1.isNull(empty));
		assertFalse(Stage1.isNull(singleItemArray));
		assertFalse(Stage1.isNull(multiplesTen1));
		assertFalse(Stage1.isNull(nonNegSequential));
		assertFalse(Stage1.isNull(mixed));
		assertFalse(Stage1.isNull(multiplesTen2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isempty", marks = 1)
	public void testIsEmpty()  {
		assertTrue(Stage1.isEmpty(null));
		assertTrue(Stage1.isEmpty(empty));
		assertFalse(Stage1.isEmpty(singleItemArray));
		assertFalse(Stage1.isEmpty(multiplesTen1));
		assertFalse(Stage1.isEmpty(nonNegSequential));
		assertFalse(Stage1.isEmpty(mixed));
		assertFalse(Stage1.isEmpty(multiplesTen2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getlastitem", marks = 1)
	public void testGetLastItem()  {
		assertEquals(0, Stage1.getLastItem(null));
		assertEquals(0, Stage1.getLastItem(empty));
		assertEquals(888, Stage1.getLastItem(singleItemArray));
		assertEquals(90, Stage1.getLastItem(multiplesTen1));
		assertEquals(10, Stage1.getLastItem(nonNegSequential));
		assertEquals(-1, Stage1.getLastItem(mixed));
		assertEquals(90, Stage1.getLastItem(multiplesTen2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "secondlastlessthanlast", marks = 1)
	public void testSecondLastLessThanLast()  {
		assertFalse(Stage1.secondLastLessThanLast(null));
		assertFalse(Stage1.secondLastLessThanLast(empty));
		assertFalse(Stage1.secondLastLessThanLast(singleItemArray));

		assertTrue(Stage1.secondLastLessThanLast(multiplesTen1));
		assertTrue(Stage1.secondLastLessThanLast(nonNegSequential));
		assertFalse(Stage1.secondLastLessThanLast(mixed));
		assertTrue(Stage1.secondLastLessThanLast(multiplesTen2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getsumfirstlastitems", marks = 1)
	public void testGetSumFirstLastItems()  {
		assertEquals(0, Stage1.getSumFirstLastItems(null));
		assertEquals(0, Stage1.getSumFirstLastItems(empty));
		assertEquals(0, Stage1.getSumFirstLastItems(singleItemArray));
		assertEquals(100, Stage1.getSumFirstLastItems(multiplesTen1));
		assertEquals(10, Stage1.getSumFirstLastItems(nonNegSequential));
		assertEquals(-6, Stage1.getSumFirstLastItems(mixed));
		assertEquals(100, Stage1.getSumFirstLastItems(multiplesTen2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "get", marks = 1)
	public void testGet()  {
		assertEquals(0, Stage1.get(null, 0));
		assertEquals(0, Stage1.get(singleItemArray, 1));
		assertEquals(888, Stage1.get(singleItemArray, 0));
		assertEquals(10, Stage1.get(multiplesTen1,0));
		assertEquals(70, Stage1.get(multiplesTen1,1));
		assertEquals(20, Stage1.get(multiplesTen1,2));
		assertEquals(90, Stage1.get(multiplesTen1,3));
		assertEquals(0, Stage1.get(multiplesTen1,-1));
		assertEquals(0, Stage1.get(multiplesTen1,4));
		assertEquals(90, Stage1.get(multiplesTen2, multiplesTen2.length-1));
		assertEquals(0, Stage1.get(multiplesTen2, multiplesTen2.length));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "samesize", marks = 1)
	public void testSameSize()  {
		assertFalse(Stage1.sameSize(null, nonNegSequential));
		assertFalse(Stage1.sameSize(multiplesTen1, null));
		assertFalse(Stage1.sameSize(null, null));
		assertFalse(Stage1.sameSize(empty, singleItemArray));
		assertTrue(Stage1.sameSize(multiplesTen1, multiplesTen2));
		assertFalse(Stage1.sameSize(nonNegSequential, mixed));
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
