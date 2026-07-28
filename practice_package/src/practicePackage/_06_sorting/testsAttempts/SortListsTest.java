package practicePackage._06_sorting.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import practicePackage._06_sorting.attempts.*;

@SuppressWarnings("unused")
public class SortListsTest {

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach
	public void run() {

		currentMethodName = null;
	}

	@Test @Graded(description = "insertunique", marks = 1)
	public void testInsertUnique()  {
		ArrayList<Integer> list = new ArrayList<>();
		assertNull(SortLists.insertUnique(null, 10));
		assertNotNull(SortLists.insertUnique(list, 10));
		assertEquals("[10]", SortLists.insertUnique(list, 10).toString());
		assertEquals("[10, 70]", SortLists.insertUnique(list, 70).toString());
		assertEquals("[10, 20, 70]", SortLists.insertUnique(list, 20).toString());
		assertEquals("[10, 20, 70, 90]", SortLists.insertUnique(list, 90).toString());
		assertEquals("[5, 10, 20, 70, 90]", SortLists.insertUnique(list, 5).toString());
		assertEquals("[5, 10, 20, 70, 90]", SortLists.insertUnique(list, 20).toString());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sortinput", marks = 1)
	public void testSortInput()  {
		assertNull(SortLists.sortInput(null, 1));
		assertEquals("[[], [], []]", SortLists.sortInput(new int[][] {}, 3).toString());

		int[][] data = new int[][] { { 1, 3 }, { 2, 1 }, { 2, 0 } };
		assertEquals("[[2], [2, 3], [0, 1], [1]]", SortLists.sortInput(data, 4).toString());
		assertEquals("[[1, 3], [2, 1], [2, 0]]", Arrays.deepToString(data));

		data = new int[][] { { 1, 2 }, { 2, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 2, 0 } };
		assertEquals("[[1, 2], [0, 2], [0, 1]]", SortLists.sortInput(data, 3).toString());

		data = new int[][] { { 5, 1 }, { 1, 2 }, { 2, 0 }, { 0, 1 }, { 0, 4 }, { 4, 5 } };
		assertEquals("[[1, 2, 4], [0, 2, 5], [0, 1], [], [0, 5], [1, 4]]", SortLists.sortInput(data, 6).toString());

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
