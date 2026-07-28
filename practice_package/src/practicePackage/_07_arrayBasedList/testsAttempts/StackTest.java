package practicePackage._07_arrayBasedList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._07_arrayBasedList.attempts.Stack;

class StackTest {
	Stack s1, s2, s3;
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		s1 = new Stack();
		s2 = new Stack();
		s3 = new Stack();
		
		for(int i=0; i < 100; i++) {
			s2.push((i+1)+"");
		}
		
		for(int i=0; i < 1000; i++) {
			s3.push((i+1)*2+"");
		}
		currentMethodName = null;
	}

	@Test @Graded(description = "stack", marks = 1)
	public void testStack()  {
		s1 = new Stack();
		assertNotNull(s1.items);
		assertEquals(0, s1.size);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "push", marks = 1)
	public void testPush()  {
		for(int i=0; i < 100; i++) {
			s1.push(i+"");
			assertEquals(i+1, s1.size);
		}
		
		for(int i=0; i < 100; i++) {
			s1.push(null);
			assertEquals(100, s1.size);
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isfull", marks = 1)
	public void testIsFull()  {
		s1 = new Stack();
		assertTrue(s1.isFull());
		s1.items = new String[5];
		s1.items[0] = "hello";
		s1.size = 1;
		assertFalse(s1.isFull());
		
		s1.items = new String[2];
		s1.items[0] = "hello";
		s1.items[1] = "world";
		s1.size = 2;
		assertTrue(s1.isFull());
		
		s1.items = new String[1000];
		for(int i=0; i < 999; i++) {
			s1.items[i] = i+"";
		}
		s1.size = 999;
		assertFalse(s1.isFull());
		
		s1.items[999] = "Done";
		s1.size = 1000;
		assertTrue(s1.isFull());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "get", marks = 1)
	public void testGet()  {
		for(int i=0; i < 100; i++) {
			assertNull(s1.get(i));
			assertNotNull(s2.get(i));
			assertEquals((i+1)+"", s2.get(i));
		}
		
		for(int i=0; i < 1000; i++) {
			if(i >= 100) {
				assertNull(s2.get(i));
			}
			assertNotNull(s3.get(i));
			assertEquals((i+1)*2+"", s3.get(i));
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
