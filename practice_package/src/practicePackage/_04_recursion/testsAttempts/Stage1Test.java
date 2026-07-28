package practicePackage._04_recursion.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._04_recursion.attempts.*;

public class Stage1Test  {
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "power", marks = 1)
	public void testPower()  {
		assertEquals(4, Stage1.power(2, 2));	
		assertEquals(4, Stage1.power(-2, 2));	
		assertEquals(8, Stage1.power(2, 3));	
		assertEquals(65536, Stage1.power(2, 16));	
		assertEquals(1024*1024, Stage1.power(2, 20));	
		assertEquals(-8, Stage1.power(-2, 3));	
		assertEquals(1, Stage1.power(4, 0));	
		assertEquals(6561, Stage1.power(3, 8));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumrange", marks = 1)
	public void testSumRange()  {
		assertEquals(0, Stage1.sumRange(0, 0));
		assertEquals(20, Stage1.sumRange(20, 20));
		assertEquals(0, Stage1.sumRange(20, 10));
		assertEquals(26, Stage1.sumRange(5, 8));
		assertEquals(55, Stage1.sumRange(1, 10));
		assertEquals(800*(801)/2-500*(501)/2, Stage1.sumRange(501, 800));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumsquares", marks = 1)
	public void testSumSquares()  {
		assertEquals(0, Stage1.sumSquares(0));
		assertEquals(0, Stage1.sumSquares(-5));
		assertEquals(14, Stage1.sumSquares(3));	
		assertEquals(2686700, Stage1.sumSquares(200));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumodd", marks = 1)
	public void testSumOdd()  {
		assertEquals(0, Stage1.sumOdd(0));
		assertEquals(0, Stage1.sumOdd(-5));
		assertEquals(4, Stage1.sumOdd(3));	
		assertEquals(4, Stage1.sumOdd(4));	
		assertEquals(9, Stage1.sumOdd(5));	
		assertEquals(202500, Stage1.sumOdd(900));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumoddsquares", marks = 1)
	public void testSumOddSquares()  {
		assertEquals(0, Stage1.sumOddSquares(0));
		assertEquals(0, Stage1.sumOddSquares(-5));
		assertEquals(10, Stage1.sumOddSquares(4));	
		assertEquals(35, Stage1.sumOddSquares(6));	
		assertEquals(84, Stage1.sumOddSquares(7));	
		assertEquals(35999900, Stage1.sumOddSquares(600));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isnumeric", marks = 1)
	public void testIsNumeric()  {
		assertFalse(Stage1.isNumeric(null));
		assertTrue(Stage1.isNumeric(""));
		assertFalse(Stage1.isNumeric("c3po"));
		assertTrue(Stage1.isNumeric("90210"));
		assertTrue(Stage1.isNumeric("0"));
		assertTrue(Stage1.isNumeric("4057342587835373489543479354573967546947644293853429569365934"));
		assertFalse(Stage1.isNumeric("4chan"));
		assertFalse(Stage1.isNumeric("superman"));
		assertFalse(Stage1.isNumeric("no digits here :("));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "containsstringstring", marks = 1)
	public void testContainsStringString()  {
		assertFalse(Stage1.containsStringString(null, "super"));
		assertFalse(Stage1.containsStringString("", "super"));
		assertFalse(Stage1.containsStringString("hi", null));
		assertFalse(Stage1.containsStringString("superman", "MAN")); //upper case
		assertTrue(Stage1.containsStringString("superman", "man"));
		assertTrue(Stage1.containsStringString("Trinity? THE Trinity!?", "Trinity"));
		assertFalse(Stage1.containsStringString("Trinity? THE Trinity!?", "night"));
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
