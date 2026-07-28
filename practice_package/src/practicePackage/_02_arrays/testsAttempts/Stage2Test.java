package practicePackage._02_arrays.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practicePackage._02_arrays.attempts.*;

public class Stage2Test {
	private int[] empty;
	private int[] singleItemArray;
	private int[] tenMultiples;
	private int[] negPos;
	private int[] ascAllPos;
	private int[] descNegs;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		empty = new int[]{};
		singleItemArray = new int[]{777};
		tenMultiples = new int[]{10,-70,-20,90};
		negPos = new int[]{-3, 15, -13, 16, -1, 10, -101};
		ascAllPos = new int[]{4, 7, 13, 28, 137, 224, 237, 254};
		descNegs = new int[]{-115, -125, -202, -225, -229, -255};
		currentMethodName = null;
	}

	@Test @Graded(description = "sumeven", marks = 1)
	public void testSumEven()  {
		assertEquals(0, Stage2.sumEven(null));
		assertEquals(0, Stage2.sumEven(empty));
		assertEquals(0, Stage2.sumEven(singleItemArray));
		assertEquals(10, Stage2.sumEven(tenMultiples));
		assertEquals(26, Stage2.sumEven(negPos));
		assertEquals(510, Stage2.sumEven(ascAllPos));
		assertEquals((-202), Stage2.sumEven(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.sumEven(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumpositives", marks = 1)
	public void testSumPositives()  {
		assertEquals(0, Stage2.sumPositives(null));
		assertEquals(0, Stage2.sumPositives(empty));
		assertEquals(777, Stage2.sumPositives(singleItemArray));
		assertEquals(100, Stage2.sumPositives(tenMultiples));
		assertEquals(41, Stage2.sumPositives(negPos));
		assertEquals(904, Stage2.sumPositives(ascAllPos));
		assertEquals(0, Stage2.sumPositives(descNegs));
		int[] e = {0, 0, 0, 0, 10};
		assertEquals(10, Stage2.sumPositives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "summultiples", marks = 1)
	public void testSumMultiples()  {
		assertEquals(0, Stage2.sumMultiples(null, 69));
		assertEquals(0, Stage2.sumMultiples(empty, 96));
		assertEquals(777, Stage2.sumMultiples(singleItemArray, 777));
		assertEquals(10, Stage2.sumMultiples(tenMultiples, 10));
		assertEquals(0, Stage2.sumMultiples(negPos, 7));
		assertEquals(256, Stage2.sumMultiples(ascAllPos, 4));
		assertEquals(-720, Stage2.sumMultiples(descNegs, 5));
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.sumMultiples(e, 235));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "suminrange", marks = 1)
	public void testSumInRange()  {
		assertEquals(0, Stage2.sumInRange(null, 69, 96));
		assertEquals(0, Stage2.sumInRange(empty, 23, 35));
		assertEquals(777, Stage2.sumInRange(singleItemArray, 777, 777));
		assertEquals(10, Stage2.sumInRange(tenMultiples, -70, 90)); //all items satisfy
		assertEquals((-90), Stage2.sumInRange(tenMultiples, -80, -10));
		assertEquals(100, Stage2.sumInRange(tenMultiples, 0, 100));
		assertEquals(10, Stage2.sumInRange(negPos, 10, 14)); //only 1 item satisfies (= low)
		assertEquals(4, Stage2.sumInRange(ascAllPos, -115, 4)); //only 1 item satisfies (= high)
		assertEquals(0, Stage2.sumInRange(descNegs, 0, 125)); //no items satisfy
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.sumInRange(e, 0, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumevenindexeditems", marks = 1)
	public void testSumEvenIndexedItems()  {
		assertEquals(0, Stage2.sumEvenIndexedItems(null));
		assertEquals(0, Stage2.sumEvenIndexedItems(empty));
		assertEquals(777, Stage2.sumEvenIndexedItems(singleItemArray));
		assertEquals(-10, Stage2.sumEvenIndexedItems(tenMultiples));
		assertEquals(-118, Stage2.sumEvenIndexedItems(negPos));
		assertEquals(391, Stage2.sumEvenIndexedItems(ascAllPos));
		assertEquals(-546, Stage2.sumEvenIndexedItems(descNegs));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "resetnegatives", marks = 1)
	public void testResetNegatives()  {
		Stage2.resetNegatives(null); //NullPointerException check

		Stage2.resetNegatives(empty);
		assertEquals(0, empty.length);

		Stage2.resetNegatives(singleItemArray);
		assertEquals(777, singleItemArray[0]);

		Stage2.resetNegatives(tenMultiples);
		assertEquals(4, tenMultiples.length);
		assertEquals(10, tenMultiples[0]);
		assertEquals(0, tenMultiples[1]);
		assertEquals(0, tenMultiples[2]);
		assertEquals(90, tenMultiples[3]);

		String before1 = Arrays.toString(ascAllPos);
		Stage2.resetNegatives(ascAllPos);
		String after1 = Arrays.toString(ascAllPos);
		assertEquals(before1, after1);

		Stage2.resetNegatives(descNegs);
		assertEquals("[0, 0, 0, 0, 0, 0]", Arrays.toString(descNegs));

		int[] e = {0, 0, 0, 0, 0};
		String before2 = Arrays.toString(e);
		Stage2.resetNegatives(e);
		String after2 = Arrays.toString(e);
		assertEquals(before2, after2);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "squareup", marks = 1)
	public void testSquareUp()  {
		Stage2.squareUp(null); //NullPointerException check

		Stage2.squareUp(empty);
		assertEquals(0, empty.length);

		Stage2.squareUp(singleItemArray);
		assertEquals(777 * 777, singleItemArray[0]);

		Stage2.squareUp(tenMultiples);
		assertEquals("[100, 4900, 400, 8100]", Arrays.toString(tenMultiples));

		Stage2.squareUp(negPos);
		for (int item: negPos) {
			assertTrue(serviceClasses.MathService.isSquare(item));
		}

		int[] e = {0, 0, 0, 0, 0};
		String before = Arrays.toString(e);
		Stage2.squareUp(e);
		String after = Arrays.toString(e);
		assertEquals(before, after);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countodd", marks = 1)
	public void testCountOdd()  {
		assertEquals(0, Stage2.countOdd(null));
		assertEquals(0, Stage2.countOdd(empty));
		assertEquals(1, Stage2.countOdd(singleItemArray));
		assertEquals(0, Stage2.countOdd(tenMultiples));
		assertEquals(5, Stage2.countOdd(negPos));
		assertEquals(4, Stage2.countOdd(ascAllPos));
		assertEquals(5, Stage2.countOdd(descNegs));
		int[] e = {0,0,0,0,0};
		assertEquals(0, Stage2.countOdd(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countnegatives", marks = 1)
	public void testCountNegatives()  {
		assertEquals(0, Stage2.countNegatives(null));
		assertEquals(0, Stage2.countNegatives(empty));
		assertEquals(0, Stage2.countNegatives(singleItemArray));
		assertEquals(2, Stage2.countNegatives(tenMultiples));
		assertEquals(4, Stage2.countNegatives(negPos));
		assertEquals(0, Stage2.countNegatives(ascAllPos));
		assertEquals(6, Stage2.countNegatives(descNegs));
		int[] e = {0,0,0,0,-10};
		assertEquals(1, Stage2.countNegatives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countfactors", marks = 1)
	public void testCountFactors()  {
		assertEquals(0, Stage2.countFactors(null, 69));
		assertEquals(0, Stage2.countFactors(empty, 96));
		assertEquals(1, Stage2.countFactors(singleItemArray, 777));
		assertEquals(4, Stage2.countFactors(tenMultiples, 1260));
		assertEquals(2, Stage2.countFactors(negPos, -100));
		assertEquals(4, Stage2.countFactors(ascAllPos, 224));
		assertEquals(0, Stage2.countFactors(descNegs, -235));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countnotinrange", marks = 1)
	public void testCountNotInRange()  {
		assertEquals(0, Stage2.countNotInRange(null, 69, 96));
		assertEquals(0, Stage2.countNotInRange(empty, 23, 35));
		assertEquals(0, Stage2.countNotInRange(singleItemArray, 777, 777));
		assertEquals(4, Stage2.countNotInRange(tenMultiples, 100, 169)); //all items satisfy
		assertEquals(2, Stage2.countNotInRange(tenMultiples, -80, -10));
		assertEquals(2, Stage2.countNotInRange(tenMultiples, 0, 100));
		assertEquals(6, Stage2.countNotInRange(negPos, 10, 14)); //only 1 item dissatisfies (= low)
		assertEquals(7, Stage2.countNotInRange(ascAllPos, -115, 4)); //only 1 item dissatisfies (= high)
		assertEquals(0, Stage2.countNotInRange(descNegs, -269, 0)); //no items satisfy
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.countNotInRange(e, 0, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countunique", marks = 1)
	public void testCountUnique()  {
		assertEquals(0, Stage2.countUnique(null));
		assertEquals(0, Stage2.countUnique(empty));
		assertEquals(1, Stage2.countUnique(singleItemArray));
		assertEquals(6, Stage2.countUnique(descNegs));
		assertEquals(3, Stage2.countUnique(new int[]{0, 2, 0, 3, 1, 5, 1}));
		assertEquals(0, Stage2.countUnique(new int[]{7, 7, 7, 7, 7, 7, 7}));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "indexof", marks = 1)
	public void testIndexOf()  {
		assertEquals(-1, Stage2.indexOf(null, 69));
		assertEquals(-1, Stage2.indexOf(empty, 96));
		assertEquals(0, Stage2.indexOf(singleItemArray, 777));
		assertEquals(0, Stage2.indexOf(tenMultiples, 10));
		assertEquals(3, Stage2.indexOf(negPos, 16));
		assertEquals(7, Stage2.indexOf(ascAllPos, 254));
		assertEquals(-1, Stage2.indexOf(descNegs, 0));
		assertEquals(0, Stage2.indexOf(new int[]{7, 7, 7, 7, 7, 7, 7}, 7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsfromindex", marks = 1)
	public void testContainsFromIndex()  {
		assertFalse(Stage2.containsFromIndex(null, 35, 23));
		assertFalse(Stage2.containsFromIndex(empty, 96, 69));
		assertTrue(Stage2.containsFromIndex(singleItemArray, 777, 0));
		assertFalse(Stage2.containsFromIndex(tenMultiples, 90, 4));
		assertFalse(Stage2.containsFromIndex(negPos, -13, -1));
		assertTrue(Stage2.containsFromIndex(ascAllPos, 254, 6));
		assertFalse(Stage2.containsFromIndex(descNegs, -115, 1));
		int[] e = {7, 7, 7, 7, 7, 7, 7};
		assertTrue(Stage2.containsFromIndex(e, 7, 0));
		assertTrue(Stage2.containsFromIndex(e, 7, 6));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsbetweenindices", marks = 1)
	public void testContainsBetweenIndices()  {
		assertFalse(Stage2.containsBetweenIndices(null, 35, 1, 4));
		assertFalse(Stage2.containsBetweenIndices(empty, 96, 0, 0));
		assertTrue(Stage2.containsBetweenIndices(singleItemArray, 777, 0, 0));
		assertFalse(Stage2.containsBetweenIndices(tenMultiples, 90, 0, 2));
		assertTrue(Stage2.containsBetweenIndices(tenMultiples, 90, 0, 3));
		assertFalse(Stage2.containsBetweenIndices(negPos, -3, 1, negPos.length - 1));
		assertTrue(Stage2.containsBetweenIndices(negPos, -3, 0, negPos.length - 1));
		int[] e = {7, 7, 7, 7, 7, 7, 7};
		assertTrue(Stage2.containsBetweenIndices(e, 7, 0, 0));
		assertTrue(Stage2.containsBetweenIndices(e, 7, 6, 6));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumuptoindex", marks = 1)
	public void testSumUptoIndex()  {
		assertEquals(0, Stage2.sumUptoIndex(null, 23));
		assertEquals(0, Stage2.sumUptoIndex(empty, 35));
		assertEquals(777, Stage2.sumUptoIndex(singleItemArray, 0));
		assertEquals((-80), Stage2.sumUptoIndex(tenMultiples, 2));
		assertEquals((-3), Stage2.sumUptoIndex(negPos, 0));
		assertEquals(0, Stage2.sumUptoIndex(ascAllPos, -1));
		assertEquals(0, Stage2.sumUptoIndex(descNegs, 6));
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.sumUptoIndex(e, 0));
		assertEquals(0, Stage2.sumUptoIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumevenfromindex", marks = 1)
	public void testSumEvenFromIndex()  {
		assertEquals(0, Stage2.sumEvenFromIndex(null, 23));
		assertEquals(0, Stage2.sumEvenFromIndex(empty, 35));
		assertEquals(0, Stage2.sumEvenFromIndex(singleItemArray, 0));
		assertEquals(70, Stage2.sumEvenFromIndex(tenMultiples, 2));
		assertEquals(10, Stage2.sumEvenFromIndex(negPos, 5));
		assertEquals(0, Stage2.sumEvenFromIndex(ascAllPos, -1));
		assertEquals(0, Stage2.sumEvenFromIndex(descNegs, 6));
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(0, Stage2.sumEvenFromIndex(e, 0));
		assertEquals(0, Stage2.sumEvenFromIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "productpositivesuptoindex", marks = 1)
	public void testProductPositivesUptoIndex()  {
		assertEquals(1, Stage2.productPositivesUptoIndex(null, 23));
		assertEquals(1, Stage2.productPositivesUptoIndex(empty, 35));
		assertEquals(777, Stage2.productPositivesUptoIndex(singleItemArray, 0));
		assertEquals(900, Stage2.productPositivesUptoIndex(tenMultiples, 3));
		assertEquals(240, Stage2.productPositivesUptoIndex(negPos, 4));
		assertEquals(1, Stage2.productPositivesUptoIndex(ascAllPos, -1));
		assertEquals(1, Stage2.productPositivesUptoIndex(descNegs, 6));
		int[] e = {0, 0, 0, 0, 0};
		assertEquals(1, Stage2.productPositivesUptoIndex(e, 0));
		assertEquals(1, Stage2.productPositivesUptoIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countoccurrencesbetweenindices", marks = 1)
	public void testCountOccurrencesBetweenIndices()  {
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(null, 235, 23, 35));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(empty, 6996, 69, 96));
		assertEquals(1, Stage2.countOccurrencesBetweenIndices(singleItemArray, 777, 0, 0));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(tenMultiples, 10, 1, 2));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(negPos, 2, -1, 7));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(ascAllPos, 3, -1, 7));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(descNegs, 5, 0, 6));
		int[] e = {7, 7, 7, 7, 7, 7, 7};
		assertEquals(7, Stage2.countOccurrencesBetweenIndices(e, 7, 0, 6));
		assertEquals(5, Stage2.countOccurrencesBetweenIndices(e, 7, 1, 5));
		assertEquals(3, Stage2.countOccurrencesBetweenIndices(e, 7, 2, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allpositives", marks = 1)
	public void testAllPositives()  {
		assertFalse(Stage2.allPositives(null));
		assertTrue(Stage2.allPositives(empty));
		assertTrue(Stage2.allPositives(singleItemArray));
		assertFalse(Stage2.allPositives(tenMultiples));
		assertFalse(Stage2.allPositives(negPos));
		assertTrue(Stage2.allPositives(ascAllPos));
		assertFalse(Stage2.allPositives(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertFalse(Stage2.allPositives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allzeroes", marks = 1)
	public void testAllZeroes()  {
		assertFalse(Stage2.allZeroes(null));
		assertTrue(Stage2.allZeroes(empty));
		assertFalse(Stage2.allZeroes(singleItemArray));
		assertFalse(Stage2.allZeroes(tenMultiples));
		assertFalse(Stage2.allZeroes(negPos));
		assertFalse(Stage2.allZeroes(ascAllPos));
		assertFalse(Stage2.allZeroes(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertTrue(Stage2.allZeroes(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allprimes", marks = 1)
	public void testAllPrimes()  {
		assertFalse(Stage2.allPrimes(null));
		assertTrue(Stage2.allPrimes(empty));
		assertFalse(Stage2.allPrimes(singleItemArray));
		assertFalse(Stage2.allPrimes(tenMultiples));
		assertFalse(Stage2.allPrimes(negPos));
		assertFalse(Stage2.allPrimes(ascAllPos));
		assertFalse(Stage2.allPrimes(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertFalse(Stage2.allPrimes(e));
		int[] f = {7, 7, 7, 7, 7, 7, 7};
		assertTrue(Stage2.allPrimes(f));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsnegative", marks = 1)
	public void testContainsNegative()  {
		assertFalse(Stage2.containsNegative(null));
		assertFalse(Stage2.containsNegative(empty));
		assertFalse(Stage2.containsNegative(singleItemArray));
		assertTrue(Stage2.containsNegative(tenMultiples));
		assertTrue(Stage2.containsNegative(negPos));
		assertFalse(Stage2.containsNegative(ascAllPos));
		assertTrue(Stage2.containsNegative(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertFalse(Stage2.containsNegative(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsnonzero", marks = 1)
	public void testContainsNonZero()  {
		assertFalse(Stage2.containsNonZero(null));
		assertFalse(Stage2.containsNonZero(empty));
		assertTrue(Stage2.containsNonZero(singleItemArray));
		singleItemArray[0] = 0;
		assertFalse(Stage2.containsNonZero(singleItemArray));
		assertTrue(Stage2.containsNonZero(tenMultiples));
		assertTrue(Stage2.containsNonZero(negPos));
		assertTrue(Stage2.containsNonZero(ascAllPos));
		assertTrue(Stage2.containsNonZero(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertFalse(Stage2.containsNonZero(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isascending", marks = 1)
	public void testIsAscending()  {
		assertFalse(Stage2.isAscending(null));
		assertTrue(Stage2.isAscending(empty));
		assertTrue(Stage2.isAscending(singleItemArray));
		assertFalse(Stage2.isAscending(tenMultiples));
		assertFalse(Stage2.isAscending(negPos));
		assertTrue(Stage2.isAscending(ascAllPos));
		assertFalse(Stage2.isAscending(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertTrue(Stage2.isAscending(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isunchanged", marks = 1)
	public void testIsUnchanged()  {
		assertFalse(Stage2.isUnchanged(null));
		assertTrue(Stage2.isUnchanged(empty));
		assertTrue(Stage2.isUnchanged(singleItemArray));
		assertFalse(Stage2.isUnchanged(tenMultiples));
		assertFalse(Stage2.isUnchanged(negPos));
		assertFalse(Stage2.isUnchanged(ascAllPos));
		assertFalse(Stage2.isUnchanged(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertTrue(Stage2.isUnchanged(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isbalanced", marks = 1)
	public void testIsBalanced()  {
		assertFalse(Stage2.isBalanced(null));
		assertTrue(Stage2.isBalanced(empty));
		assertFalse(Stage2.isBalanced(singleItemArray));
		assertTrue(Stage2.isBalanced(tenMultiples));
		assertFalse(Stage2.isBalanced(negPos));
		assertFalse(Stage2.isBalanced(ascAllPos));
		assertFalse(Stage2.isBalanced(descNegs));
		int[] e = {0, 0, 0, 0, 0};
		assertTrue(Stage2.isBalanced(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsdigit", marks = 1)
	public void testContainsDigit()  {
		assertFalse(Stage2.containsDigit(null));
		assertFalse(Stage2.containsDigit(new char[]{}));
		assertTrue(Stage2.containsDigit(new char[]{'7'}));
		assertTrue(Stage2.containsDigit(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));
		assertTrue(Stage2.containsDigit(new char[]{'C', 'O', 'M', 'P', '1', '2', '5'}));
		assertFalse(Stage2.containsDigit(new char[]{'H', 'D'}));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getcopy", marks = 1)
	public void testGetCopy()  {
		assertNull(Stage2.getCopy(null));
		assertNotEquals(empty, Stage2.getCopy(empty));
		assertNotEquals(singleItemArray, Stage2.getCopy(singleItemArray));
		assertEquals(0, Stage2.getCopy(empty).length);
		assertEquals("[777]", Arrays.toString(Stage2.getCopy(singleItemArray)));
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
