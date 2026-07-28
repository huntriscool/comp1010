package practicePackage._07_arrayBasedList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._07_arrayBasedList.attempts.Queue;

class QueueTest {
	Queue q1, q2, q3;
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		q1 = new Queue();
		q2 = new Queue();
		q3 = new Queue();
		
		for(int i=0; i < 100; i++) {
			q2.insert((i+1)+"");
		}
		
		for(int i=0; i < 1000; i++) {
			q3.insert((i+1)*2+"");
		}
		currentMethodName = null;
	}

	@Test @Graded(description = "queue", marks = 1)
	public void testQueue()  {
		q1 = new Queue();
		assertNotNull(q1.items);
		assertEquals(0, q1.size);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "insert", marks = 1)
	public void testInsert()  {
		for(int i=0; i < 100; i++) {
			q1.insert(i+"");
			assertEquals(i+1, q1.size);
		}
		
		for(int i=0; i < 100; i++) {
			q1.insert(null);
			assertEquals(100, q1.size);
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "isfull", marks = 1)
	public void testIsFull()  {
		q1 = new Queue();
		assertTrue(q1.isFull());
		q1.items = new String[5];
		q1.items[0] = "hello";
		q1.size = 1;
		assertFalse(q1.isFull());
		
		q1.items = new String[2];
		q1.items[0] = "hello";
		q1.items[1] = "world";
		q1.size = 2;
		assertTrue(q1.isFull());
		
		q1.items = new String[1000];
		for(int i=0; i < 999; i++) {
			q1.items[i] = i+"";
		}
		q1.size = 999;
		assertFalse(q1.isFull());
		
		q1.items[999] = "Done";
		q1.size = 1000;
		assertTrue(q1.isFull());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "remove", marks = 1)
	public void testRemove()  {
		assertNull(q1.remove());
		for(int i=0; i < 100; i++) {
			String str = q2.remove();
			assertNotNull(str);
			assertEquals((i+1)+"", str);
		}
		assertNull(q2.remove());
		
		for(int i=0; i < 1000; i++) {
			String str = q3.remove();
			assertNotNull(str);
			assertEquals((i+1)*2+"", str);
		}
		assertNull(q3.remove());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "get", marks = 1)
	public void testGet()  {
		for(int i=0; i < 100; i++) {
			assertNull(q1.get(i));
			assertNotNull(q2.get(i));
			assertEquals((i+1)+"", q2.get(i));
		}
		
		for(int i=0; i < 1000; i++) {
			if(i >= 100) {
				assertNull(q2.get(i));
			}
			assertNotNull(q3.get(i));
			assertEquals((i+1)*2+"", q3.get(i));
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
