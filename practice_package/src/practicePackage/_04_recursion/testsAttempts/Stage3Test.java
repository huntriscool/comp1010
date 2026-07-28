package practicePackage._04_recursion.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._04_recursion.attempts.*;

public class Stage3Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "removedigit", marks = 1)
	public void testRemoveDigit()  {
		assertEquals(1729, Stage3.removeDigit(1729, -1));
		assertEquals(1729, Stage3.removeDigit(1729, 0));
		assertEquals(1729, Stage3.removeDigit(1729, 5));
		assertEquals(172, Stage3.removeDigit(1729, 1));
		assertEquals(729, Stage3.removeDigit(1729, 4));
		assertEquals(179, Stage3.removeDigit(1729, 2));
		assertEquals(129, Stage3.removeDigit(1729, 3));
		assertEquals(2, Stage3.removeDigit(1002, 4));
		assertEquals(-94825, Stage3.removeDigit(-94825,-1));
		assertEquals(-94825, Stage3.removeDigit(-94825,0));
		assertEquals(-94825, Stage3.removeDigit(-94825,6));
		assertEquals(-4825, Stage3.removeDigit(-94825,5));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "powerv2", marks = 1)
	public void testPowerV2()  {
		assertEquals(4, Stage3.powerV2(2, 2));	
		assertEquals(4, Stage3.powerV2(-2, 2));	
		assertEquals(8, Stage3.powerV2(2, 3));	
		assertEquals(-8, Stage3.powerV2(-2, 3));	
		assertEquals(1, Stage3.powerV2(4, 0));	
		assertEquals(6561, Stage3.powerV2(3, 8));	
		assertEquals(0.125, Stage3.powerV2(2, -3));
		assertEquals(-0.125, Stage3.powerV2(-2, -3));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "convert", marks = 1)
	public void testConvert()  {
		assertEquals("0", Stage3.convert(0, 2));
		assertEquals("4", Stage3.convert(4, 9));
		assertEquals("1101", Stage3.convert(13, 2));
		assertEquals("201", Stage3.convert(19, 3));
		assertEquals("3561", Stage3.convert(1905, 8));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countweighted", marks = 1)
	public void testCountWeighted()  {
		assertEquals(5, Stage3.countWeighted(888, 8));
		assertEquals(3, Stage3.countWeighted(88, 8));
		assertEquals(2, Stage3.countWeighted(808, 8));
		assertEquals(1, Stage3.countWeighted(8, 8));

		assertEquals(5, Stage3.countWeighted(707070707, 7));
		assertEquals(4, Stage3.countWeighted(707070707, 0));
		assertEquals(17, Stage3.countWeighted(777777777, 7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "withoutfirstdigit", marks = 1)
	public void testWithoutFirstDigit()  {
		assertEquals(234567, Stage3.withoutFirstDigit(1234567));
		assertEquals(34567, Stage3.withoutFirstDigit(234567));
		assertEquals(4567, Stage3.withoutFirstDigit(34567));
		assertEquals(567, Stage3.withoutFirstDigit(4567));
		assertEquals(67, Stage3.withoutFirstDigit(567));
		assertEquals(7, Stage3.withoutFirstDigit(67));
		assertEquals(0, Stage3.withoutFirstDigit(7));
		assertEquals(-234567, Stage3.withoutFirstDigit(-1234567));
		assertEquals(-34567, Stage3.withoutFirstDigit(-234567));
		assertEquals(-4567, Stage3.withoutFirstDigit(-34567));
		assertEquals(-567, Stage3.withoutFirstDigit(-4567));
		assertEquals(-67, Stage3.withoutFirstDigit(-567));
		assertEquals(-7, Stage3.withoutFirstDigit(-67));
		assertEquals(0, Stage3.withoutFirstDigit(-7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "smallestnumber", marks = 1)
	public void testSmallestNumber()  {
		assertEquals(12, Stage3.smallestNumber(1002));
		assertEquals(1279, Stage3.smallestNumber(1729));
		assertEquals(12345678, Stage3.smallestNumber(102764583));
		assertEquals(0, Stage3.smallestNumber(0));
		assertEquals(1, Stage3.smallestNumber(10000));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "areanagrams", marks = 1)
	public void testAreAnagrams()  {
		assertTrue(Stage3.areAnagrams("man", "nam"));
		assertTrue(Stage3.areAnagrams("superman", "erspunma"));
		assertTrue(Stage3.areAnagrams("splendid", "didlepsn"));
		assertFalse(Stage3.areAnagrams("splendid", "indeed!!")); 
		assertFalse(Stage3.areAnagrams("splendid", "")); 
		assertFalse(Stage3.areAnagrams("", "splendid")); 
		assertFalse(Stage3.areAnagrams("splendid", "didlepdsn")); //extra character in s2
		assertFalse(Stage3.areAnagrams("spldendid", "didlepsn")); //extra character in s1
		assertFalse(Stage3.areAnagrams("splendid", "diplepsn")); //one set of different characters between s1 and s2
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "evaluatepolynomial", marks = 1)
	public void testEvaluatePolynomial()  {
		assertEquals(273, Stage3.evaluatePolynomial(new int[]{3, 5, -7, 0, 0, 9}, 5, 2));
		assertEquals(12, Stage3.evaluatePolynomial(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 11, 1));
		assertEquals(4095, Stage3.evaluatePolynomial(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 11, 2));
		assertEquals(13, Stage3.evaluatePolynomial(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 3, 2));
		assertEquals(1093, Stage3.evaluatePolynomial(new int[]{1, 1, 1, 1, 1, 1, 1}, 6, 3));
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
