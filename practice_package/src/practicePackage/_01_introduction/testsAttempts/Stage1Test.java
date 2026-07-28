package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage1;

@SuppressWarnings("unused")
public class Stage1Test {	

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "cube", marks = 1)
	public void testCube()  {
		assertEquals(125, Stage1.cube(5));
		assertEquals(-125, Stage1.cube(-5));
		assertEquals(1000000, Stage1.cube(100));
		assertEquals(0, Stage1.cube(0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "lastdigit", marks = 1)
	public void testLastDigit()  {
		assertEquals(0, Stage1.lastDigit(0));
		assertEquals(9, Stage1.lastDigit(1729));
		assertEquals(7, Stage1.lastDigit(2147483647));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "iseven", marks = 1)
	public void testIsEven()  {
		assertTrue(Stage1.isEven(6));
		assertTrue(Stage1.isEven(-12));
		assertTrue(Stage1.isEven(0));
		assertTrue(Stage1.isEven(10000000));
		assertFalse(Stage1.isEven(7));
		assertFalse(Stage1.isEven(-911));
		assertFalse(Stage1.isEven(1010101));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "evenone", marks = 1)
	public void testEvenOne()  {
		assertEquals(6, Stage1.evenOne(6, 11));
		assertEquals(-12, Stage1.evenOne(15, -12));
		assertEquals(-6, Stage1.evenOne(-6, 11));
		assertEquals(-1234, Stage1.evenOne(-1234, 1235));
		assertEquals(0, Stage1.evenOne(-15, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "highest", marks = 1)
	public void testHighest()  {
		for(int i=1; i < 4; i++) {
			for(int k=1; k < 4; k++) {
				for(int p=1; p < 4; p++) {
					int expected = Math.max(Math.max(i, k), p);
					int actual = Stage1.highest(i, k, p);
					assertEquals(expected, actual, "highest of "+i+", "+k+", "+p+" should be "+expected);
				}
			}
		}
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
