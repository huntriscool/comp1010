package practicePackage._02_arrays.testsAttempts;

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

import practicePackage._02_arrays.attempts.Stage3;

public class Stage3Test {
	private int[] empty;
	private int[] singleItemArray;
	private int[] multiplesTen1;
	private int[] multiplesTen2;
	private int[] reverseMultiplesTen;
	private int[] mixedPosNeg;
	private int[] allZeroes1;
	private int[] allZeroes2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		empty = new int[]{};
		singleItemArray = new int[]{777};
		multiplesTen1 = new int[]{10, 70, 20, 90};
		multiplesTen2 = new int[]{10, 70, 20, 90};
		reverseMultiplesTen = new int[]{90, 20, 70, 10};
		mixedPosNeg = new int[]{-50, 30, -20, 0, 20, -30, 50};
		allZeroes1 = new int[]{0, 0, 0, 0, 0};
		allZeroes2 = new int[]{0, 0, 0, 0, 0};
		currentMethodName = null;
	}

	@Test @Graded(description = "countuniqueitems", marks = 1)
	public void testCountUniqueItems()  {
		assertEquals(0, Stage3.countUniqueItems(null));
		assertEquals(0, Stage3.countUniqueItems(empty));
		assertEquals(1, Stage3.countUniqueItems(singleItemArray));
		assertEquals(4, Stage3.countUniqueItems(multiplesTen1));
		assertEquals(0, Stage3.countUniqueItems(allZeroes1));
		assertEquals(1, Stage3.countUniqueItems(new int[] {10,20,30,40,40,30,20,10,50}));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "contains", marks = 1)
	public void testContains()  {
		assertFalse(Stage3.contains(multiplesTen1, null));
		assertFalse(Stage3.contains(null, multiplesTen2));
		assertFalse(Stage3.contains(null, null));
		assertFalse(Stage3.contains(empty, singleItemArray));
		assertTrue(Stage3.contains(singleItemArray, empty));
		assertTrue(Stage3.contains(multiplesTen1, multiplesTen2));
		assertTrue(Stage3.contains(multiplesTen2, multiplesTen1));
		assertTrue(Stage3.contains(multiplesTen1, reverseMultiplesTen));
		assertTrue(Stage3.contains(reverseMultiplesTen, multiplesTen1));
		int[] arr = {10, -70, 20, -90, 90, -20, 70, -10};
		assertTrue(Stage3.contains(arr, multiplesTen1));
		assertTrue(Stage3.contains(arr, multiplesTen2));
		assertTrue(Stage3.contains(arr, reverseMultiplesTen));
		assertTrue(Stage3.contains(allZeroes1, allZeroes2));
		assertTrue(Stage3.contains(allZeroes2, allZeroes1));
		
		int[] arr1 = {10, -70, 20, -90, 90, -20, 70, -10};
		int[] arr2 = {-70, 1};
		assertFalse(Stage3.contains(arr1, arr2));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "mutuallyreverse", marks = 1)
	public void testMutuallyReverse()  {
		assertFalse(Stage3.mutuallyReverse(reverseMultiplesTen, null));
		assertFalse(Stage3.mutuallyReverse(null, mixedPosNeg));
		assertFalse(Stage3.mutuallyReverse(null, null));
		assertFalse(Stage3.mutuallyReverse(empty, singleItemArray));
		assertTrue(Stage3.mutuallyReverse(multiplesTen1, reverseMultiplesTen));
		assertTrue(Stage3.mutuallyReverse(reverseMultiplesTen, multiplesTen2));
		assertFalse(Stage3.mutuallyReverse(multiplesTen1, multiplesTen2));
		assertFalse(Stage3.mutuallyReverse(multiplesTen1, new int[]{90, 70, 20, 10}));
		assertFalse(Stage3.mutuallyReverse(multiplesTen2, new int[]{90, 20, 70}));
		assertFalse(Stage3.mutuallyReverse(multiplesTen1, new int[]{90, 20}));
		assertFalse(Stage3.mutuallyReverse(multiplesTen2, new int[]{90})); 
		assertTrue(Stage3.mutuallyReverse(allZeroes1, allZeroes2));
		assertTrue(Stage3.mutuallyReverse(allZeroes2, allZeroes1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "generate", marks = 1)
	public void testGenerate()  {
		assertNull(Stage3.generate(-1));
		assertEquals(0, Stage3.generate(0).length);
		assertEquals(235, Stage3.generate(235).length);
		assertEquals("[1, 2]", Arrays.toString(Stage3.generate(2)));
		assertNotEquals("[0, 1, 2]", Arrays.toString(Stage3.generate(3)));
		assertNotEquals("[2, 3, 4, 5, 6]", Arrays.toString(Stage3.generate(5)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getmostfrequentitem", marks = 1)
	public void testGetMostFrequentItem()  {
		assertEquals(2, Stage3.getMostFrequentItem(new int[]{1, 2, 2, 3, 5, 2, 2, 7}));
		assertEquals(3, Stage3.getMostFrequentItem(new int[]{3, 5, 7, 9, 11, 13, 5, 3}));
		assertEquals(5, Stage3.getMostFrequentItem(new int[]{5, 5, 5, 5, 5, 5, 5, 5}));
		assertEquals(1, Stage3.getMostFrequentItem(new int[]{1, 2, 3, 4, 5, 6, 7}));
		assertEquals(1, Stage3.getMostFrequentItem(new int[]{1, 2, 2, 1, 3, 4, 5, 6, 7}));
		assertEquals(7, Stage3.getMostFrequentItem(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7}));
		assertEquals(7, Stage3.getMostFrequentItem(new int[]{1, 2, 4, 5, 6, 7, 7, 7, 7, 7, 5, 5}));
		assertEquals(7, Stage3.getMostFrequentItem(new int[]{1, 2, 4, 7, 6, 7, 7, 5, 7, 5, 5, 5}));
        assertEquals(2, Stage3.getMostFrequentItem(new int[]{1, 2, 4, 7,7,2,5}));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getfrequencytable", marks = 1)
	public void testGetFrequencyTable()  {
		assertNull(Stage3.getFrequencyTable(null));
		assertNotNull(Stage3.getFrequencyTable(empty));
		assertEquals(0, Stage3.getFrequencyTable(empty).length);
		assertNotNull(Stage3.getFrequencyTable(singleItemArray));
		assertEquals("[1]", Arrays.toString(Stage3.getFrequencyTable(singleItemArray)));
		assertNotNull(Stage3.getFrequencyTable(mixedPosNeg));
		assertEquals("[1, 1, 1, 1, 1, 1, 1]", Arrays.toString(Stage3.getFrequencyTable(mixedPosNeg)));
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(Stage3.getFrequencyTable(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5})));
		assertEquals("[2, 3, 5]", Arrays.toString(Stage3.getFrequencyTable(new int[]{4, 7, 13, 13, 7, 13, 13, 13, 7, 4})));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "subarrayuptoindex", marks = 1)
	public void testSubarrayUptoIndex()  {
		assertNull(Stage3.subarrayUptoIndex(null, 69));
		assertNull(Stage3.subarrayUptoIndex(empty, 96));
		assertNull(Stage3.subarrayUptoIndex(multiplesTen1, -1));
		assertNull(Stage3.subarrayUptoIndex(multiplesTen2, 4));
		assertEquals("[90, 20, 70, 10]", Arrays.toString(Stage3.subarrayUptoIndex(reverseMultiplesTen, 3)));
		assertEquals("[-50]", Arrays.toString(Stage3.subarrayUptoIndex(mixedPosNeg, 0)));
		assertEquals("[0, 0]", Arrays.toString(Stage3.subarrayUptoIndex(allZeroes1, 1)));
		assertEquals("[0, 0, 0]", Arrays.toString(Stage3.subarrayUptoIndex(allZeroes2, 2)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getpositives", marks = 1)
	public void testGetPositives()  {
		assertNull(Stage3.getPositives(null)); 
		assertEquals(0, Stage3.getPositives(empty).length); 
		assertEquals(Arrays.toString(multiplesTen1), Arrays.toString(Stage3.getPositives(multiplesTen2)));
		assertEquals(Arrays.toString(multiplesTen2), Arrays.toString(Stage3.getPositives(multiplesTen1)));
		assertEquals(Arrays.toString(reverseMultiplesTen), Arrays.toString(Stage3.getPositives(reverseMultiplesTen)));
		assertNotEquals("[30, 0, 20, 50]", Arrays.toString(Stage3.getPositives(mixedPosNeg)));
		assertEquals("[30, 20, 50]", Arrays.toString(Stage3.getPositives(mixedPosNeg)));
		assertEquals(0, Stage3.getPositives(allZeroes1).length);
		assertEquals(0, Stage3.getPositives(allZeroes2).length);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getnonzeroes", marks = 1)
	public void testGetNonZeroes()  {
		assertNull(Stage3.getNonZeroes(null));
		assertEquals(0, Stage3.getNonZeroes(empty).length);
		assertEquals("[10, 70, 20, 90]", Arrays.toString(Stage3.getNonZeroes(multiplesTen1)));
		assertEquals("[10, 70, 20, 90]", Arrays.toString(Stage3.getNonZeroes(multiplesTen2)));
		assertEquals("[90, 20, 70, 10]", Arrays.toString(Stage3.getNonZeroes(reverseMultiplesTen)));
		assertEquals("[-50, 30, -20, 20, -30, 50]", Arrays.toString(Stage3.getNonZeroes(mixedPosNeg)));
		assertEquals(0, Stage3.getNonZeroes(allZeroes1).length);
		assertEquals(0, Stage3.getNonZeroes(allZeroes2).length);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getwithoutnegatives", marks = 1)
	public void testGetWithoutNegatives()  {
		assertNull(Stage3.getWithoutNegatives(null)); 
		assertEquals(0, Stage3.getWithoutNegatives(empty).length); 
		assertEquals(Arrays.toString(multiplesTen1), Arrays.toString(Stage3.getWithoutNegatives(multiplesTen2)));
		assertEquals(Arrays.toString(multiplesTen2), Arrays.toString(Stage3.getWithoutNegatives(multiplesTen1)));
		assertEquals(Arrays.toString(reverseMultiplesTen), Arrays.toString(Stage3.getWithoutNegatives(reverseMultiplesTen)));
		assertNotEquals("[30, 20, 50]", Arrays.toString(Stage3.getWithoutNegatives(mixedPosNeg)));
		assertEquals("[30, 0, 20, 50]", Arrays.toString(Stage3.getWithoutNegatives(mixedPosNeg)));
		assertEquals(Arrays.toString(allZeroes1), Arrays.toString(Stage3.getWithoutNegatives(allZeroes2)));
		assertEquals(Arrays.toString(allZeroes2), Arrays.toString(Stage3.getWithoutNegatives(allZeroes1)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "itemremovedneighbourhood", marks = 1)
	public void testItemRemovedNeighbourhood()  {
		assertNull(Stage3.itemRemovedNeighbourhood(null, 0));
		int[] data = {10,70,70,70,20,90,70};

		int[] result = Stage3.itemRemovedNeighbourhood(data, -1);
		assertEquals("[10, 70, 70, 70, 20, 90, 70]", Arrays.toString(result));
		assertNotEquals(data, result); //we want instance copy

		result = Stage3.itemRemovedNeighbourhood(data, data.length);
		assertEquals("[10, 70, 70, 70, 20, 90, 70]", Arrays.toString(result));
		assertNotEquals(data, result); //we want instance copy

		result = Stage3.itemRemovedNeighbourhood(data, 2);
		assertEquals("[10, 20, 90, 70]", Arrays.toString(result));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getdeepcopy", marks = 1)
	public void testGetDeepCopy()  {
		assertNull(Stage3.getDeepCopy(null));
		assertEquals(0, Stage3.getDeepCopy(new int[][]{}).length);
		int[][] temp = new int[][]{multiplesTen1, reverseMultiplesTen, allZeroes1};
		assertNotEquals(multiplesTen1, Stage3.getDeepCopy(temp)[0]);
		assertNotEquals(reverseMultiplesTen, Stage3.getDeepCopy(temp)[1]);
		assertNotEquals(allZeroes1, Stage3.getDeepCopy(temp)[2]);
		assertEquals(Arrays.toString(multiplesTen2), Arrays.toString(Stage3.getDeepCopy(temp)[0]));
		assertEquals(Arrays.toString(reverseMultiplesTen), Arrays.toString(Stage3.getDeepCopy(temp)[1]));
		assertEquals(Arrays.toString(allZeroes2), Arrays.toString(Stage3.getDeepCopy(temp)[2]));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "lastindexof", marks = 1)
	public void testLastIndexOf()  {
		assertEquals(-1, Stage3.lastIndexOf(empty, singleItemArray));
		assertEquals(-1, Stage3.lastIndexOf(multiplesTen2, new int[]{0, 10, 70, 20, 90}));
		assertEquals(0, Stage3.lastIndexOf(multiplesTen2, multiplesTen1));
		assertEquals(1, Stage3.lastIndexOf(multiplesTen1, new int[]{70, 20}));
		assertEquals(-1, Stage3.lastIndexOf(mixedPosNeg, reverseMultiplesTen));
		assertEquals(3, Stage3.lastIndexOf(mixedPosNeg, new int[]{0}));
		assertEquals(12, Stage3.lastIndexOf(new int[]{23, 35, 90, 20, 70, 10, 69, 90, 20, 70, 10, 96, 90, 20, 70, 10, 13, 4, 7, 13}, reverseMultiplesTen));
		assertEquals(0, Stage3.lastIndexOf(allZeroes1, allZeroes2));
		assertEquals(0, Stage3.lastIndexOf(allZeroes2, allZeroes1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofevenitems", marks = 1)
	public void testTotalNumberOfEvenItems()  {
		assertEquals(0, Stage3.totalNumberOfEvenItems(null));

		int[][] multi1 = new int[][]{{}};
		assertEquals(0, Stage3.totalNumberOfEvenItems(multi1));

		int[][] multi2 = new int[][]{{777}};
		assertEquals(0, Stage3.totalNumberOfEvenItems(multi2));

		int[][] multi3 = new int[][]{{0, 1}, {2, 3, 5}, {4, 6, 8, 7, 9}};
		assertEquals(5, Stage3.totalNumberOfEvenItems(multi3));

		int[][] multi4 = new int[][]{null, {4, 7, 13, 28}, null, {10, 70, 20, 90}};     
		assertEquals(6, Stage3.totalNumberOfEvenItems(multi4));

		int[][] multi5 = new int[][]{null, null, null, null, null};	     
		assertEquals(0, Stage3.totalNumberOfEvenItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofpositiveitems", marks = 1)
	public void testTotalNumberOfPositiveItems()  {
		assertEquals(0, Stage3.totalNumberOfPositiveItems(null));

		int[][] multi1 = new int[][]{{}};
		assertEquals(0, Stage3.totalNumberOfPositiveItems(multi1));

		int[][] multi2 = new int[][]{{777}};
		assertEquals(1, Stage3.totalNumberOfPositiveItems(multi2));

		int[][] multi3 = new int[][]{{0, -1}, {-2, 3, -5}, {4, -6, 8, -7, 9}};
		assertEquals(4, Stage3.totalNumberOfPositiveItems(multi3));

		int[][] multi4 = new int[][]{null, {4, -7, 13, -28}, null, {-10, 70, -20, 90}};     
		assertEquals(4, Stage3.totalNumberOfPositiveItems(multi4));

		int[][] multi5 = new int[][]{null, null, null, null, null};	     
		assertEquals(0, Stage3.totalNumberOfPositiveItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofuniqueitems", marks = 1)
	public void testTotalNumberOfUniqueItems()  {
		assertEquals(0, Stage3.totalNumberOfUniqueItems(null));

		int[][] multi1 = new int[][]{{}};
		assertEquals(0, Stage3.totalNumberOfUniqueItems(multi1));

		int[][] multi2 = new int[][]{{777}};
		assertEquals(1, Stage3.totalNumberOfUniqueItems(multi2));

		int[][] multi3 = new int[][]{{0, -1}, {-2, 3, -5}, {4, -6, 8, -7, 9}};
		assertEquals(10, Stage3.totalNumberOfUniqueItems(multi3));

		int[][] multi4 = new int[][]{null, {2, 4, 2, -7, 3, 13, 3, -28}, null, {0, -10, 0, 70, 5, -20, 5, 90}};     
		assertEquals(8, Stage3.totalNumberOfUniqueItems(multi4));

		int[][] multi5 = new int[][]{null, null, null, null, null};	     
		assertEquals(0, Stage3.totalNumberOfUniqueItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countnonnullsubarrays", marks = 1)
	public void testCountNonNullSubarrays()  {
		assertEquals(0, Stage3.countNonNullSubarrays(null));

		int[][] multi1 = new int[][]{{}};
		assertEquals(1, Stage3.countNonNullSubarrays(multi1));

		int[][] multi2 = new int[][]{{777}};
		assertEquals(1, Stage3.countNonNullSubarrays(multi2));

		int[][] multi3 = new int[][]{{0, 1}, {2, 3, 5}, {4, 6, 8, 7, 9}};
		assertEquals(3, Stage3.countNonNullSubarrays(multi3));

		int[][] multi4 = new int[][]{null, {4, 7, 13, 28}, null, {10, 70, 20, 90}};
		assertEquals(2, Stage3.countNonNullSubarrays(multi4));

		int[][] multi5 = new int[][]{null, null, null, null, null};
		assertEquals(0, Stage3.countNonNullSubarrays(multi5));
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
