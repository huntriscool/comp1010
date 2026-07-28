package practicePackage._07_arrayBasedList.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._07_arrayBasedList.attempts.*;

class CustomArrayListTest {
	public CustomArrayList emptyList, list1, list2, list3;

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {
		emptyList = new CustomArrayList();
		list1 = new CustomArrayList();
		list1.add(10);
		list1.add(70);
		list1.add(20);
		list1.add(90);
		//list1 = [10, 70, 20, 90]

		list2 = new CustomArrayList();
		list2.add(-5);
		list2.add(5);
		list2.add(2);
		list2.add(1);
		list2.add(-55);
		list2.add(-5);
		list2.add(0);
		list2.add(0);
		list2.add(8);
		list2.add(0);
		//list2 = [-5, 5, 2, 1, -55, -5, 0, 0, 8, 0]

		list3 = new CustomArrayList();
		list3.add(-6);
		//list3 = [-6]
		currentMethodName = null;
	}

	@Test @Graded(description = "grow", marks = 1)
	public void testGrow()  {
		CustomArrayList temp = new CustomArrayList();
		
		//check size of internal array increasing
		for(int i=0; i < 10; i++) {
			assertEquals(0, temp.nItems);
			assertEquals(10+5*i, temp.data.length);
			temp.grow();
		}

		//check data preservation
		temp = new CustomArrayList();
		temp.data[0] = 10;
		temp.data[1] = 70;
		temp.data[2] = 20;
		temp.data[3] = 90;
		temp.nItems = 4;
		assertEquals(4, temp.nItems);
		assertEquals(10, temp.data.length);
		assertEquals("[10, 70, 20, 90, 0, 0, 0, 0, 0, 0]", Arrays.toString(temp.data));	
		temp.grow();
		assertEquals(4, temp.nItems);
		assertEquals(15, temp.data.length);
		assertEquals("[10, 70, 20, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", Arrays.toString(temp.data));	
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "growint", marks = 1)
	public void testGrowInt()  {
		assertEquals(4, list1.currentSize());
		assertEquals(10, list1.currentCapacity());
		assertFalse(list1.isFull());

		list1.growInt(3);
		assertEquals("[10, 70, 20, 90]", list1.toString()); //ensure values are correct after grow() executes

		assertEquals(4, list1.currentSize());
		assertEquals(13, list1.currentCapacity());
		assertFalse(list1.isFull());

		list1.growInt(0);
		assertEquals("[10, 70, 20, 90]", list1.toString()); //ensure values are correct after grow() executes

		assertEquals(4, list1.currentSize());
		assertEquals(13, list1.currentCapacity());
		assertFalse(list1.isFull());

		list1.growInt(20);
		assertEquals("[10, 70, 20, 90]", list1.toString()); //ensure values are correct after grow() executes

		assertEquals(4, list1.currentSize());
		assertEquals(33, list1.currentCapacity());
		assertFalse(list1.isFull());

		list1.growInt(-5);

		assertEquals(4, list1.currentSize());
		assertEquals(33, list1.currentCapacity());
		assertFalse(list1.isFull());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "add", marks = 1)
	public void testAdd()  {
		list1.add(3);
		assertEquals("[10, 70, 20, 90, 3]",list1.toString());
		list1.add(-10);
		assertEquals("[10, 70, 20, 90, 3, -10]",list1.toString());
		emptyList.add(1);
		assertEquals("[1]",emptyList.toString());
		emptyList.add(-6);
		assertEquals("[1, -6]",emptyList.toString());		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "get", marks = 1)
	public void testGet()  {
		assertNull(list1.get(60));
		assertNull(list2.get(-12));
		assertEquals((Integer)10,list1.get(0));
		assertEquals((Integer)0,list2.get(7));
		assertNull(emptyList.get(0));
		assertNull(emptyList.get(4));	
		assertEquals((Integer)(-6),list3.get(0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "replace", marks = 1)
	public void testReplace()  {
		assertEquals(-1,list1.replace(-67, 2));
		assertEquals(-1,list3.replace(2, -132));
		assertEquals(0,list1.replace(10,33));
		assertEquals((Integer)33,list1.get(0));
		assertEquals(4,list2.replace(-55, 169234));
		assertEquals(0,list2.replace(-5, 2222));
		assertEquals((Integer)(-5),list2.get(5));
		assertEquals((Integer)2222,list2.get(0));		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "identical", marks = 1)
	public void testIdentical()  {
		CustomArrayList list4 = new CustomArrayList();
		list4.add(-6);
		assertFalse(emptyList.identical(list1));
		assertFalse(list1.identical(list2));
		assertTrue(list4.identical(list3));
		list4.add(3);
		assertFalse(list4.identical(list3));
		assertFalse(list3.identical(list2));
		CustomArrayList list5 = new CustomArrayList();
		assertTrue(list5.identical(emptyList));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sublist", marks = 1)
	public void testSubList()  {
		assertNull(list1.subList(0, 6));
		assertNull(list2.subList(-3, 2));
		assertNull(emptyList.subList(0, 2));
		assertNull(list3.subList(0, -1));
		assertNull(list2.subList(4, 1));
		assertNotNull(list1.subList(0, 2));
		assertEquals("[10, 70, 20]", list1.subList(0, 2).toString());
		assertNotNull(list1.subList(0, 0));
		assertEquals("[-6]",list3.subList(0, 0).toString());
		assertNotNull(list2.subList(4, 7));
		assertEquals("[-55, -5, 0, 0]", list2.subList(4, 7).toString());
		assertNotNull(list1.subList(3, 3));
		assertEquals("[90]",list1.subList(3, 3).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sort", marks = 1)
	public void testSort()  {
		emptyList.sort();
		list1.sort();
		list2.sort();
		list3.sort();
		assertEquals("[]",emptyList.toString());
		assertEquals("[10, 20, 70, 90]", list1.toString());
		assertEquals("[-55, -5, -5, 0, 0, 0, 1, 2, 5, 8]", list2.toString());
		assertEquals("[-6]",list3.toString());
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
