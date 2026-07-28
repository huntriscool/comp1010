package practicePackage._04_recursion.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._04_recursion.attempts.*;

public class Stage2Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "sumevendigits", marks = 1)
	public void testSumEvenDigits()  {
		assertEquals(2, Stage2.sumEvenDigits(1729));
		assertEquals(2, Stage2.sumEvenDigits(-1729));
		assertEquals(6, Stage2.sumEvenDigits(-6179));
		assertEquals(0, Stage2.sumEvenDigits(1739));
		assertEquals(0, Stage2.sumEvenDigits(-1739));
		assertEquals(20, Stage2.sumEvenDigits(80264));
		assertEquals(20, Stage2.sumEvenDigits(-80264));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countdigit", marks = 1)
	public void testCountDigit()  {
		assertEquals(0, Stage2.countDigit(0, 0));
		assertEquals(1, Stage2.countDigit(8, 8));
		assertEquals(0, Stage2.countDigit(8, 5));
		assertEquals(2, Stage2.countDigit(1721, 1));
		assertEquals(2, Stage2.countDigit(-1721, 1));
		assertEquals(5, Stage2.countDigit(-1212121212, 1));
		assertEquals(5, Stage2.countDigit(-1212121212, 2));
		assertEquals(0, Stage2.countDigit(-1212121212, 3));
		assertEquals(3, Stage2.countDigit(888, 8));
		assertEquals(3, Stage2.countDigit(-888, 8));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "product", marks = 1)
	public void testProduct()  {
		assertEquals(18, Stage2.product(2, 9));
		assertEquals(1500, Stage2.product(30, 50));
		assertEquals(150, Stage2.product(3, 50));
		assertEquals(200, Stage2.product(2, 100));
		assertEquals(61, Stage2.product(61, 1));
		assertEquals(12353*1153, Stage2.product(12353, 1153));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "tribonacci", marks = 1)
	public void testTribonacci()  {
		assertEquals(0, Stage2.tribonacci(0));
		assertEquals(0, Stage2.tribonacci(1));
		assertEquals(1, Stage2.tribonacci(2));
		assertEquals(1, Stage2.tribonacci(3));
		assertEquals(2, Stage2.tribonacci(4));
		assertEquals(4, Stage2.tribonacci(5));
		assertEquals(7, Stage2.tribonacci(6));
		assertEquals(13, Stage2.tribonacci(7));
		assertEquals(755476, Stage2.tribonacci(25));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "smallestdigit", marks = 1)
	public void testSmallestDigit()  {
		assertEquals(1, Stage2.smallestDigit(1732));
		assertEquals(1, Stage2.smallestDigit(-1732));
		assertEquals(0, Stage2.smallestDigit(-917308562));
		assertEquals(0, Stage2.smallestDigit(917308562));
		assertEquals(1, Stage2.smallestDigit(-917318562));
		assertEquals(1, Stage2.smallestDigit(917318562));
		assertEquals(8, Stage2.smallestDigit(888));
		assertEquals(0, Stage2.smallestDigit(0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "smallestevendigit", marks = 1)
	public void testSmallestEvenDigit()  {
		assertEquals(2, Stage2.smallestEvenDigit(1732));
		assertEquals(2, Stage2.smallestEvenDigit(-1732));
		assertEquals(0, Stage2.smallestEvenDigit(-917308562));
		assertEquals(0, Stage2.smallestEvenDigit(917308562));
		assertEquals(8, Stage2.smallestEvenDigit(-91738511));
		assertEquals(8, Stage2.smallestEvenDigit(917385311));
		assertEquals(8, Stage2.smallestEvenDigit(888));
		assertEquals(0, Stage2.smallestEvenDigit(0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "highestevendigitlocation", marks = 1)
	public void testHighestEvenDigitLocation()  {
		assertEquals(2, Stage2.highestEvenDigitLocation(17382));
		assertEquals(5, Stage2.highestEvenDigitLocation(-61732));
		assertEquals(1, Stage2.highestEvenDigitLocation(888));
		assertEquals(0, Stage2.highestEvenDigitLocation(0));
		assertEquals(3, Stage2.highestEvenDigitLocation(-864));
		assertEquals(4, Stage2.highestEvenDigitLocation(-917308562));
		assertEquals(4, Stage2.highestEvenDigitLocation(917308562));
		assertEquals(0, Stage2.highestEvenDigitLocation(-957313579));
		assertEquals(0, Stage2.highestEvenDigitLocation(957313579));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "smallestdigitlocation", marks = 1)
	public void testSmallestDigitLocation()  {
		assertEquals(5, Stage2.smallestDigitLocation(17382));
		assertEquals(4, Stage2.smallestDigitLocation(-61732));
		assertEquals(1, Stage2.smallestDigitLocation(888));
		assertEquals(0, Stage2.smallestDigitLocation(0));
		assertEquals(1, Stage2.smallestDigitLocation(-864));
		assertEquals(9, Stage2.smallestDigitLocation(-197348562));
		assertEquals(9, Stage2.smallestDigitLocation(197348562));
		assertEquals(5, Stage2.smallestDigitLocation(-957313572));
		assertEquals(5, Stage2.smallestDigitLocation(957313572));	
		assertEquals(1, Stage2.smallestDigitLocation(-957353572));
		assertEquals(1, Stage2.smallestDigitLocation(957353572));	
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
