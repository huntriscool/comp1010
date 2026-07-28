package practicePackage._06_sorting.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import practicePackage._06_sorting.attempts.*;

@SuppressWarnings("unused")
public class UnitTest {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "compareto", marks = 1)
	public void testCompareTo()  {
		Unit a = new Unit("COMP1010", 400);
		Unit b = new Unit("COMP1000", 1000);
		Unit c = new Unit("COMP1010", 1000);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertEquals(0, a.compareTo(a));
		assertEquals(-1, a.compareTo(c));
		assertEquals(1, c.compareTo(a));
		assertEquals(-1, b.compareTo(c));
		assertEquals(1, c.compareTo(b));
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
