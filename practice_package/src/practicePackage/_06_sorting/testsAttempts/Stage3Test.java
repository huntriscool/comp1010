package practicePackage._06_sorting.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import practicePackage._06_sorting.attempts.*;

public class Stage3Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "sort2dinto1d", marks = 1)
	public void testSort2Dinto1D()  {
		assertNull(Stage3.sort2Dinto1D(null));
		assertEquals("[1, 2, 7, 10, 20, 70, 200, 300, 400]",
				Arrays.toString(Stage3.sort2Dinto1D(new int[][] { { 2, 7, 1 }, { 20, 70, 10 }, { 300, 200, 400 } })));
		assertEquals("[1, 2, 7, 10, 20, 70, 200, 300, 400]",
				Arrays.toString(Stage3.sort2Dinto1D(new int[][] { { 2, 70, 1 }, { 20, 7, 10 }, { 300, 200, 400 } })));
		assertEquals("[10, 15, 20, 40, 70, 90]",
				Arrays.toString(Stage3.sort2Dinto1D(new int[][] { { 20, 70 }, { 10 }, { 15, 90, 40 } })));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sort", marks = 1)
	public void testSort()  {
		Unit a = new Unit("COMP1010", 400);
		Unit b = new Unit("COMP1000", 1000);
		Unit c = new Unit("COMP1350", 1000);
		Unit d = new Unit("STAT1070", 1500);
		Unit e = new Unit("COMP1000", 1000);
		Unit[] data = new Unit[] { a, d, c };
		assertEquals("[STAT1070: 1500, COMP1350: 1000, COMP1010: 400]", Arrays.toString(Stage3.sort(data)));
		data = new Unit[] { b, d, c, a, e };
		assertEquals("[STAT1070: 1500, COMP1350: 1000, COMP1000: 1000, COMP1000: 1000, COMP1010: 400]",
				Arrays.toString(Stage3.sort(data)));
		assertFalse(data[1] == e, "Should be b since b occured before e in the array");
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sortoddeven", marks = 1)
	public void testSortOddEven()  {
		assertNull(Stage3.sortOddEven(null));
		assertEquals("[10, 20, 70]", Arrays.toString(Stage3.sortOddEven(new int[] { 20, 70, 10 })));
		assertEquals("[-75, 15, 25]", Arrays.toString(Stage3.sortOddEven(new int[] { 25, -75, 15 })));
		assertEquals("[4, 10, 20, 70, 5, 11]", Arrays.toString(Stage3.sortOddEven(new int[] { 11, 20, 5, 70, 10, 4 })));
		assertEquals("[-4, 10, 20, 70, -11, -5]",
				Arrays.toString(Stage3.sortOddEven(new int[] { -4, 20, 70, -5, 10, -11 })));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sortascending", marks = 1)
	public void testSortAscending()  {
		assertNull(Stage3.sortAscending(null));
		assertEquals("[[1, 2, 7], [10, 20, 70], [200, 300, 400]]", Arrays
				.deepToString(Stage3.sortAscending(new int[][] { { 2, 7, 1 }, { 20, 70, 10 }, { 300, 200, 400 } })));
		assertEquals("[[1, 2, 7], [10, 20, 70], [200, 300, 400]]", Arrays
				.deepToString(Stage3.sortAscending(new int[][] { { 2, 70, 1 }, { 20, 7, 10 }, { 300, 200, 400 } })));
		assertEquals("[[10, 15], [20], [40, 70, 90]]",
				Arrays.deepToString(Stage3.sortAscending(new int[][] { { 20, 70 }, { 10 }, { 15, 90, 40 } })));

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
