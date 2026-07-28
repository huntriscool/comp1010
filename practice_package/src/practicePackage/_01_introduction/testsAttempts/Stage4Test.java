package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage4;

public class Stage4Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "lastindexof", marks = 1)
	public void testLastIndexOf()  {
		assertEquals(2, Stage4.lastIndexOf(new int[] {10,10,10}, 10));
		assertEquals(0, Stage4.lastIndexOf(new int[] {20,10,10}, 20));
		assertEquals(-1, Stage4.lastIndexOf(new int[] {10,10,20}, 30));
		assertEquals(8, Stage4.lastIndexOf(new int[] {1,2,3,4,5,6,7,8,9,10,11,12}, 9));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "gcd", marks = 1)
	public void testGcd()  {
		assertEquals(10, Stage4.gcd(70, 40));
		assertEquals(10, Stage4.gcd(40, 70));
		assertEquals(1, Stage4.gcd(15, 32));
		assertEquals(51, Stage4.gcd(-51, 153));
		assertEquals(100, Stage4.gcd(100, 10000));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "issquare", marks = 1)
	public void testIsSquare()  {
		assertTrue(Stage4.isSquare(25));
		assertTrue(Stage4.isSquare(6561));
		assertTrue(Stage4.isSquare(739 * 739));
		assertFalse(Stage4.isSquare(251));
		assertFalse(Stage4.isSquare(-25));
		assertFalse(Stage4.isSquare(1000001));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "roundoffadvanced", marks = 1)
	public void testRoundOffAdvanced()  {
		assertEquals(2, Stage4.roundOffAdvanced(1.99));
		assertEquals(-2, Stage4.roundOffAdvanced(-1.99));
		assertEquals(1, Stage4.roundOffAdvanced(1.49));
		assertEquals(-1, Stage4.roundOffAdvanced(-1.49));
		assertEquals(1, Stage4.roundOffAdvanced(0.75));
		assertEquals(7, Stage4.roundOffAdvanced(7.0));
		assertEquals(6, Stage4.roundOffAdvanced(5.9999));
		assertEquals(401, Stage4.roundOffAdvanced(400.5));
		assertEquals(-1, Stage4.roundOffAdvanced(-0.501));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "ceilingadvanced", marks = 1)
	public void testCeilingAdvanced()  {
		assertEquals(5, Stage4.ceilingAdvanced(4.2));
		assertEquals(7, Stage4.ceilingAdvanced(7.0));
		assertEquals(6, Stage4.ceilingAdvanced(5.999));
		assertEquals(-3, Stage4.ceilingAdvanced(-3.7));
		assertEquals(-3, Stage4.ceilingAdvanced(-3.1));
		assertEquals(0, Stage4.ceilingAdvanced(0.0));
		assertEquals(0, Stage4.ceilingAdvanced(-0.99));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isnumeric", marks = 1)
	public void testIsNumeric()  {
		assertTrue(Stage4.isNumeric("1234567890"));
		assertTrue(Stage4.isNumeric("34038459308572893457549637966556"));
		assertFalse(Stage4.isNumeric("a234567890"));
		assertFalse(Stage4.isNumeric("123456789a"));
		assertFalse(Stage4.isNumeric("01234-67890"));
		assertTrue(Stage4.isNumeric("340753287585732985735923659364572365139576329563578326583756328573265872635873658376587356387563875365873"));
		assertFalse(Stage4.isNumeric("340753287585732985735923659364572365139576329563578326583756328573265872635873658376587356387%563875365873"));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "reverse", marks = 1)
	public void testReverse()  {
		assertEquals("", Stage4.reverse(""));
		assertEquals("$", Stage4.reverse("$"));
		assertEquals("Super nintendo chalmers", Stage4.reverse("sremlahc odnetnin repuS"));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isconcattwosquares", marks = 1)
	public void testIsConcatTwoSquares()  {
		assertTrue(Stage4.isConcatTwoSquares(164));
		assertTrue(Stage4.isConcatTwoSquares(1000));
		assertTrue(Stage4.isConcatTwoSquares(2566561));
		assertTrue(Stage4.isConcatTwoSquares(11000000));
		assertTrue(Stage4.isConcatTwoSquares(2500));
		assertFalse(Stage4.isConcatTwoSquares(25));
		assertFalse(Stage4.isConcatTwoSquares(10007));
		assertFalse(Stage4.isConcatTwoSquares(12345));
		assertFalse(Stage4.isConcatTwoSquares(2147483647));
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
