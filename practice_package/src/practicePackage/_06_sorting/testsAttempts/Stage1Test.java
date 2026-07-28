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

public class Stage1Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "swap", marks = 1)
	public void testSwap()  {
		int[] data = new int[] { 10, 20, 5, 70, 90 };
		assertNull(Stage1.swap(data, -1, 3));
		assertNull(Stage1.swap(data, 7, 3));
		assertNull(Stage1.swap(data, 1, 10));
		assertNull(Stage1.swap(data, 4, -2));
		assertEquals("[70, 20, 5, 10, 90]", Arrays.toString(Stage1.swap(data, 0, 3)));
		assertEquals("[70, 5, 20, 10, 90]", Arrays.toString(Stage1.swap(data, 1, 2)));
		assertEquals("[70, 10, 20, 5, 90]", Arrays.toString(Stage1.swap(data, 1, 3)));
		assertEquals("[5, 10, 20, 70, 90]", Arrays.toString(Stage1.swap(data, 3, 0)));
		assertEquals("[5, 20, 10, 70, 90]", Arrays.toString(Stage1.swap(data, 1, 2)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "duplicates", marks = 1)
	public void testDuplicates()  {
		assertFalse(Stage1.duplicates(null));
		assertFalse(Stage1.duplicates(new int[] {}));
		assertFalse(Stage1.duplicates(new int[] { 10, 20, 70, 90 }));
		assertFalse(Stage1.duplicates(new int[] { 5, 10, 15, 20, 70, 80, 90 }));
		assertTrue(Stage1.duplicates(new int[] { 5, 5, 10, 15, 20, 70, 80, 90 }));
		assertTrue(Stage1.duplicates(new int[] { 5, 10, 15, 20, 70, 90, 90 }));
		assertTrue(Stage1.duplicates(new int[] { 5, 10, 15, 15, 15, 20, 70, 80, 90 }));
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
