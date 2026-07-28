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

public class Stage4Test {
	private int[] empty;
	private int[] singleItemArray;
	private int[] tenMultiples;
	private int[] nonNegsShort;
	private int[] nonNegsLong;
	private int[] positives;
	private int[] mixed;
	private int[] allZeroes;
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		empty = new int[]{};
		singleItemArray = new int[]{777};
		tenMultiples = new int[]{10, 70, 20, 90};
		nonNegsShort = new int[]{0, 4, 2, 3, 5, 1, 6, 9, 7, 8};
		nonNegsLong = new int[]{0, 0, 1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 5};
		positives = new int[]{10, 3, 5, 6, 2};
		mixed = new int[]{0, 10, 3, -2, 5, 2, 1, 12, -1};
		allZeroes = new int[]{0, 0, 0, 0, 0};
		currentMethodName = null;
	}

	@Test @Graded(description = "intersection", marks = 1)
	public void testIntersection()  {
		assertEquals(0, Stage4.intersection(null,  null));
		assertEquals(0, Stage4.intersection(new int[5],  null));
		assertEquals(0, Stage4.intersection(null,  new int[5]));
		assertEquals(5, Stage4.intersection(new int[5],  new int[5])); //item 0 occurs 5 times in both arrays
		assertEquals(3, Stage4.intersection(new int[]{30,10,30,30,10,20,40}, new int[]{60,10,10,10,10,30,50}));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getlongestascendingsequence", marks = 1)
	public void testGetLongestAscendingSequence()  {
		assertEquals(0, Stage4.getLongestAscendingSequence(empty).length);
		assertEquals("[777]", Arrays.toString(Stage4.getLongestAscendingSequence(singleItemArray)));
		assertEquals("[10, 70]", Arrays.toString(Stage4.getLongestAscendingSequence(tenMultiples)));
		assertEquals("[2, 3, 5]", Arrays.toString(Stage4.getLongestAscendingSequence(nonNegsShort)));
		assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(Stage4.getLongestAscendingSequence(nonNegsLong)));
		assertEquals("[3, 5, 6]", Arrays.toString(Stage4.getLongestAscendingSequence(positives)));
		assertEquals("[0, 10]", Arrays.toString(Stage4.getLongestAscendingSequence(mixed)));
		assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(Stage4.getLongestAscendingSequence(allZeroes)));
		assertEquals("[30, 30]", Arrays.toString(Stage4.getLongestAscendingSequence(new int[] {50, 40, 30, 30})));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getlongestunchangedsequence", marks = 1)
	public void testGetLongestUnchangedSequence()  {
		assertEquals(0, Stage4.getLongestUnchangedSequence(empty).length);
		assertEquals("[777]", Arrays.toString(Stage4.getLongestUnchangedSequence(singleItemArray)));
		assertEquals("[10]", Arrays.toString(Stage4.getLongestUnchangedSequence(tenMultiples)));
		assertEquals("[2, 2, 2]", Arrays.toString(Stage4.getLongestUnchangedSequence(new int[]{2, 2, 2, 3})));
		assertEquals("[3, 3, 3, 3, 3]", Arrays.toString(Stage4.getLongestUnchangedSequence(new int[]{2, 2, 2, 3, 3, 3, 3, 3})));
		assertEquals("[5, 5, 5, 5, 5, 5, 5, 5]", Arrays.toString(Stage4.getLongestUnchangedSequence(new int[]{2, 2, 2, 3, 3, 3, 3, 3, 2, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5})));
		assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(Stage4.getLongestUnchangedSequence(allZeroes)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sortdesc", marks = 1)
	public void testSortDesc()  {
		Stage4.sortDesc(null); //NullPointerException check
		Stage4.sortDesc(empty);
		assertEquals("[]", Arrays.toString(empty));
		Stage4.sortDesc(singleItemArray);
		assertEquals("[777]", Arrays.toString(singleItemArray));
		Stage4.sortDesc(tenMultiples);
		assertEquals("[90, 70, 20, 10]", Arrays.toString(tenMultiples));
		Stage4.sortDesc(nonNegsShort);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", Arrays.toString(nonNegsShort));
		Stage4.sortDesc(nonNegsLong);
		assertEquals("[5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0]", Arrays.toString(nonNegsLong));
		Stage4.sortDesc(positives);
		assertEquals("[10, 6, 5, 3, 2]", Arrays.toString(positives));
		Stage4.sortDesc(mixed);
		assertEquals("[12, 10, 5, 3, 2, 1, 0, -1, -2]", Arrays.toString(mixed));
		Stage4.sortDesc(allZeroes);
		assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(allZeroes));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sortifneeded", marks = 1)
	public void testSortIfNeeded()  {
		Stage4.sortIfNeeded(null, true); //NullPointerException check
		Stage4.sortIfNeeded(null, false); //NullPointerException check
		Stage4.sortIfNeeded(empty, true);
		assertEquals(0, empty.length);
		Stage4.sortIfNeeded(singleItemArray, false);
		assertEquals("[777]", Arrays.toString(singleItemArray));
		Stage4.sortIfNeeded(tenMultiples, true);
		assertEquals("[10, 20, 70, 90]", Arrays.toString(tenMultiples));
		Stage4.sortIfNeeded(nonNegsShort, false);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", Arrays.toString(nonNegsShort));
		Stage4.sortIfNeeded(nonNegsLong, true);
		assertEquals("[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5]", Arrays.toString(nonNegsLong));
		Stage4.sortIfNeeded(positives, false);
		assertEquals("[10, 6, 5, 3, 2]", Arrays.toString(positives));
		Stage4.sortIfNeeded(mixed, true);
		assertEquals("[-2, -1, 0, 1, 2, 3, 5, 10, 12]", Arrays.toString(mixed));
		Stage4.sortIfNeeded(allZeroes, false);
		assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(allZeroes));

		int[] buggy1 = {4, 7, 13, 28};
		Stage4.sortIfNeeded(buggy1, false);
		assertNotEquals("[28, 13, 7, 4]", Arrays.toString(buggy1));
		assertEquals("[4, 7, 13, 28]", Arrays.toString(buggy1));

		int[] buggy2 = {235, 96, 69, 35, 23};
		Stage4.sortIfNeeded(buggy2, true);
		assertNotEquals("[23, 35, 69, 96, 235]", Arrays.toString(buggy2));
		assertEquals("[235, 96, 69, 35, 23]", Arrays.toString(buggy2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getcommonitemssorted", marks = 1)
	public void testGetCommonItemsSorted()  {
		//First sort all the arrays
		Arrays.sort(tenMultiples);
		Arrays.sort(nonNegsShort);
		Arrays.sort(nonNegsLong);
		Arrays.sort(positives);
		Arrays.sort(mixed);
		Arrays.sort(allZeroes);

		assertEquals(0, Stage4.getCommonItemsSorted(tenMultiples, nonNegsShort).length); //no items in common

		assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(Stage4.getCommonItemsSorted(nonNegsShort, nonNegsLong))); //some items in common

		assertEquals("[2, 3, 5, 6, 10]", Arrays.toString(Stage4.getCommonItemsSorted(positives, positives))); //all items in common

		assertEquals("[0]", Arrays.toString(Stage4.getCommonItemsSorted(mixed, allZeroes))); //only 1 item in common

		assertEquals("[0, 0]", Arrays.toString(Stage4.getCommonItemsSorted(new int[] {0, 0}, new int[] {0, 0, 0})));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "nocommonitems", marks = 1)
	public void testNoCommonItems()  {
		assertTrue(Stage4.noCommonItems(new int[][]{empty, singleItemArray}));
		assertTrue(Stage4.noCommonItems(new int[][]{tenMultiples, nonNegsShort})); 
		assertFalse(Stage4.noCommonItems(new int[][]{nonNegsLong, positives})); 
		assertFalse(Stage4.noCommonItems(new int[][]{mixed, allZeroes}));
		assertFalse(Stage4.noCommonItems(new int[][]{tenMultiples, nonNegsShort, nonNegsLong})); 
		assertFalse(Stage4.noCommonItems(new int[][]{positives, mixed, allZeroes})); 

		int[] w = {1,2,3,4};
		int[] x = {5,6,7,8};
		int[] y = {9,10,11,12};
		int[] z = {13,14,15,16};
		assertTrue(Stage4.noCommonItems(new int[][]{w, x, y, z})); 

		x = null;
		assertTrue(Stage4.noCommonItems(new int[][]{w, x, y, z})); 

		z[3] = 10;
		assertFalse(Stage4.noCommonItems(new int[][]{w, x, y, z})); //because y and z have 10 in common
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getset", marks = 1)
	public void testGetSet()  {
		int[] a = null;
		assertNull(Stage4.getSet(a));

		a = new int[]{};
		int[] b = new int[]{};
		assertNotNull(Stage4.getSet(a));
		assertArrayEquals(b, Stage4.getSet(a));

		a = new int[]{5, 5, 7, 2, 2, 2, 2};
		b = new int[]{5, 7, 2};
		assertNotNull(Stage4.getSet(a));
		assertArrayEquals(b, Stage4.getSet(a));

		a = new int[]{10, 10, 3, 20, 20};
		b = new int[]{10, 3, 20};
		assertNotNull(Stage4.getSet(a));
		assertArrayEquals(b, Stage4.getSet(a));

		a = new int[]{6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 6 ,6 ,6, 6, 7, 6, 7, 6, 7, 6, 7, 6, 7, 6, 7};
		b = new int[]{6, 7};
		assertNotNull(Stage4.getSet(a));
		assertArrayEquals(b, Stage4.getSet(a));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "winner", marks = 1)
	public void testWinner()  {
		int[] results = new int[]{0,1,0,1,0,1,1,0,	0,1,0,1,	1,0};
		assertEquals(4, Stage4.winner(results));
		
		results = new int[]{0,1,0,1,0,1,1,0,	1,0,0,1,	1,0};
		assertEquals(2, Stage4.winner(results));
		
		results = new int[]{0,1,0,1,0,1,1,0,	0,1,0,1,	0,1};
		assertEquals(7, Stage4.winner(results));
		
		results = new int[]{0,1,0,1,0,1,0,1,	0,1,0,1,	0,1};
		assertEquals(8, Stage4.winner(results));
		
		results = new int[]{1,0,0,1,0,1,1,0,	1,0,0,1,	1,0};
		assertEquals(1, Stage4.winner(results));
		
		results = new int[]{1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1, 	1,0,0,1,0,1,1,0,	1,0,0,1,	0,1};
		assertEquals(14, Stage4.winner(results));
		
		results = new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1, 	0,1,0,1,0,1,0,1,	0,1,0,1,	0,1};
		assertEquals(16, Stage4.winner(results));
		
		results = new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0, 	1,0,1,0,1,0,1,0,	1,0,1,0,	1,0};
		assertEquals(1, Stage4.winner(results));
		
		results = new int[510];
		for(int i=1; i < results.length; i+=2) {
			results[i] = 1;
		}
		assertEquals(256, Stage4.winner(results));

		
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
