package practicePackage._05_arrayList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._05_arrayList.attempts.*;
import serviceClasses.Rectangle;
import practicePackage._05_arrayList.attempts.*;

@SuppressWarnings("unused")
public class Stage3Test {	
	public ArrayList<Integer> nullList, emptyList, singleItemList, list1, list2;

	public ArrayList<Integer> multiplesTen1, multiplesTen2, reverseMultiplesTen, mixedPosNeg, allZeroes1, allZeroes2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(777));
		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
		multiplesTen1 = new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90));
		multiplesTen2 = new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90));
		reverseMultiplesTen = new ArrayList<Integer>(Arrays.asList(90, 20, 70, 10));
		mixedPosNeg = new ArrayList<Integer>(Arrays.asList(-50, 30, -20, 0, 20, -30, 50));
		allZeroes1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		allZeroes2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		currentMethodName = null;
	}

	@Test @Graded(description = "secondlastindexof", marks = 1)
	public void testSecondLastIndexOf()  {
		assertEquals(-1, Stage3.secondLastIndexOf(null, 65));
		assertEquals(-1, Stage3.secondLastIndexOf(emptyList, 96));
		assertEquals(-1, Stage3.secondLastIndexOf(singleItemList, -7));
		assertEquals(-1, Stage3.secondLastIndexOf(singleItemList, 1));
		assertEquals(-1, Stage3.secondLastIndexOf(multiplesTen1, 10));
		assertEquals(-1, Stage3.secondLastIndexOf(multiplesTen1, 70));
		assertEquals(-1, Stage3.secondLastIndexOf(multiplesTen1, 20));
		assertEquals(-1, Stage3.secondLastIndexOf(multiplesTen1, 90));
		assertEquals(3, Stage3.secondLastIndexOf(allZeroes1, 0));
		ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(10,70,20,90,70,30,10,10,10,70));
		assertEquals(4, Stage3.secondLastIndexOf(temp, 70));
		assertEquals(7, Stage3.secondLastIndexOf(temp, 10));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "removenegatives", marks = 1)
	public void testRemoveNegatives()  {
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		//a whole lot of -6s at the end
		Stage3.removeNegatives(list2);
		assertEquals("[0, 8, 9, 15, 23, 5]", list2.toString());
		Stage3.removeNegatives(singleItemList);
		assertEquals("[777]", singleItemList.toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "threeinarow", marks = 1)
	public void testThreeInARow()  {
		assertFalse(Stage3.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,5,0,5,5));
		assertFalse(Stage3.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,5,5,5));
		assertTrue(Stage3.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,5,5));
		assertFalse(Stage3.threeInARow(list1, 5));		

		list1 = new ArrayList<Integer>(Arrays.asList(5,5,5,8,3));
		assertTrue(Stage3.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,5,5,5,5,5,5,4,3,2,1));
		assertTrue(Stage3.threeInARow(list1, 5));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "allunique", marks = 1)
	public void testAllUnique()  {
		assertTrue(Stage3.allUnique(list1));
		assertTrue(Stage3.allUnique(list2));
		assertTrue(Stage3.allUnique(singleItemList));
		assertTrue(Stage3.allUnique(emptyList));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, -5));
		assertFalse(Stage3.allUnique(list2));
		list2 = new ArrayList<Integer>(Arrays.asList(0, 8, -7, 9, 15, 23, -1, -5, -5));
		assertFalse(Stage3.allUnique(list2));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "generatepatternedarray", marks = 1)
	public void testGeneratePatternedArray()  {
		assertNull(Stage3.generatePatternedArray(-1, 2, 5));

		assertNotNull(Stage3.generatePatternedArray(0, 2, 5));
		assertEquals("[]", Stage3.generatePatternedArray(0, 2, 5).toString());

		assertNotNull(Stage3.generatePatternedArray(5, 2, 3));
		assertEquals("[2, 5, 8, 11, 14]", Stage3.generatePatternedArray(5, 2, 3).toString());

		assertNotNull(Stage3.generatePatternedArray(7, 0, -3));
		assertEquals("[0, -3, -6, -9, -12, -15, -18]", Stage3.generatePatternedArray(7, 0, -3).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "identical", marks = 1)
	public void testIdentical()  {
		assertFalse(Stage3.identical(multiplesTen1, null));
		assertFalse(Stage3.identical(null, multiplesTen2));
		assertFalse(Stage3.identical(null, null));
		assertFalse(Stage3.identical(emptyList, singleItemList));
		assertTrue(Stage3.identical(multiplesTen1, multiplesTen2));
		assertTrue(Stage3.identical(multiplesTen2, multiplesTen1));
		assertFalse(Stage3.identical(multiplesTen1, new ArrayList<Integer>(Arrays.asList(10, 20, 70, 90))));
		assertFalse(Stage3.identical(multiplesTen2, new ArrayList<Integer>(Arrays.asList(10, 70, 20))));
		assertFalse(Stage3.identical(multiplesTen1, new ArrayList<Integer>(Arrays.asList(10, 70))));
		assertFalse(Stage3.identical(multiplesTen2, new ArrayList<Integer>(Arrays.asList(10))));
		assertTrue(Stage3.identical(allZeroes1, allZeroes2));
		assertTrue(Stage3.identical(allZeroes2, allZeroes1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "same", marks = 1)
	public void testSame()  {
		assertFalse(Stage3.same(multiplesTen1, null));
		assertFalse(Stage3.same(null, multiplesTen2));
		assertFalse(Stage3.same(null, null));
		assertFalse(Stage3.same(emptyList, singleItemList));
		assertFalse(Stage3.same(singleItemList, emptyList));
		assertTrue(Stage3.same(multiplesTen1, multiplesTen2));
		assertTrue(Stage3.same(multiplesTen2, multiplesTen1));
		assertTrue(Stage3.same(multiplesTen1, reverseMultiplesTen));
		assertTrue(Stage3.same(reverseMultiplesTen, multiplesTen1));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, -70, 20, -90, 90, -20, 70, -10));
		assertFalse(Stage3.same(list, multiplesTen1));
		assertFalse(Stage3.same(list, multiplesTen2));
		assertFalse(Stage3.same(list, reverseMultiplesTen));
		assertTrue(Stage3.same(allZeroes1, allZeroes2));
		assertTrue(Stage3.same(allZeroes2, allZeroes1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "generate", marks = 1)
	public void testGenerate()  {
		assertNull(Stage3.generate(-1));
		assertNotNull(Stage3.generate(0));
		assertEquals(0, Stage3.generate(0).size());
		assertEquals(235, Stage3.generate(235).size());
		assertEquals("[1, 2]", Stage3.generate(2).toString());
		assertNotEquals("[0, 1, 2]", Stage3.generate(3).toString());
		assertNotEquals("[2, 3, 4, 5, 6]", Stage3.generate(5).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getfrequencytable", marks = 1)
	public void testGetFrequencyTable()  {
		assertNull(Stage3.getFrequencyTable(null));
		assertNotNull(Stage3.getFrequencyTable(emptyList));
		assertEquals(0, Stage3.getFrequencyTable(emptyList).size());
		assertNotNull(Stage3.getFrequencyTable(singleItemList));
		assertEquals("[[777, 1]]", Stage3.getFrequencyTable(singleItemList).toString());
		assertNotNull(Stage3.getFrequencyTable(mixedPosNeg));
		assertEquals("[[-50, 1], [30, 1], [-20, 1], [0, 1], [20, 1], [-30, 1], [50, 1]]", Stage3.getFrequencyTable(mixedPosNeg).toString());
		assertEquals("[[4, 2], [7, 3], [13, 5]]", Stage3.getFrequencyTable(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 13, 7, 13, 13, 13, 7, 4))).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getmostfrequentitem", marks = 1)
	public void testGetMostFrequentItem()  {
		assertEquals(2, Stage3.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 5, 2, 2, 7))));
		assertEquals(3, Stage3.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(3, 5, 7, 9, 11, 13, 5, 3))));
		assertEquals(5, Stage3.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5))));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sublistuptoindex", marks = 1)
	public void testSublistUptoIndex()  {
		assertNull(Stage3.sublistUptoIndex(null, 69));
		assertNull(Stage3.sublistUptoIndex(emptyList, 96));
		assertNull(Stage3.sublistUptoIndex(multiplesTen1, -1));
		assertNull(Stage3.sublistUptoIndex(multiplesTen2, 4));
		assertNotNull(Stage3.sublistUptoIndex(reverseMultiplesTen, 3));
		assertEquals("[90, 20, 70, 10]", Stage3.sublistUptoIndex(reverseMultiplesTen, 3).toString());
		assertEquals("[-50]", Stage3.sublistUptoIndex(mixedPosNeg, 0).toString());
		assertEquals("[0, 0]", Stage3.sublistUptoIndex(allZeroes1, 1).toString());
		assertEquals("[0, 0, 0]", Stage3.sublistUptoIndex(allZeroes2, 2).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getnegatives", marks = 1)
	public void testGetNegatives()  {
		assertNull(Stage3.getNegatives(null)); 
		assertNotNull(Stage3.getNegatives(emptyList)); 
		assertEquals(0, Stage3.getNegatives(emptyList).size()); 
		assertEquals(0, Stage3.getNegatives(multiplesTen1).size());
		assertEquals(0, Stage3.getNegatives(multiplesTen2).size());
		assertEquals(0, Stage3.getNegatives(reverseMultiplesTen).size());
		assertNotEquals("[-50, -20, 0, -30]", Stage3.getNegatives(mixedPosNeg).toString());
		assertEquals("[-50, -20, -30]", Stage3.getNegatives(mixedPosNeg).toString());
		assertEquals(0, Stage3.getNegatives(allZeroes1).size());
		assertEquals(0, Stage3.getNegatives(allZeroes2).size());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getprimes", marks = 1)
	public void testGetPrimes()  {
		assertNull(Stage3.getPrimes(null)); 
		assertNotNull(Stage3.getPrimes(emptyList)); 
		assertEquals(0, Stage3.getPrimes(emptyList).size()); 
		assertEquals(0, Stage3.getPrimes(mixedPosNeg).size());
		assertEquals("[2, 3, 5]", Stage3.getPrimes(new ArrayList<Integer>(Arrays.asList(2, 3, 5))).toString());
		assertEquals("[7]", Stage3.getPrimes(new ArrayList<Integer>(Arrays.asList(0, 1, 4, 6, 7, 8, 9))).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getwithoutpositives", marks = 1)
	public void testGetWithoutPositives()  {
		assertNull(Stage3.getWithoutPositives(null)); 
		assertNotNull(Stage3.getWithoutPositives(emptyList)); 
		assertEquals(0, Stage3.getWithoutPositives(emptyList).size()); 
		assertEquals(0, Stage3.getWithoutPositives(multiplesTen1).size());
		assertEquals(0, Stage3.getWithoutPositives(multiplesTen2).size());
		assertEquals(0, Stage3.getWithoutPositives(reverseMultiplesTen).size());
		assertNotEquals("[-50, -20, -30]", Stage3.getWithoutPositives(mixedPosNeg).toString());
		assertEquals("[-50, -20, 0, -30]", Stage3.getWithoutPositives(mixedPosNeg).toString());
		assertEquals(allZeroes1.toString(), Stage3.getWithoutPositives(allZeroes2).toString());
		assertEquals(allZeroes2.toString(), Stage3.getWithoutPositives(allZeroes1).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getcopy", marks = 1)
	public void testGetCopy()  {
		assertNull(Stage3.getCopy(null));
		assertNotNull(Stage3.getCopy(new ArrayList<ArrayList<Integer>>()));
		assertEquals(0, Stage3.getCopy(new ArrayList<ArrayList<Integer>>()).size());
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(Arrays.asList(multiplesTen1, reverseMultiplesTen, allZeroes1));
		assertNotSame(multiplesTen1, Stage3.getCopy(temp).get(0));
		assertNotSame(reverseMultiplesTen, Stage3.getCopy(temp).get(1));
		assertNotSame(allZeroes1, Stage3.getCopy(temp).get(2));
		assertNotNull(Stage3.getCopy(temp));
		assertNotNull(Stage3.getCopy(temp).get(0));
		assertEquals(multiplesTen2.toString(), Stage3.getCopy(temp).get(0).toString());
		assertEquals(reverseMultiplesTen.toString(), Stage3.getCopy(temp).get(1).toString());
		assertEquals(allZeroes2.toString(), Stage3.getCopy(temp).get(2).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "lastindexof", marks = 1)
	public void testLastIndexOf()  {
		assertEquals(-1, Stage3.lastIndexOf(emptyList, singleItemList));
		assertEquals(-1, Stage3.lastIndexOf(multiplesTen2, new ArrayList<Integer>(Arrays.asList(0, 10, 70, 20, 90))));
		assertEquals(0, Stage3.lastIndexOf(multiplesTen2, multiplesTen1));
		assertEquals(1, Stage3.lastIndexOf(multiplesTen1, new ArrayList<Integer>(Arrays.asList(70, 20))));
		assertEquals(-1, Stage3.lastIndexOf(mixedPosNeg, reverseMultiplesTen));
		assertEquals(3, Stage3.lastIndexOf(mixedPosNeg, new ArrayList<Integer>(Arrays.asList(0))));
		assertEquals(12, Stage3.lastIndexOf(new ArrayList<Integer>(Arrays.asList(23, 35, 90, 20, 70, 10, 69, 90, 20, 70, 10, 96, 90, 20, 70, 10, 13, 4, 7, 13)), reverseMultiplesTen));
		assertEquals(0, Stage3.lastIndexOf(allZeroes1, allZeroes2));
		assertEquals(0, Stage3.lastIndexOf(allZeroes2, allZeroes1));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofevenitems", marks = 1)
	public void testTotalNumberOfEvenItems()  {
		assertEquals(0, Stage3.totalNumberOfEvenItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, 6, 8, 7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90)));

		assertEquals(0, Stage3.totalNumberOfEvenItems(multi1));
		assertEquals(0, Stage3.totalNumberOfEvenItems(multi2));
		assertEquals(5, Stage3.totalNumberOfEvenItems(multi3));
		assertEquals(6, Stage3.totalNumberOfEvenItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, Stage3.totalNumberOfEvenItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofpositiveitems", marks = 1)
	public void testTotalNumberOfPositiveItems()  {
		assertEquals(0, Stage3.totalNumberOfPositiveItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, -13, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(-10, 0, 20, 90)));


		assertEquals(0, Stage3.totalNumberOfPositiveItems(multi1));
		assertEquals(1, Stage3.totalNumberOfPositiveItems(multi2));
		assertEquals(4, Stage3.totalNumberOfPositiveItems(multi3));
		assertEquals(4, Stage3.totalNumberOfPositiveItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, Stage3.totalNumberOfPositiveItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "totalnumberofuniqueitems", marks = 1)
	public void testTotalNumberOfUniqueItems()  {
		assertEquals(0, Stage3.totalNumberOfUniqueItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(2, 4, 2, -7, 3, 13, 3, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(0, -10, 0, 70, 5, -20, 5, 90)));


		assertEquals(0, Stage3.totalNumberOfUniqueItems(multi1));
		assertEquals(1, Stage3.totalNumberOfUniqueItems(multi2));
		assertEquals(10, Stage3.totalNumberOfUniqueItems(multi3));
		assertEquals(8, Stage3.totalNumberOfUniqueItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, Stage3.totalNumberOfUniqueItems(multi5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countnonnullsublists", marks = 1)
	public void testCountNonNullSublists()  {
		assertEquals(0, Stage3.countNonNullSublists(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(2, 4, 2, -7, 3, 13, 3, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(0, -10, 0, 70, 5, -20, 5, 90)));

		assertEquals(0, Stage3.countNonNullSublists(multi1));
		assertEquals(1, Stage3.countNonNullSublists(multi2));
		assertEquals(3, Stage3.countNonNullSublists(multi3));
		assertEquals(2, Stage3.countNonNullSublists(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));
		assertEquals(0, Stage3.countNonNullSublists(multi5));
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
