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

class DeliveryTruckTest {
	DeliveryTruck t1, t2, t3;
	Box a, b, c, d, e, f;

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
		f = new Box(1,2,3);
		t1 = new DeliveryTruck(new Box[] {a,b,c,d,e,f});
		t2 = new DeliveryTruck(new Box[] {a,b,a,b,a,b,a,b,a,b,d,d,d,a});
		t3 = new DeliveryTruck(new Box[] {b,c,d,e,b});
		currentMethodName = null;
	}

	@Test @Graded(description = "totalvolume", marks = 1)
	public void testTotalVolume()  {
		assertEquals(523, t1.totalVolume());
		assertEquals(642, t2.totalVolume());
		assertEquals(546, t3.totalVolume());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countidenticalboxes", marks = 1)
	public void testCountIdenticalBoxes()  {
		assertEquals(0, t1.countIdenticalBoxes());
		assertEquals(14, t2.countIdenticalBoxes());
		assertEquals(2, t3.countIdenticalBoxes());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "contains", marks = 1)
	public void testContains()  {
		assertTrue(t1.contains(1));
		assertTrue(t1.contains(30));
		assertTrue(t1.contains(162));
		assertTrue(t1.contains(6));
		assertFalse(t1.contains(8));

		assertFalse(t3.contains(1));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "add", marks = 1)
	public void testAdd()  {
		Box[] before = new Box[6];
		for(int i=0; i < t1.boxes.length; i++) {
			before[i] = t1.boxes[i];
		}
		Box b = new Box(10, 20, 30);
		t1.add(b);

		assertEquals(7, t1.boxes.length);

		assertNotNull(t1.boxes[6]);
		assertNotEquals(b, t1.boxes[6]); //not a reference copy of the added box
		assertEquals(6000, t1.boxes[6].volume());

		assertEquals(6523, t1.totalVolume());

		//make sure reference copies of already existing objects were made
		for(int i=0; i < t1.boxes.length - 1; i++) { 
			assertEquals(before[i], t1.boxes[i]);
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
