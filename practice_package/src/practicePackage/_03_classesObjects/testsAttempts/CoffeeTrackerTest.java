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

public class CoffeeTrackerTest {
	public CoffeeTracker tracker;
	public int[] data;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		data = new int[] {3, 0, 1, 0, 0, 0, 2, 0, 2, 3};
		tracker = new CoffeeTracker(data);
		currentMethodName = null;
	}

	@Test @Graded(description = "coffeetracker", marks = 1)
	public void testCoffeeTracker()  {
		assertArrayEquals(data, tracker.coffeesPerDay);
		assertNotEquals(data, tracker.coffeesPerDay); //the two object should not refer to the same instance
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "averagecoffeesconsumed", marks = 1)
	public void testAverageCoffeesConsumed()  {
		assertEquals(1.1, tracker.averageCoffeesConsumed(), 0.01);
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
