package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage5;

public class Stage5Test {
	private int[] empty;
	private int[] singleItemArray;
	private int[] tenMultiples;
	private int[] negPos;
	private int[] ascAllPos;
	private int[] descNegs;
	private int[] mixedPosNeg;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		empty = new int[]{};
		singleItemArray = new int[]{777};
		mixedPosNeg = new int[]{-50, 30, -20, 0, 20, -30, 50};
		tenMultiples = new int[]{10,-70,-20,90};
		negPos = new int[]{-3, 15, -13, 16, -1, 10, -101};
		ascAllPos = new int[]{4, 7, 13, 28, 137, 224, 237, 254};
		descNegs = new int[]{-115, -125, -202, -225, -229, -255};
		currentMethodName = null;
	}

	@Test @Graded(description = "containspositive", marks = 1)
	public void testContainsPositive()  {
		assertFalse(Stage5.containsPositive(null));
		assertFalse(Stage5.containsPositive(empty));
		assertTrue(Stage5.containsPositive(singleItemArray));
		assertTrue(Stage5.containsPositive(tenMultiples));
		assertTrue(Stage5.containsPositive(negPos));
		assertTrue(Stage5.containsPositive(ascAllPos));
		assertFalse(Stage5.containsPositive(descNegs));
		assertTrue(Stage5.containsPositive(mixedPosNeg));
		int[] e = {0, 0, 0, 0, 0};
		assertFalse(Stage5.containsPositive(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "squareroot", marks = 1)
	public void testSquareRoot()  {
		assertEquals(4, Stage5.squareRoot(16), 0.01);
		assertEquals(1000, Stage5.squareRoot(1000000), 0.01);
		assertEquals(Math.sqrt(826458554), Stage5.squareRoot(826458554), 0.01);
		assertEquals(17.29, Stage5.squareRoot(17.29*17.29), 0.01);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getfrequencytable", marks = 1)
	public void testGetFrequencyTable()  {
		assertNull(Stage5.getFrequencyTable(null));
		assertNotNull(Stage5.getFrequencyTable(empty));
		assertEquals(0, Stage5.getFrequencyTable(empty).length);
		assertNotNull(Stage5.getFrequencyTable(singleItemArray));
		assertEquals("[1]", Arrays.toString(Stage5.getFrequencyTable(singleItemArray)));
		assertNotNull(Stage5.getFrequencyTable(mixedPosNeg));
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(Stage5.getFrequencyTable(mixedPosNeg)));
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(Stage5.getFrequencyTable(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5})));
		assertEquals("[2, 3, 5]", Arrays.toString(Stage5.getFrequencyTable(new int[]{4, 7, 13, 13, 7, 13, 13, 13, 7, 4})));
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
