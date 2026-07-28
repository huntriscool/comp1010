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

public class LargeIntegerTest {
	private LargeInteger large1, large2;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		large1 = new LargeInteger();
		large2 = new LargeInteger();
		currentMethodName = null;
	}

	@Test @Graded(description = "setvalue", marks = 1)
	public void testSetValue()  {
		large1.setValue("12345");
		assertEquals("12345", large1.value);

		large1.setValue("123457453897200000000000000000000000000000000923845392563759462976459725973659345952863495623947692376547926");
		assertEquals("123457453897200000000000000000000000000000000923845392563759462976459725973659345952863495623947692376547926", large1.value);

		large2.setValue("123a");
		assertEquals("0", large2.value);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getlastdigit", marks = 1)
	public void testGetLastDigit()  {
		large1.setValue("1729");
		assertEquals(9, large1.getLastDigit());

		large2.setValue("-37");
		assertEquals(7, large2.getLastDigit());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "add", marks = 1)
	public void testAdd()  {
		large1.setValue("1729");
		large2.setValue("37");
		assertNotNull(large1.add(large2));
		assertEquals("1766", large1.add(large2).value);
		large1.setValue("-20");
        large2.setValue("10");
        assertEquals("-10", large1.add(large2).value);

		large1.setValue("-4436933645896356356345030546035064079435397193472924925434");
		large2.setValue("945379723853759365972659347623753");
		assertEquals("-4436933645896356356345029600655340225676031220813577301681", large1.add(large2).value);
		assertEquals("-4436933645896356356345029600655340225676031220813577301681", large2.add(large1).value);
		large1.setValue("-945379723853759365972659347623753");
		assertEquals("0", large1.add(large2).value);
		large1.setValue("-945379723853759365972659347622753");
		assertEquals("1000", large1.add(large2).value);

		large1.setValue("-9999999999");
        large2.setValue("-999999999999999");
        assertEquals("-1000009999999998", large1.add(large2).value);
        assertEquals("-1000009999999998", large2.add(large1).value);
        large1.setValue("9999848949849874897");
        large2.setValue("61849898798768846461654698787");
        assertEquals("61849898808768695411504573684", large1.add(large2).value);
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
