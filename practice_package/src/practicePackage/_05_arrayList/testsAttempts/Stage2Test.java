package practicePackage._05_arrayList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._05_arrayList.attempts.*;
import serviceClasses.Rectangle;

@SuppressWarnings("unused")
public class Stage2Test {	
	public ArrayList<Integer> nullList, emptyList, singleItemList, tenMultiples, negPos, ascAllPos, descNegs,list1, list2;
	public ArrayList<Rectangle> rList;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(-7));
		tenMultiples = new ArrayList<Integer>(Arrays.asList(10,-70,-20,90));
		negPos = new ArrayList<Integer>(Arrays.asList(-3, 15, -13, 16, -1, 10, -101));
		ascAllPos = new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28, 137, 224, 237, 254));
		descNegs = new ArrayList<Integer>(Arrays.asList(-115, -125, -202, -225, -229, -255));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
		rList = new ArrayList<Rectangle>();
		rList.add(new Rectangle(5));
		rList.add(new Rectangle(10));
		rList.add(new Rectangle(2, 6));
		rList.add(new Rectangle(20));
		rList.add(new Rectangle(1, 5));
		rList.add(new Rectangle(8));			
		currentMethodName = null;
	}

	@Test @Graded(description = "sumnegatives", marks = 1)
	public void testSumNegatives()  {
		assertEquals(0, Stage2.sumNegatives(null));
		assertEquals(0, Stage2.sumNegatives(emptyList));
		assertEquals(-7, Stage2.sumNegatives(singleItemList));
		assertEquals((-90), Stage2.sumNegatives(tenMultiples));
		assertEquals((-118), Stage2.sumNegatives(negPos));
		assertEquals(0, Stage2.sumNegatives(ascAllPos));
		assertEquals((-1151), Stage2.sumNegatives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, -10));
		assertEquals((-10), Stage2.sumNegatives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "count", marks = 1)
	public void testCount()  {
		assertEquals(0, Stage2.count(nullList,0));
		assertEquals(0, Stage2.count(emptyList,0));
		assertEquals(0, Stage2.count(singleItemList,0));
		assertEquals(1, Stage2.count(singleItemList,-7));
		assertEquals(1, Stage2.count(list1,10));
		assertEquals(1, Stage2.count(list2,5));
		list2.add(5);
		list2.add(5);
		list2.add(5);
		assertEquals(4, Stage2.count(list2,5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsinrange", marks = 1)
	public void testContainsInRange()  {
		assertFalse(Stage2.containsInRange(nullList,0,5));
		assertFalse(Stage2.containsInRange(emptyList,0,5));
		assertFalse(Stage2.containsInRange(singleItemList,-6,0));
		assertTrue(Stage2.containsInRange(singleItemList,-7,0));
		assertFalse(Stage2.containsInRange(singleItemList,-10,-8));
		assertTrue(Stage2.containsInRange(singleItemList,-10,-7));
		assertTrue(Stage2.containsInRange(list1,0,10));
		assertTrue(Stage2.containsInRange(list1,20,100));
		assertFalse(Stage2.containsInRange(list1,0,9));
		assertFalse(Stage2.containsInRange(list2,4,4));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countprimes", marks = 1)
	public void testCountPrimes()  {
		assertEquals(0, Stage2.countPrimes(nullList));
		assertEquals(0, Stage2.countPrimes(emptyList));
		assertEquals(0, Stage2.countPrimes(singleItemList));
		assertEquals(0, Stage2.countPrimes(list1));
		assertEquals(2, Stage2.countPrimes(list2));	//23 and 5
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allprimes", marks = 1)
	public void testAllPrimes()  {
		assertFalse(Stage2.allPrimes(nullList));
		assertTrue(Stage2.allPrimes(emptyList));
		assertFalse(Stage2.allPrimes(singleItemList));		
		singleItemList = new ArrayList<Integer>(Arrays.asList(13));
		assertTrue(Stage2.allPrimes(singleItemList));		

		assertFalse(Stage2.allPrimes(list1));

		list1 = new ArrayList<Integer>(Arrays.asList(13,29,97,2,5,3));
		assertTrue(Stage2.allPrimes(list1));		

		assertFalse(Stage2.allPrimes(list2));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "squareup", marks = 1)
	public void testSquareUp()  {
		Stage2.squareUp(null); //NullPointerException check

		Stage2.squareUp(emptyList);
		assertEquals(0, emptyList.size());

		Stage2.squareUp(singleItemList);
		assertEquals((Integer)(7 * 7), singleItemList.get(0));

		Stage2.squareUp(tenMultiples);
		assertEquals("[100, 4900, 400, 8100]", tenMultiples.toString());

		Stage2.squareUp(negPos);
		for (int item: negPos) {
			assertTrue(serviceClasses.MathService.isSquare(item));
		}

		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		String before = e.toString();
		Stage2.squareUp(e);
		String after = e.toString();
		assertEquals(before, after);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumodd", marks = 1)
	public void testSumOdd()  {
		assertEquals(0, Stage2.sumOdd(null));
		assertEquals(0, Stage2.sumOdd(emptyList));
		assertEquals(-7, Stage2.sumOdd(singleItemList));
		assertEquals(0, Stage2.sumOdd(tenMultiples));
		assertEquals((-103), Stage2.sumOdd(negPos));
		assertEquals(394, Stage2.sumOdd(ascAllPos));
		assertEquals((-949), Stage2.sumOdd(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, Stage2.sumOdd(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "summultiples", marks = 1)
	public void testSumMultiples()  {
		assertEquals(0, Stage2.sumMultiples(null, 69));
		assertEquals(0, Stage2.sumMultiples(emptyList, 96));
		assertEquals(-7, Stage2.sumMultiples(singleItemList, -7));
		assertEquals(10, Stage2.sumMultiples(tenMultiples, 10));
		assertEquals(0, Stage2.sumMultiples(negPos, 7));
		assertEquals(256, Stage2.sumMultiples(ascAllPos, 4));
		assertEquals(-720, Stage2.sumMultiples(descNegs, 5));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, Stage2.sumMultiples(e, 235));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "suminrange", marks = 1)
	public void testSumInRange()  {
		assertEquals(0, Stage2.sumInRange(null, 69, 96));
		assertEquals(0, Stage2.sumInRange(emptyList, 23, 35));
		assertEquals(0, Stage2.sumInRange(singleItemList, 777, 777));
		assertEquals(-7, Stage2.sumInRange(singleItemList, -7, -7));
		assertEquals(10, Stage2.sumInRange(tenMultiples, -70, 90)); //all items satisfy
		assertEquals((-90), Stage2.sumInRange(tenMultiples, -80, -10));
		assertEquals(100, Stage2.sumInRange(tenMultiples, 0, 100));
		assertEquals(10, Stage2.sumInRange(negPos, 10, 14)); //only 1 item satisfies (= low)
		assertEquals(4, Stage2.sumInRange(ascAllPos, -115, 4)); //only 1 item satisfies (= high)
		assertEquals(0, Stage2.sumInRange(descNegs, 0, 125)); //no items satisfy
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, Stage2.sumInRange(e, 0, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumevenindexeditems", marks = 1)
	public void testSumEvenIndexedItems()  {
		assertEquals(0, Stage2.sumEvenIndexedItems(null));
		assertEquals(0, Stage2.sumEvenIndexedItems(emptyList));
		assertEquals(-7, Stage2.sumEvenIndexedItems(singleItemList));
		assertEquals(-10, Stage2.sumEvenIndexedItems(tenMultiples));
		assertEquals(-118, Stage2.sumEvenIndexedItems(negPos));
		assertEquals(391, Stage2.sumEvenIndexedItems(ascAllPos));
		assertEquals(-546, Stage2.sumEvenIndexedItems(descNegs));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "resetnegatives", marks = 1)
	public void testResetNegatives()  {
		Stage2.resetNegatives(null); //NullPointerException check

		Stage2.resetNegatives(emptyList);
		assertEquals(0, emptyList.size());

		Stage2.resetNegatives(singleItemList);
		assertEquals((Integer)0, singleItemList.get(0));

		Stage2.resetNegatives(tenMultiples);
		assertEquals(4, tenMultiples.size());
		assertEquals((Integer)10, tenMultiples.get(0));
		assertEquals((Integer)0, tenMultiples.get(1));
		assertEquals((Integer)0, tenMultiples.get(2));
		assertEquals((Integer)90, tenMultiples.get(3));

		String before1 = ascAllPos.toString();
		Stage2.resetNegatives(ascAllPos);
		String after1 = ascAllPos.toString();
		assertEquals(before1, after1);

		Stage2.resetNegatives(descNegs);
		assertEquals("[0, 0, 0, 0, 0, 0]", descNegs.toString());

		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		String before2 = e.toString();
		Stage2.resetNegatives(e);
		String after2 = e.toString();
		assertEquals(before2, after2);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countodd", marks = 1)
	public void testCountOdd()  {
		assertEquals(0, Stage2.countOdd(null));
		assertEquals(0, Stage2.countOdd(emptyList));
		assertEquals(1, Stage2.countOdd(singleItemList));
		assertEquals(0, Stage2.countOdd(tenMultiples));
		assertEquals(5, Stage2.countOdd(negPos));
		assertEquals(4, Stage2.countOdd(ascAllPos));
		assertEquals(5, Stage2.countOdd(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
		assertEquals(0, Stage2.countOdd(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countnegatives", marks = 1)
	public void testCountNegatives()  {
		assertEquals(0, Stage2.countNegatives(null));
		assertEquals(0, Stage2.countNegatives(emptyList));
		assertEquals(1, Stage2.countNegatives(singleItemList));
		assertEquals(2, Stage2.countNegatives(tenMultiples));
		assertEquals(4, Stage2.countNegatives(negPos));
		assertEquals(0, Stage2.countNegatives(ascAllPos));
		assertEquals(6, Stage2.countNegatives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,-10));
		assertEquals(1, Stage2.countNegatives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countfactors", marks = 1)
	public void testCountFactors()  {
		assertEquals(0, Stage2.countFactors(null, 69));
		assertEquals(0, Stage2.countFactors(emptyList, 96));
		assertEquals(1, Stage2.countFactors(singleItemList, 777));
		assertEquals(4, Stage2.countFactors(tenMultiples, 1260));
		assertEquals(2, Stage2.countFactors(negPos, -100));
		assertEquals(4, Stage2.countFactors(ascAllPos, 224));
		assertEquals(0, Stage2.countFactors(descNegs, -235));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countoccurrences", marks = 1)
	public void testCountOccurrences()  {
		assertEquals(0, Stage2.countOccurrences(null, 69));
		assertEquals(0, Stage2.countOccurrences(emptyList, 96));
		assertEquals(1, Stage2.countOccurrences(singleItemList, -7));
		assertEquals(0, Stage2.countOccurrences(tenMultiples, 0));
		assertEquals(1, Stage2.countOccurrences(ascAllPos, 13));
		assertEquals(7, Stage2.countOccurrences(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7)), 7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsfromindex", marks = 1)
	public void testContainsFromIndex()  {
		assertFalse(Stage2.containsFromIndex(null, 35, 23));
		assertFalse(Stage2.containsFromIndex(emptyList, 96, 69));
		assertFalse(Stage2.containsFromIndex(singleItemList, 777, 0));
		assertFalse(Stage2.containsFromIndex(tenMultiples, 90, 4));
		assertFalse(Stage2.containsFromIndex(negPos, -13, -1));
		assertTrue(Stage2.containsFromIndex(ascAllPos, 254, 6));
		assertFalse(Stage2.containsFromIndex(descNegs, -115, 1));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertTrue(Stage2.containsFromIndex(e, 7, 0));
		assertTrue(Stage2.containsFromIndex(e, 7, 6));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsbetweenindices", marks = 1)
	public void testContainsBetweenIndices()  {
		assertFalse(Stage2.containsBetweenIndices(null, 35, 0, 0));
		assertFalse(Stage2.containsBetweenIndices(emptyList, 35, 0, 0));
		assertFalse(Stage2.containsBetweenIndices(singleItemList, 35, 0, 0));
		assertFalse(Stage2.containsBetweenIndices(singleItemList, -7, 1, 1));
		assertTrue(Stage2.containsBetweenIndices(singleItemList, -7, 0, 0));
		assertTrue(Stage2.containsBetweenIndices(tenMultiples, 90, 3, 3));
		assertTrue(Stage2.containsBetweenIndices(tenMultiples, 90, 1, 3));
		assertFalse(Stage2.containsBetweenIndices(tenMultiples, 10, 1, 3));
		assertTrue(Stage2.containsBetweenIndices(tenMultiples, 10, 0, 0));
		assertTrue(Stage2.containsBetweenIndices(tenMultiples, 10, 0, 1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumuptoindex", marks = 1)
	public void testSumUptoIndex()  {
		assertEquals(0, Stage2.sumUptoIndex(null, 23));
		assertEquals(0, Stage2.sumUptoIndex(emptyList, 35));
		assertEquals(-7, Stage2.sumUptoIndex(singleItemList, 0));
		assertEquals((-80), Stage2.sumUptoIndex(tenMultiples, 2));
		assertEquals((-3), Stage2.sumUptoIndex(negPos, 0));
		assertEquals(0, Stage2.sumUptoIndex(ascAllPos, -1));
		assertEquals(0, Stage2.sumUptoIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, Stage2.sumUptoIndex(e, 0));
		assertEquals(0, Stage2.sumUptoIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumevenfromindex", marks = 1)
	public void testSumEvenFromIndex()  {
		assertEquals(0, Stage2.sumEvenFromIndex(null, 23));
		assertEquals(0, Stage2.sumEvenFromIndex(emptyList, 35));
		assertEquals(0, Stage2.sumEvenFromIndex(singleItemList, 0));
		assertEquals(70, Stage2.sumEvenFromIndex(tenMultiples, 2));
		assertEquals(10, Stage2.sumEvenFromIndex(negPos, 5));
		assertEquals(0, Stage2.sumEvenFromIndex(ascAllPos, -1));
		assertEquals(0, Stage2.sumEvenFromIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, Stage2.sumEvenFromIndex(e, 0));
		assertEquals(0, Stage2.sumEvenFromIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "productpositivesuptoindex", marks = 1)
	public void testProductPositivesUptoIndex()  {
		assertEquals(1, Stage2.productPositivesUptoIndex(null, 23));
		assertEquals(1, Stage2.productPositivesUptoIndex(emptyList, 35));
		assertEquals(1, Stage2.productPositivesUptoIndex(singleItemList, 0));
		assertEquals(900, Stage2.productPositivesUptoIndex(tenMultiples, 3));
		assertEquals(240, Stage2.productPositivesUptoIndex(negPos, 4));
		assertEquals(1, Stage2.productPositivesUptoIndex(ascAllPos, -1));
		assertEquals(1, Stage2.productPositivesUptoIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(1, Stage2.productPositivesUptoIndex(e, 0));
		assertEquals(1, Stage2.productPositivesUptoIndex(e, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countoccurrencesbetweenindices", marks = 1)
	public void testCountOccurrencesBetweenIndices()  {
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(null, 235, 23, 35));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(emptyList, 6996, 69, 96));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(singleItemList, 777, 0, 0));
		assertEquals(1, Stage2.countOccurrencesBetweenIndices(singleItemList, -7, 0, 0));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(tenMultiples, 10, 1, 2));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(negPos, 2, -1, 7));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(ascAllPos, 3, -1, 7));
		assertEquals(0, Stage2.countOccurrencesBetweenIndices(descNegs, 5, 0, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertEquals(7, Stage2.countOccurrencesBetweenIndices(e, 7, 0, 6));
		assertEquals(5, Stage2.countOccurrencesBetweenIndices(e, 7, 1, 5));
		assertEquals(3, Stage2.countOccurrencesBetweenIndices(e, 7, 2, 4));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allpositives", marks = 1)
	public void testAllPositives()  {
		assertFalse(Stage2.allPositives(null));
		assertTrue(Stage2.allPositives(emptyList));
		assertFalse(Stage2.allPositives(singleItemList));
		assertFalse(Stage2.allPositives(tenMultiples));
		assertFalse(Stage2.allPositives(negPos));
		assertTrue(Stage2.allPositives(ascAllPos));
		assertFalse(Stage2.allPositives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertFalse(Stage2.allPositives(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allzeroes", marks = 1)
	public void testAllZeroes()  {
		assertFalse(Stage2.allZeroes(null));
		assertTrue(Stage2.allZeroes(emptyList));
		assertFalse(Stage2.allZeroes(singleItemList));
		assertFalse(Stage2.allZeroes(tenMultiples));
		assertFalse(Stage2.allZeroes(negPos));
		assertFalse(Stage2.allZeroes(ascAllPos));
		assertFalse(Stage2.allZeroes(descNegs));
		assertTrue(Stage2.allZeroes(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containspositive", marks = 1)
	public void testContainsPositive()  {
		assertFalse(Stage2.containsPositive(null));
		assertFalse(Stage2.containsPositive(emptyList));
		assertFalse(Stage2.containsPositive(singleItemList));
		assertTrue(Stage2.containsPositive(tenMultiples));
		assertTrue(Stage2.containsPositive(negPos));
		assertTrue(Stage2.containsPositive(ascAllPos));
		assertFalse(Stage2.containsPositive(descNegs));
		assertFalse(Stage2.containsPositive(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containszero", marks = 1)
	public void testContainsZero()  {
		assertFalse(Stage2.containsZero(null));
		assertFalse(Stage2.containsZero(emptyList));
		assertFalse(Stage2.containsZero(singleItemList));
		singleItemList.set(0, 0);
		assertTrue(Stage2.containsZero(singleItemList));
		assertFalse(Stage2.containsZero(tenMultiples));
		assertFalse(Stage2.containsZero(negPos));
		assertFalse(Stage2.containsZero(ascAllPos));
		assertFalse(Stage2.containsZero(descNegs));
		assertTrue(Stage2.containsZero(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isascending", marks = 1)
	public void testIsAscending()  {
		assertFalse(Stage2.isAscending(null));
		assertTrue(Stage2.isAscending(emptyList));
		assertTrue(Stage2.isAscending(singleItemList));
		assertFalse(Stage2.isAscending(tenMultiples));
		assertFalse(Stage2.isAscending(negPos));
		assertTrue(Stage2.isAscending(ascAllPos));
		assertFalse(Stage2.isAscending(descNegs));
		assertTrue(Stage2.isAscending(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isunchanged", marks = 1)
	public void testIsUnchanged()  {
		assertFalse(Stage2.isUnchanged(null));
		assertTrue(Stage2.isUnchanged(emptyList));
		assertTrue(Stage2.isUnchanged(singleItemList));
		assertFalse(Stage2.isUnchanged(tenMultiples));
		assertFalse(Stage2.isUnchanged(negPos));
		assertFalse(Stage2.isUnchanged(ascAllPos));
		assertFalse(Stage2.isUnchanged(descNegs));
		assertTrue(Stage2.isUnchanged(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isbalanced", marks = 1)
	public void testIsBalanced()  {
		assertFalse(Stage2.isBalanced(null));
		assertTrue(Stage2.isBalanced(emptyList));
		assertFalse(Stage2.isBalanced(singleItemList));
		assertTrue(Stage2.isBalanced(tenMultiples));
		assertFalse(Stage2.isBalanced(negPos));
		assertFalse(Stage2.isBalanced(ascAllPos));
		assertFalse(Stage2.isBalanced(descNegs));
		assertTrue(Stage2.isBalanced(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsdigit", marks = 1)
	public void testContainsDigit()  {
		assertFalse(Stage2.containsDigit(null));
		assertFalse(Stage2.containsDigit(new ArrayList<Character>()));
		assertTrue(Stage2.containsDigit(new ArrayList<Character>(Arrays.asList('7'))));
		assertTrue(Stage2.containsDigit(new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))));
		assertTrue(Stage2.containsDigit(new ArrayList<Character>(Arrays.asList('C', 'O', 'M', 'P', '1', '2', '5'))));
		assertFalse(Stage2.containsDigit(new ArrayList<Character>(Arrays.asList('H', 'D'))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getcopy", marks = 1)
	public void testGetCopy()  {
		assertNull(Stage2.getCopy(null));
		assertNotNull(Stage2.getCopy(emptyList));
		assertEquals("[]", Stage2.getCopy(emptyList).toString());
		assertNotSame(emptyList, Stage2.getCopy(emptyList));
		assertNotNull(Stage2.getCopy(singleItemList));
		assertNotSame(singleItemList, Stage2.getCopy(singleItemList));
		assertEquals(0, Stage2.getCopy(emptyList).size());
		assertEquals("[-7]", Stage2.getCopy(singleItemList).toString());
		assertNotNull(Stage2.getCopy(negPos));
		assertNotSame(negPos, Stage2.getCopy(negPos));
		assertEquals("[-3, 15, -13, 16, -1, 10, -101]", Stage2.getCopy(negPos).toString());		
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
