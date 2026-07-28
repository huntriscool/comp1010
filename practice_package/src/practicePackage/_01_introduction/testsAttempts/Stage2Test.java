package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage2;

@SuppressWarnings("unused")
public class Stage2Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "lastdigit", marks = 1)
	public void testLastDigit()  {
		assertEquals(0,Stage2.lastDigit(0));
		assertEquals(8,Stage2.lastDigit(8));
		assertEquals(5,Stage2.lastDigit(15));
		assertEquals(5,Stage2.lastDigit(-15));
		assertEquals(7,Stage2.lastDigit(-1000007));
		assertEquals(4,Stage2.lastDigit(1000004));
		assertEquals(5,Stage2.lastDigit(5555));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "absolute", marks = 1)
	public void testAbsolute()  {
		assertEquals(10, Stage2.absolute(10));
		assertEquals(10, Stage2.absolute(-10));
		assertEquals(0, Stage2.absolute(0));
		assertEquals(1237, Stage2.absolute(-1237));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getquadrant", marks = 1)
	public void testGetQuadrant()  {
		assertEquals(1, Stage2.getQuadrant(0, 0));
		assertEquals(1, Stage2.getQuadrant(2,2));
		assertEquals(2, Stage2.getQuadrant(-2,3));
		assertEquals(3, Stage2.getQuadrant(-3,-4));
		assertEquals(4, Stage2.getQuadrant(3,-3));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "floor", marks = 1)
	public void testFloor()  {
		assertEquals(1, Stage2.floor(1.99));
		assertEquals(0, Stage2.floor(0.75));
		assertEquals(7, Stage2.floor(7.00));
		assertEquals(5, Stage2.floor(5.9999));
		assertEquals(400, Stage2.floor(400.001));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getlastchar", marks = 1)
	public void testGetLastChar()  {
		assertEquals('r', Stage2.getLastChar("Super"));
		assertEquals('!', Stage2.getLastChar("This is fun!"));
		assertEquals('x', Stage2.getLastChar("x"));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getwithoutlastchar", marks = 1)
	public void testGetWithoutLastChar()  {
		assertEquals("Supe", Stage2.getWithoutLastChar("Super"));
		assertEquals("This is fun", Stage2.getWithoutLastChar("This is fun!"));
		assertEquals("", Stage2.getWithoutLastChar("x"));
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
