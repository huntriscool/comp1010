package rdsPractice._08_recursiveDataStructures.testsAttempts;

import rdsPractice._08_recursiveDataStructures.Node;
import rdsPractice._08_recursiveDataStructures.attempts.Client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Right-click this file (or use the Testing tab) and run it to check your answers in Client.java.
// Each test method below is one question, with several test cases inside.
class ClientTest {

    // shared list used in most tests: 3 -> 6 -> 9 -> 4 -> 12
    private static final int[] A = {3, 6, 9, 4, 12};

    @Test
    void q1_sum() {
        assertEquals(34, Client.sum(build(A)), "sum(a)");
        assertEquals(0, Client.sum(null), "sum(empty)");
        assertEquals(6, Client.sum(build(new int[]{1, 2, 3})), "sum(1,2,3)");
    }

    @Test
    void q2_sumDivisibleByN() {
        assertEquals(30, Client.sumDivisibleByN(3, build(A)), "sumDivisibleByN(3, a)");
        assertEquals(22, Client.sumDivisibleByN(2, build(A)), "sumDivisibleByN(2, a)");
        assertEquals(0, Client.sumDivisibleByN(5, build(A)), "sumDivisibleByN(5, a)");
    }

    @Test
    void q3_countOccurrences() {
        assertEquals(3, Client.countOccurrences(4, build(new int[]{4, 1, 4, 4})), "countOccurrences(4, 4,1,4,4)");
        assertEquals(0, Client.countOccurrences(7, build(A)), "countOccurrences(7, a)");
    }

    @Test
    void q4_findMax() {
        assertEquals(12, Client.findMax(build(A)), "findMax(a)");
        assertEquals(-2, Client.findMax(build(new int[]{-5, -2, -9})), "findMax(-5,-2,-9)");
        assertEquals(Integer.MIN_VALUE, Client.findMax(null), "findMax(empty)");
    }

    @Test
    void q5_isSorted() {
        assertEquals(true, Client.isSorted(build(new int[]{1, 2, 2, 5})), "isSorted(1,2,2,5)");
        assertEquals(false, Client.isSorted(build(A)), "isSorted(a)");
        assertEquals(true, Client.isSorted(null), "isSorted(empty)");
    }

    @Test
    void q6_sumEvenPositions() {
        assertEquals(24, Client.sumEvenPositions(build(A)), "sumEvenPositions(a)");
        assertEquals(10, Client.sumEvenPositions(build(new int[]{10, 20})), "sumEvenPositions(10,20)");
        assertEquals(7, Client.sumEvenPositions(build(new int[]{7})), "sumEvenPositions(7)");
    }

    @Test
    void q7_copyGreaterThan() {
        assertEquals("6 -> 9 -> 12", toText(Client.copyGreaterThan(5, build(A))), "copyGreaterThan(5, a)");
        assertEquals("empty", toText(Client.copyGreaterThan(20, build(A))), "copyGreaterThan(20, a)");
        Node original = build(A);
        Client.copyGreaterThan(5, original);
        assertEquals("3 -> 6 -> 9 -> 4 -> 12", toText(original), "original list untouched");
    }

    @Test
    void q8_reverse() {
        assertEquals("12 -> 4 -> 9 -> 6 -> 3", toText(Client.reverse(build(A))), "reverse(a)");
        assertEquals("1", toText(Client.reverse(build(new int[]{1}))), "reverse(1)");
        assertEquals("empty", toText(Client.reverse(null)), "reverse(empty)");
    }

    @Test
    void q9_productDivisibleByN() {
        assertEquals(1944, Client.productDivisibleByN(3, build(A)), "productDivisibleByN(3, a)");
        assertEquals(288, Client.productDivisibleByN(2, build(A)), "productDivisibleByN(2, a)");
        assertEquals(1, Client.productDivisibleByN(5, build(A)), "productDivisibleByN(5, a)");
    }

    @Test
    void q10_countNodes() {
        assertEquals(5, Client.countNodes(build(A)), "countNodes(a)");
        assertEquals(0, Client.countNodes(null), "countNodes(empty)");
    }

    @Test
    void q11_contains() {
        assertEquals(true, Client.contains(9, build(A)), "contains(9, a)");
        assertEquals(false, Client.contains(10, build(A)), "contains(10, a)");
        assertEquals(false, Client.contains(1, null), "contains(1, empty)");
    }

    @Test
    void q12_findMin() {
        assertEquals(3, Client.findMin(build(A)), "findMin(a)");
        assertEquals(-1, Client.findMin(build(new int[]{8, -1, 5})), "findMin(8,-1,5)");
        assertEquals(Integer.MAX_VALUE, Client.findMin(null), "findMin(empty)");
    }

    @Test
    void q13_countBetween() {
        assertEquals(3, Client.countBetween(4, 9, build(A)), "countBetween(4, 9, a)");
        assertEquals(0, Client.countBetween(20, 30, build(A)), "countBetween(20, 30, a)");
        assertEquals(5, Client.countBetween(3, 12, build(A)), "countBetween(3, 12, a)");
    }

    @Test
    void q14_getValueAt() {
        assertEquals(3, Client.getValueAt(0, build(A)), "getValueAt(0, a)");
        assertEquals(9, Client.getValueAt(2, build(A)), "getValueAt(2, a)");
        assertEquals(-1, Client.getValueAt(5, build(A)), "getValueAt(5, a)");
    }

    @Test
    void q15_allDivisibleByN() {
        assertEquals(true, Client.allDivisibleByN(3, build(new int[]{3, 6, 9})), "allDivisibleByN(3, 3,6,9)");
        assertEquals(false, Client.allDivisibleByN(3, build(A)), "allDivisibleByN(3, a)");
        assertEquals(true, Client.allDivisibleByN(3, null), "allDivisibleByN(3, empty)");
    }

    @Test
    void q16_indexOf() {
        assertEquals(2, Client.indexOf(9, build(A)), "indexOf(9, a)");
        assertEquals(0, Client.indexOf(4, build(new int[]{4, 1, 4})), "indexOf(4, 4,1,4)");
        assertEquals(-1, Client.indexOf(7, build(A)), "indexOf(7, a)");
    }

    @Test
    void q17_removeAll() {
        assertEquals("1 -> 2", toText(Client.removeAll(4, build(new int[]{4, 1, 4, 4, 2}))), "removeAll(4, 4,1,4,4,2)");
        assertEquals("3 -> 6 -> 9 -> 4 -> 12", toText(Client.removeAll(7, build(A))), "removeAll(7, a)");
        assertEquals("empty", toText(Client.removeAll(5, build(new int[]{5, 5}))), "removeAll(5, 5,5)");
    }

    @Test
    void q18_areEqual() {
        assertEquals(true, Client.areEqual(build(new int[]{1, 2, 3}), build(new int[]{1, 2, 3})), "areEqual(1,2,3 / 1,2,3)");
        assertEquals(false, Client.areEqual(build(new int[]{1, 2, 3}), build(new int[]{1, 2})), "areEqual(1,2,3 / 1,2)");
        assertEquals(false, Client.areEqual(build(new int[]{1, 2, 3}), build(new int[]{1, 2, 4})), "areEqual(1,2,3 / 1,2,4)");
        assertEquals(true, Client.areEqual(null, null), "areEqual(empty / empty)");
    }

    // ===== helpers (you don't need to touch these) =====

    static Node build(int[] values) {
        Node first = null;
        for (int i = values.length - 1; i >= 0; i--) {
            first = new Node(values[i], first);
        }
        return first;
    }

    static String toText(Node start) {
        if (start == null) {
            return "empty";
        }
        String text = "" + start.data;
        Node current = start.next;
        while (current != null) {
            text = text + " -> " + current.data;
            current = current.next;
        }
        return text;
    }
}