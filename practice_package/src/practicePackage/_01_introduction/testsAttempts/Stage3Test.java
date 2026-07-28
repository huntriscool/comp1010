package practicePackage._01_introduction.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._01_introduction.attempts.Stage3;

public class Stage3Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "sumevenv1", marks = 1)
	public void testSumEvenV1()  {
		assertEquals(2, Stage3.sumEvenV1(1));
		assertEquals(110, Stage3.sumEvenV1(10));
		assertEquals(2550, Stage3.sumEvenV1(50));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumevenv2", marks = 1)
	public void testSumEvenV2()  {
		assertEquals(0, Stage3.sumEvenV2(1));
		assertEquals(30, Stage3.sumEvenV2(10));
		assertEquals(650, Stage3.sumEvenV2(50));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "product", marks = 1)
	public void testProduct()  {
		assertEquals(120, Stage3.product(5));
		assertEquals(1, Stage3.product(1));
		assertEquals(1, Stage3.product(0));
		assertEquals(1, Stage3.product(-4));
		assertEquals(3628800, Stage3.product(10));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "productodd", marks = 1)
	public void testProductOdd()  {
		assertEquals(945, Stage3.productOdd(5));
		assertEquals(1, Stage3.productOdd(1));
		assertEquals(1, Stage3.productOdd(0));
		assertEquals(1, Stage3.productOdd(-4));
		assertEquals(135135, Stage3.productOdd(7));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "power", marks = 1)
	public void testPower()  {
		assertEquals(1, Stage3.power(-5, 0));
		assertEquals(-12, Stage3.power(-12, 1));
		assertEquals(9, Stage3.power(-3, 2));
		assertEquals(1024, Stage3.power(-2, 10));
		assertEquals(-2048, Stage3.power(-2, 11));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sumeven", marks = 1)
	public void testSumEven()  {
		assertEquals(150, Stage3.sumEven(new int[] {10,70,-20,90}));
		assertEquals(0, Stage3.sumEven(new int[] {11,73,-29,95}));
		assertEquals(0, Stage3.sumEven(new int[] {})); //empty array
		assertEquals(0, Stage3.sumEven(new int[] {-50,50})); 
		assertEquals(30, Stage3.sumEven(new int[] {1,2,3,4,5,6,7,8,9,10})); 
		assertEquals(-30, Stage3.sumEven(new int[] {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10})); 
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
