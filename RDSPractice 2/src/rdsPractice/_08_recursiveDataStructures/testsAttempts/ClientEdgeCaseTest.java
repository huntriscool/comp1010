package rdsPractice._08_recursiveDataStructures.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import rdsPractice._08_recursiveDataStructures.Node;
import rdsPractice._08_recursiveDataStructures.attempts.Client;

class ClientEdgeCaseTest {
    private static Node list(int... values) {
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
    }

    private static List<Integer> values(Node node) {
        List<Integer> out = new ArrayList<>();
        IdentityHashMap<Node, Boolean> visited = new IdentityHashMap<>();
        while (node != null) {
            assertNull(visited.put(node, true), "a cycle was introduced");
            out.add(node.data);
            node = node.next;
        }
        return out;
    }

    @Test void allEmptyCases() {
        assertEquals(0, Client.sum(null));
        assertEquals(0, Client.sumDivisibleByN(3, null));
        assertEquals(0, Client.countOccurrences(3, null));
        assertEquals(Integer.MIN_VALUE, Client.findMax(null));
        assertTrue(Client.isSorted(null));
        assertEquals(0, Client.sumEvenPositions(null));
        assertNull(Client.copyGreaterThan(3, null));
        assertNull(Client.reverse(null));
        assertEquals(1, Client.productDivisibleByN(3, null));
        assertEquals(0, Client.countNodes(null));
        assertFalse(Client.contains(3, null));
        assertEquals(Integer.MAX_VALUE, Client.findMin(null));
        assertEquals(0, Client.countBetween(-10, 10, null));
        assertEquals(-1, Client.getValueAt(0, null));
        assertTrue(Client.allDivisibleByN(3, null));
        assertEquals(-1, Client.indexOf(3, null));
        assertNull(Client.removeAll(3, null));
        assertTrue(Client.areEqual(null, null));
        assertFalse(Client.areEqual(null, list(1)));
        assertFalse(Client.areEqual(list(1), null));
    }

    @Test void negativeAndZeroValues() {
        Node a = list(-6, 0, 5, -3, 9);
        assertEquals(5, Client.sum(a));
        assertEquals(0, Client.sumDivisibleByN(-3, a));
        assertEquals(0, Client.productDivisibleByN(2, a));
        assertEquals(-6, Client.findMin(a));
        assertEquals(9, Client.findMax(a));
        assertEquals(3, Client.countBetween(-6, 0, a));
        assertEquals(0, Client.countBetween(6, -6, a));
        assertEquals(0, Client.sumDivisibleByN(2, list(1, 3, 5)));
        assertEquals(1, Client.productDivisibleByN(2, list(1, 3, 5)));
        assertEquals(0, Client.countOccurrences(12, a));
        assertEquals(-1, Client.getValueAt(-1, a));
        assertEquals(-1, Client.getValueAt(Integer.MAX_VALUE, a));
        assertFalse(Client.allDivisibleByN(3, a));
        assertTrue(Client.allDivisibleByN(-3, list(0, -6, 9)));
        assertEquals(List.of(-6, 0, -3), values(Client.copyGreaterThan(-7, list(-6, -7, 0, -3, -8))));
    }

    @Test void zeroDivisorIsAlwaysRejected() {
        assertThrows(IllegalArgumentException.class, () -> Client.sumDivisibleByN(0, null));
        assertThrows(IllegalArgumentException.class, () -> Client.sumDivisibleByN(0, list(1)));
        assertThrows(IllegalArgumentException.class, () -> Client.productDivisibleByN(0, null));
        assertThrows(IllegalArgumentException.class, () -> Client.productDivisibleByN(0, list(1)));
        assertThrows(IllegalArgumentException.class, () -> Client.allDivisibleByN(0, null));
        assertThrows(IllegalArgumentException.class, () -> Client.allDivisibleByN(0, list(1)));
    }

    @Test void deepCopyKeepsOrderAndSharesNoNodes() {
        Node original = list(4, 7, 7, 2, 9);
        List<Integer> before = values(original);
        Node copied = Client.copyGreaterThan(4, original);
        assertEquals(List.of(7, 7, 9), values(copied));
        assertEquals(before, values(original));
        IdentityHashMap<Node, Boolean> originalNodes = new IdentityHashMap<>();
        for (Node n = original; n != null; n = n.next) originalNodes.put(n, true);
        for (Node n = copied; n != null; n = n.next) {
            assertFalse(originalNodes.containsKey(n), "copy must not share nodes");
        }
        copied.data = 99;
        assertEquals(before, values(original));
    }

    @Test void reverseReusesNodesAndCanRestoreOriginal() {
        Node first = list(1, 2, 3, 4);
        Node second = first.next;
        Node third = second.next;
        Node fourth = third.next;
        Node reversed = Client.reverse(first);
        assertSame(fourth, reversed);
        assertSame(third, reversed.next);
        assertSame(second, reversed.next.next);
        assertSame(first, reversed.next.next.next);
        assertNull(first.next);
        assertEquals(List.of(4, 3, 2, 1), values(reversed));
        Node restored = Client.reverse(reversed);
        assertSame(first, restored);
        assertEquals(List.of(1, 2, 3, 4), values(restored));
    }

    @Test void removeAllHandlesHeadTailAndRepeats() {
        Node first = list(4, 4, 1, 4, 2, 4, 4);
        Node keptFirst = first.next.next;
        Node keptSecond = keptFirst.next.next;
        Node after = Client.removeAll(4, first);
        assertSame(keptFirst, after);
        assertSame(keptSecond, after.next);
        assertNull(after.next.next);
        assertEquals(List.of(1, 2), values(after));
        assertEquals(List.of(8), values(Client.removeAll(3, list(8))));
        assertNull(Client.removeAll(8, list(8)));
    }

    @Test void compareSortingAndSearching() {
        assertTrue(Client.isSorted(list(1, 1, 2, 3)));
        assertFalse(Client.isSorted(list(2, 1)));
        assertTrue(Client.isSorted(list(Integer.MIN_VALUE, Integer.MAX_VALUE)));
        assertEquals(0, Client.indexOf(4, list(4, 4, 4)));
        assertEquals(-1, Client.indexOf(8, list(4, 4, 4)));
        assertTrue(Client.areEqual(list(-3, 0, -3), list(-3, 0, -3)));
        assertFalse(Client.areEqual(list(-3, 0, -3), list(-3, -3, 0)));
        assertEquals(2, Client.sumEvenPositions(list(-2, 10, 4, 10)));
    }

    @Test void longListDoesNotOverflowCallStack() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            Node head = null;
            for (int i = 0; i < 100_000; i++) head = new Node(1, head);
            assertEquals(100_000, Client.countNodes(head));
            assertEquals(100_000, Client.sum(head));
            assertEquals(50_000, Client.sumEvenPositions(head));
            assertTrue(Client.isSorted(head));
            assertEquals(0, Client.indexOf(1, head));
            Node reversed = Client.reverse(head);
            assertEquals(100_000, Client.countNodes(reversed));
            assertNull(Client.removeAll(1, reversed));
        });
    }
}
