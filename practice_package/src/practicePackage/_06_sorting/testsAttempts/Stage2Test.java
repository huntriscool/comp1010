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

public class Stage2Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "swaptorightplace", marks = 1)
	public void testSwapToRightPlace()  {
		assertNull(Stage2.swapToRightPlace(null, 0));
		assertEquals("[20, 70, 40, 90, 30, 80, 20]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 40, 70, 20, 90, 30, 80, 20 }, 0)));
		assertEquals("[20, 20, 40, 90, 30, 80, 70]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 70, 40, 90, 30, 80, 20 }, 1)));
		assertEquals("[20, 20, 30, 90, 40, 80, 70]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 20, 40, 90, 30, 80, 70 }, 2)));
		assertEquals("[20, 20, 30, 40, 90, 80, 70]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 20, 30, 90, 40, 80, 70 }, 3)));
		assertEquals("[20, 20, 30, 40, 70, 80, 90]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 20, 30, 40, 90, 80, 70 }, 4)));
		assertEquals("[20, 20, 30, 40, 70, 80, 90]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 20, 30, 40, 70, 80, 90 }, 5)));
		assertEquals("[20, 20, 30, 40, 70, 80, 90]",
				Arrays.toString(Stage2.swapToRightPlace(new int[] { 20, 20, 30, 40, 70, 80, 90 }, 6)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "mostcommon", marks = 1)
	public void testMostCommon()  {
		assertEquals(-1, Stage2.mostCommon(null));
		assertEquals(-1, Stage2.mostCommon(new int[] {}));
		assertEquals(10, Stage2.mostCommon(new int[] { 10, 20, 70, 90 }));
		assertEquals(20, Stage2.mostCommon(new int[] { 10, 20, 20, 70, 70, 90 }));
		assertEquals(20, Stage2.mostCommon(new int[] { 10, 20, 20, 20, 70, 70, 90 }));
		assertEquals(70, Stage2.mostCommon(new int[] { 10, 20, 20, 70, 70, 70, 90 }));
		assertEquals(90, Stage2.mostCommon(new int[] { 10, 20, 20, 70, 70, 90, 90, 90 }));
		assertEquals(-5, Stage2.mostCommon(new int[] { -5, -5, -5, -5, 10, 10, 10, 20, 20 }));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "insertatrightplace", marks = 1)
	public void testInsertAtRightPlace()  {
		assertNull(Stage2.insertAtRightPlace(null, 0));
		assertEquals("[5, 10, 20, 70, 90]",
				Arrays.toString(Stage2.insertAtRightPlace(new int[] { 10, 20, 70, 90 }, 5)));
		assertEquals("[10, 20, 70, 90, 100]",
				Arrays.toString(Stage2.insertAtRightPlace(new int[] { 10, 20, 70, 90 }, 100)));
		assertEquals("[10, 20, 30, 70, 90]",
				Arrays.toString(Stage2.insertAtRightPlace(new int[] { 10, 20, 70, 90 }, 30)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "bubblesortcount", marks = 1)
	public void testBubbleSortCount()  {
		assertEquals(-1, Stage2.bubbleSortCount(null));
		assertEquals(0, Stage2.bubbleSortCount(new int[] {}));
		assertEquals(0, Stage2.bubbleSortCount(new int[] { 10, 20, 70, 90 }));
		assertEquals(1, Stage2.bubbleSortCount(new int[] { 10, 70, 20, 90 }));
		assertEquals(3, Stage2.bubbleSortCount(new int[] { 10, 70, 5, 20, 90 }));
		assertEquals(4, Stage2.bubbleSortCount(new int[] { 10, 70, 5, 20, 20, 90 }));
		assertEquals(5, Stage2.bubbleSortCount(new int[] { 10, 70, 5, 20, 90, 20 }));
		assertEquals(10, Stage2.bubbleSortCount(new int[] { 90, 70, 20, 10, 5 }));
		assertEquals(11, Stage2.bubbleSortCount(new int[] { 40, 70, 20, 90, 30, 80, 20 }));
		assertEquals(14, Stage2.bubbleSortCount(new int[] { 2, 3, -4, 7, 5, 1, 10, 12, 6, 8, 9 }));
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
