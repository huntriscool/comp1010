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

class BoxTest {
	Box a, b, c, d, e;
	
	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		a = new Box(1,1,1);
		b = new Box(3,2,5);
		c = new Box(2,9,9);
		d = new Box(18,3,3);
		e = new Box(1,18,9);
		currentMethodName = null;
	}

	@Test @Graded(description = "box", marks = 1)
	public void testBox()  {
		assertEquals(1, a.depth);
		assertEquals(1, a.height);
		assertEquals(1, a.width);
		
		assertEquals(3, b.depth);
		assertEquals(2, b.height);
		assertEquals(5, b.width);

		assertEquals(2, c.depth);
		assertEquals(9, c.height);
		assertEquals(9, c.width);
		
		Box invalid = new Box(-1, 0, 9);
		assertEquals(1, invalid.depth);
		assertEquals(1, invalid.height);
		assertEquals(9, invalid.width);
		
		invalid = new Box(3, -7, 0);
		assertEquals(3, invalid.depth);
		assertEquals(1, invalid.height);
		assertEquals(1, invalid.width);
		
		invalid = new Box(0, 5, -4);
		assertEquals(1, invalid.depth);
		assertEquals(5, invalid.height);
		assertEquals(1, invalid.width);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "volume", marks = 1)
	public void testVolume()  {
		assertEquals(1, a.volume());
		assertEquals(30, b.volume());
		assertEquals(162, c.volume());
		assertEquals(162, d.volume());
		assertEquals(162, e.volume());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "compareto", marks = 1)
	public void testCompareTo()  {
		assertEquals(-1, a.compareTo(b));
		assertEquals(-1, a.compareTo(c));
		assertEquals(-1, a.compareTo(d));
		assertEquals(-1, a.compareTo(e));
	
		assertEquals(1, b.compareTo(a));
		assertEquals(-1, b.compareTo(c));
		assertEquals(-1, b.compareTo(d));
		assertEquals(-1, b.compareTo(e));

		assertEquals(1, c.compareTo(a));
		assertEquals(1, c.compareTo(b));
		assertEquals(0, c.compareTo(d));
		assertEquals(-1, c.compareTo(e));

		assertEquals(1, d.compareTo(a));
		assertEquals(1, d.compareTo(b));
		assertEquals(0, d.compareTo(c));
		assertEquals(-1, d.compareTo(e));

		assertEquals(1, e.compareTo(a));
		assertEquals(1, e.compareTo(b));
		assertEquals(1, e.compareTo(c));
		assertEquals(1, e.compareTo(d));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "comparetoadvanced", marks = 1)
	public void testCompareToAdvanced()  {
		assertEquals(-1, a.compareToAdvanced(b));
		assertEquals(-1, a.compareToAdvanced(c));
		assertEquals(-1, a.compareToAdvanced(d));
		assertEquals(-1, a.compareToAdvanced(e));
	
		assertEquals(1, b.compareToAdvanced(a));
		assertEquals(-1, b.compareToAdvanced(c));
		assertEquals(-1, b.compareToAdvanced(d));
		assertEquals(-1, b.compareToAdvanced(e));

		assertEquals(1, c.compareToAdvanced(a));
		assertEquals(1, c.compareToAdvanced(b));
		assertEquals(-1, c.compareToAdvanced(d));
		assertEquals(-1, c.compareToAdvanced(e));

		assertEquals(1, d.compareToAdvanced(a));
		assertEquals(1, d.compareToAdvanced(b));
		assertEquals(1, d.compareToAdvanced(c));
		assertEquals(-1, d.compareToAdvanced(e));

		assertEquals(1, e.compareToAdvanced(a));
		assertEquals(1, e.compareToAdvanced(b));
		assertEquals(1, e.compareToAdvanced(c));
		assertEquals(1, e.compareToAdvanced(d));
		
		e = new Box(5, 2, 3);
		assertEquals(0, b.compareToAdvanced(e));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "longestside", marks = 1)
	public void testLongestSide()  {
		assertEquals(1, a.longestSide());
		assertEquals(5, b.longestSide());
		assertEquals(9, c.longestSide());
		assertEquals(18, d.longestSide());
		assertEquals(18, e.longestSide());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "frontarea", marks = 1)
	public void testFrontArea()  {
		assertEquals(1, a.frontArea());
		assertEquals(10, b.frontArea());
		assertEquals(81, c.frontArea());
		assertEquals(9, d.frontArea());
		assertEquals(162, e.frontArea());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "surfacearea", marks = 1)
	public void testSurfaceArea()  {
		assertEquals(6, a.surfaceArea());
		assertEquals(62, b.surfaceArea());
		assertEquals(234, c.surfaceArea());
		assertEquals(234, d.surfaceArea());
		assertEquals(378, e.surfaceArea());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "canfitinside", marks = 1)
	public void testCanFitInside()  {
		assertFalse(a.canFitInside(a));
		assertTrue(a.canFitInside(b));
		assertTrue(a.canFitInside(c));
		assertTrue(a.canFitInside(d));
		assertFalse(a.canFitInside(e));

		assertFalse(b.canFitInside(a));
		assertFalse(b.canFitInside(b));
		assertFalse(b.canFitInside(c));
		assertFalse(b.canFitInside(d));
		assertFalse(b.canFitInside(e));

		assertFalse(c.canFitInside(a));
		assertFalse(c.canFitInside(b));
		assertFalse(c.canFitInside(c));
		assertFalse(c.canFitInside(d));
		assertFalse(c.canFitInside(e));
		
		e = new Box(6,4,3);
		assertTrue(b.canFitInside(e), "It fits inside if you rotate the box");
		
		e = new Box(3, 18, 9);
		assertTrue(b.canFitInside(e));
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
