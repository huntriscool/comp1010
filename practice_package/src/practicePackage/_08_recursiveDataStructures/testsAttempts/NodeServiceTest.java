package practicePackage._08_recursiveDataStructures.testsAttempts;

import java.util.ArrayList;
import serviceClasses.Graded;
import java.lang.reflect.*;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage._08_recursiveDataStructures.Node;
import practicePackage._08_recursiveDataStructures.attempts.*;

public class NodeServiceTest {	
	private Node a, b, c, d, e, f;
	private Node a1, b1, c1, d1, e1, f1;

	public void ensureNoModify() {
		assertNotNull(NodeService.toString(a));
		assertEquals("[-12, 0, 36, 49, 25, 17]", NodeService.toString(a));

		assertNotNull(NodeService.toString(b));
		assertEquals("[0, 36, 49, 25, 17]", NodeService.toString(b));

		assertNotNull(NodeService.toString(c));
		assertEquals("[36, 49, 25, 17]", NodeService.toString(c));

		assertNotNull(NodeService.toString(d));
		assertEquals("[49, 25, 17]", NodeService.toString(d));

		assertNotNull(NodeService.toString(e));
		assertEquals("[25, 17]", NodeService.toString(e));

		assertNotNull(NodeService.toString(f));
		assertEquals("[17]", NodeService.toString(f));
	}

	public static int score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	ArrayList<String> methodsPassed = new ArrayList<String>();

    @BeforeEach 
	public void run() {		
		f = new Node(17, null);
		e = new Node(25, f);
		d = new Node(49, e);
		c = new Node(36, d);
		b = new Node(0, c);
		a = new Node(-12, b);
		//a -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;

		f1 = new Node(17, null);
		e1 = new Node(25, f1);
		d1 = new Node(49, e1);
		c1 = new Node(36, d1);
		b1 = new Node(0, c1);
		a1 = new Node(-12, b1);
		//a1 -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		currentMethodName = null;
	}

	@Test @Graded(description = "sumodd", marks = 1)
	public void testSumOdd()  {
		assertEquals(91, NodeService.sumOdd(a));
		assertEquals(91, NodeService.sumOdd(b));
		assertEquals(91, NodeService.sumOdd(c));
		assertEquals(91, NodeService.sumOdd(d));
		assertEquals(42, NodeService.sumOdd(e));
		assertEquals(17, NodeService.sumOdd(f));
		assertEquals(0, NodeService.sumOdd(null));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "countpositives", marks = 1)
	public void testCountPositives()  {
		assertEquals(4, NodeService.countPositives(a));
		assertEquals(4, NodeService.countPositives(b));
		assertEquals(4, NodeService.countPositives(c));
		assertEquals(3, NodeService.countPositives(d));
		assertEquals(2, NodeService.countPositives(e));
		assertEquals(1, NodeService.countPositives(f));
		assertEquals(0, NodeService.countPositives(null));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getfirstpositivenode", marks = 1)
	public void testGetFirstPositiveNode()  {
		assertEquals(c, NodeService.getFirstPositiveNode(a));
		assertEquals(c, NodeService.getFirstPositiveNode(b));
		assertEquals(c, NodeService.getFirstPositiveNode(c));
		assertEquals(d, NodeService.getFirstPositiveNode(d));
		assertEquals(e, NodeService.getFirstPositiveNode(e));
		assertEquals(f, NodeService.getFirstPositiveNode(f));
		assertNull(NodeService.getFirstPositiveNode(null));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "getitemat", marks = 1)
	public void testGetItemAt()  {
		assertNull(NodeService.getItemAt(f.next, 0));
		for(int i=0; i < 6; i++) {
			assertNotNull(NodeService.getItemAt(a, i));
		}
		for(int i=0; i < 5; i++) {
			assertNotNull(NodeService.getItemAt(b, i));
		}
		for(int i=0; i < 4; i++) {
			assertNotNull(NodeService.getItemAt(c, i));
		}
		for(int i=0; i < 3; i++) {
			assertNotNull(NodeService.getItemAt(d, i));
		}
		for(int i=0; i < 2; i++) {
			assertNotNull(NodeService.getItemAt(e, i));
		}
		for(int i=0; i < 1; i++) {
			assertNotNull(NodeService.getItemAt(f, i));
		}
		
		assertEquals(a, NodeService.getItemAt(a, 0));
		assertEquals(b, NodeService.getItemAt(a, 1));
		assertEquals(c, NodeService.getItemAt(a, 2));
		assertEquals(d, NodeService.getItemAt(a, 3));
		assertEquals(e, NodeService.getItemAt(a, 4));
		assertEquals(f, NodeService.getItemAt(a, 5));
		
		assertEquals(b, NodeService.getItemAt(b, 0));
		assertEquals(c, NodeService.getItemAt(b, 1));
		assertEquals(d, NodeService.getItemAt(b, 2));
		assertEquals(e, NodeService.getItemAt(b, 3));
		assertEquals(f, NodeService.getItemAt(b, 4));
		
		assertEquals(c, NodeService.getItemAt(c, 0));
		assertEquals(d, NodeService.getItemAt(c, 1));
		assertEquals(e, NodeService.getItemAt(c, 2));
		assertEquals(f, NodeService.getItemAt(c, 3));
		
		assertEquals(d, NodeService.getItemAt(d, 0));
		assertEquals(e, NodeService.getItemAt(d, 1));
		assertEquals(f, NodeService.getItemAt(d, 2));
		
		assertEquals(e, NodeService.getItemAt(e, 0));
		assertEquals(f, NodeService.getItemAt(e, 1));
		
		assertEquals(f, NodeService.getItemAt(f, 0));
		
		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "append", marks = 1)
	public void testAppend()  {
		/*
		 * f = new Node(17, null);
		e = new Node(25, f);
		d = new Node(49, e);
		c = new Node(36, d);
		b = new Node(0, c);
		a = new Node(-12, b);
		//a -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;

		f1 = new Node(17, null);
		e1 = new Node(25, f1);
		d1 = new Node(49, e1);
		c1 = new Node(36, d1);
		b1 = new Node(0, c1);
		a1 = new Node(-12, b1);
		//a1 -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		 */
		assertFalse(NodeService.append(null, 10));
		assertTrue(NodeService.append(a, 1729));
		assertNotNull(a.next);
		assertEquals(b, a.next);
		assertNotNull(b.next);
		assertEquals(c, b.next);
		assertNotNull(c.next);
		assertEquals(d, c.next);
		assertNotNull(d.next);
		assertEquals(e, d.next);
		assertNotNull(e.next);
		assertEquals(f, e.next);
		assertNotNull(f.next);
		assertEquals(1729, f.next.data);
		assertNull(f.next.next);
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "same", marks = 1)
	public void testSame()  {
		assertTrue(NodeService.same(a, a1));

		Node f2 = new Node(17, null);
		Node e2 = new Node(25, f2);
		Node d2 = new Node(49, e2);
		Node c2 = new Node(-36, d2);
		Node b2 = new Node(0, c2);
		Node a2 = new Node(-12, b2);
		//a -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		//a2 -> -12 -> 0 -> -36 -> 49 -> 25 -> 17 -> null;		

		assertFalse(NodeService.same(a, a2));

		c2.data = 36;
		e2.next = null;
		//a  -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		//a2 -> -12 -> 0 -> 36 -> 49 -> 25 -> null;

		assertFalse(NodeService.same(a, a2));

		e2.next = f2;
		f2.next = new Node(20, null);
		//a -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		//a2 -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> 20 -> null;

		assertFalse(NodeService.same(a, a2));

		f2.next = null;

		assertTrue(NodeService.same(a, a2));

		//a  -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;		
		//a2 -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null;

		Node tempA1 = new Node(10);
		Node tempA2 = new Node(70, tempA1);
		Node tempA3 = new Node(20, tempA2);
		Node tempA4 = new Node(90, tempA3);
		//tempA4 -> 90 -> 20 -> 70 -> 10

		Node tempB1 = new Node(90);
		Node tempB2 = new Node(20, tempB1);
		Node tempB3 = new Node(10, tempB2);
		Node tempB4 = new Node(70, tempB3);
		//tempB4 -> 70 -> 10 -> 20 -> 90
		
		assertTrue(NodeService.same(tempA4, tempB4));

		ensureNoModify();
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Graded(description = "sort", marks = 1)
	public void testSort()  {
		//a -> -12 -> 0 -> 36 -> 49 -> 25 -> 17 -> null
		Node temp = NodeService.sort(a, true);
		//temp -> -12 -> 0 -> 17 -> 25 -> 36 -> 49 -> null
		assertNotNull(temp);
		assertEquals("[-12, 0, 17, 25, 36, 49]", NodeService.toString(temp));

		temp = NodeService.sort(a, false);
		//temp -> 49 -> 36 -> 25 -> 17 -> 0 -> -12 -> null
		assertNotNull(temp);
		assertEquals("[49, 36, 25, 17, 0, -12]", NodeService.toString(temp));

		Node x = new Node(-1, null);
		Node sx = NodeService.sort(x, true);
		assertNotNull(sx);
		assertEquals("[-1]", NodeService.toString(sx));

		Node y = null;
		Node sy = NodeService.sort(y, false);
		assertNull(sy);
		
		ensureNoModify();
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
