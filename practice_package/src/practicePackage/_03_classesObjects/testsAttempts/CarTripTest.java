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

public class CarTripTest {
	public CarTrip trip1, trip2, trip3, trip4;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		trip1 = new CarTrip(5, 4);
		trip2 = new CarTrip(6, 4.8);
		trip3 = new CarTrip(4.8, 2.1);
		trip4 = new CarTrip(5, 8.2);
		currentMethodName = null;
	}

	@Test @Graded(description = "cartrip", marks = 1)
	public void testCarTrip()  {
		assertEquals(5, trip1.distance, 0.01);
		assertEquals(4, trip1.time, 0.01);

		trip1 = new CarTrip(-2, 5.1);

		assertEquals(0, trip1.distance, 0.01);
		assertEquals(5.1, trip1.time, 0.01);

		trip1 = new CarTrip(1.4, -5.1);

		assertEquals(1.4, trip1.distance, 0.01);
		assertEquals(0, trip1.time, 0.01);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "tostring", marks = 1)
	public void testToString()  {
		assertEquals("5.0 kms travelled in 4.0 hours", trip1.toString());
		assertEquals("6.0 kms travelled in 4.8 hours", trip2.toString());
		assertEquals("4.8 kms travelled in 2.1 hours", trip3.toString());
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
