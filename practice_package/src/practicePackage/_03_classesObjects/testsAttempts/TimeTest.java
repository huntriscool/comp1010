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

public class TimeTest {
	public Time time1, time2;
	public Fraction fraction1, fraction2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		time1 = new Time();
		time2 = new Time();
		currentMethodName = null;
	}

	@Test @Graded(description = "time", marks = 1)
	public void testTime()  {
		time1 = new Time(-4, 60); 
		assertEquals(0, time1.hour);
		assertEquals(59, time1.minute);

		time2 = new Time(3, 5);
		assertEquals(3, time2.hour);
		assertEquals(5, time2.minute);

		time2 = new Time(17, 51);
		assertEquals(17, time2.hour);
		assertEquals(51, time2.minute);

		time2 = new Time(-1, 59);
		assertEquals(0, time2.hour);
		assertEquals(59, time2.minute);

		time2 = new Time(23, 14);
		assertEquals(23, time2.hour);
		assertEquals(14, time2.minute);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "tostring", marks = 1)
	public void testToString()  {
		time1 = new Time(4, 7); 
		assertEquals("04:07", time1.toString());
		
		time1 = new Time(17, 9); 
		assertEquals("17:09", time1.toString());
		
		time1 = new Time(1, 29); 
		assertEquals("01:29", time1.toString());

		time1 = new Time(17, 19); 
		assertEquals("17:19", time1.toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "tostringampm", marks = 1)
	public void testToStringAMPM()  {
		time1 = new Time(8, 3);
		assertEquals("08:03 AM", time1.toStringAMPM());

		time1 = new Time(16, 9);
		assertEquals("04:09 PM", time1.toStringAMPM());

		time1 = new Time(10, 3);
		assertEquals("10:03 AM", time1.toStringAMPM());

		time1 = new Time(16, 59);
		assertEquals("04:59 PM", time1.toStringAMPM());

		time1 = new Time(11, 23);
		assertEquals("11:23 AM", time1.toStringAMPM());

		time1 = new Time(23, 59);
		assertEquals("11:59 PM", time1.toStringAMPM());
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
