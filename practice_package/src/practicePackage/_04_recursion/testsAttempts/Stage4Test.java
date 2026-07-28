package practicePackage._04_recursion.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practicePackage._04_recursion.attempts.*;

public class Stage4Test {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "fastpower", marks = 1)
	public void testFastPower()  {
		assertEquals(4, Stage4.fastPower(2, 2));	
		assertEquals(4, Stage4.fastPower(-2, 2));	
		assertEquals(8, Stage4.fastPower(2, 3));	
		assertEquals(-8, Stage4.fastPower(-2, 3));	
		assertEquals(1, Stage4.fastPower(4, 0));	
		assertEquals(6561, Stage4.fastPower(3, 8));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getpermutation", marks = 1)
	public void testGetPermutation()  {
		assertNull(Stage4.getPermutation(5, -1));
		assertNull(Stage4.getPermutation(5, 120));
		assertNull(Stage4.getPermutation(0, 120));

		assertNotNull(Stage4.getPermutation(5, 0));
		assertEquals("12345", Stage4.getPermutation(5, 0));

		assertNotNull(Stage4.getPermutation(5, 7));
		assertEquals("13254", Stage4.getPermutation(5, 7));

		assertNotNull(Stage4.getPermutation(5, 119));
		assertEquals("54321", Stage4.getPermutation(5, 119));

		assertNotNull(Stage4.getPermutation(9, 0));
		assertEquals("123456789", Stage4.getPermutation(9, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "addsupto", marks = 1)
	public void testAddsUpTo()  {
		assertTrue(Stage4.addsUpTo(new int[] {10, 70, 20, 90}, 0, 110));
		assertFalse(Stage4.addsUpTo(new int[] {10, 70, 20, 90}, 0, 50));
		assertTrue(Stage4.addsUpTo(new int[] {10, 70, 20, 90, 30, 80}, 0, 270));
		assertTrue(Stage4.addsUpTo(new int[] {1,2,3,4,5,6,7,8,9,10}, 0, 30));
		assertTrue(Stage4.addsUpTo(new int[] {10, 70, 2000, 90, 300, 80}, 0, 2310));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "waysaddsupto", marks = 1)
	public void testWaysAddsUpTo()  {
		assertEquals(2, Stage4.waysAddsUpTo(new int[] {10, 70, 20, 90}, 0, 100));
		/*
		 * 10,70,20
		 * 10,90
		 */
		
		assertEquals(6, Stage4.waysAddsUpTo(new int[] {10, 70, 20, 90, -20, 20}, 0, 100));
		/*
		 * 10,70,20
		 * 10,70,20,-20,20
		 * 10,70,20 (the last 20)
		 * 100,20,90,-20
		 * 10,90
		 * 10,90,-20,20
		 */
		
		assertEquals(5, Stage4.waysAddsUpTo(new int[] {10, 70, 20, 90, -30, 30}, 0, 100));
		/*
		 * 10,70,20
		 * 10,70,20,-30,30
		 * 10,90
		 * 10,90,-30,30
		 * 70,30
		 */
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "firstpeak", marks = 1)
	public void testFirstPeak()  {
		assertEquals(1, Stage4.firstPeak(new int[] {10,70,20,90}));
		assertEquals(0, Stage4.firstPeak(new int[] {40,30,20,10}));
		assertEquals(3, Stage4.firstPeak(new int[] {10,20,30,40}));
		int[] data = new int[1024*1024];
		assertEquals(0, Stage4.firstPeak(data));
		int idx = (int)(Math.random()*data.length);
		for(int i=1; i < data.length; i++) {
			data[i] = data[i-1]+1;
		}
		assertEquals(data.length-1, Stage4.firstPeak(data));
		data[idx]++;
		assertEquals(idx, Stage4.firstPeak(data));		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "longestascendingsubsequence", marks = 1)
	public void testLongestAscendingSubsequence()  {
		assertNotNull(Stage4.longestAscendingSubsequence(new int[] {10, 20, 30}));
		assertEquals(3, Stage4.longestAscendingSubsequence(new int[] {10, 20, 30}));
		assertEquals(1, Stage4.longestAscendingSubsequence(new int[] {30, 20, 10}));
		assertEquals(3, Stage4.longestAscendingSubsequence(new int[] {10, 70, 20, 90}));
		assertEquals(4, Stage4.longestAscendingSubsequence(new int[] {10, 70, 20, 90, 20, 80}));
		assertEquals(7, Stage4.longestAscendingSubsequence(new int[] {10, 15, 8, 14, 9, 10, 70, 70, 70, 20, 30, 60, 80}));
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
