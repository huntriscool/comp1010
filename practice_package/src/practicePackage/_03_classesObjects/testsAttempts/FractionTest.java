package practicePackage._03_classesObjects.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._03_classesObjects.attempts.*;

public class FractionTest {
	public Fraction fraction1, fraction2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		fraction1 = new Fraction();
		fraction2 = new Fraction();
		currentMethodName = null;
	}

	@Test @Graded(description = "multiply", marks = 1)
	public void testMultiply()  {
		fraction1 = new Fraction(12, -7);
		fraction2 = new Fraction(-3, 5);
		Fraction c = fraction1.multiply(fraction2);
		assertNotNull(c);
		assertEquals(-36, c.num);
		assertEquals(-35, c.den);
		
		fraction1 = new Fraction(7, 199);
		fraction2 = new Fraction(39, -3);
		c = fraction1.multiply(fraction2);
		assertNotNull(c);
		assertEquals(273, c.num);
		assertEquals(-597, c.den);
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
