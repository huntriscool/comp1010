package rdsPractice._08_recursiveDataStructures.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import rdsPractice._08_recursiveDataStructures.Node;
import rdsPractice._08_recursiveDataStructures.attempts.Client;

/** Deterministic randomized checks against simple Java List computations. */
class ClientRandomisedTest {
    private static Node linked(List<Integer> values) {
        Node head = null;
        for (int i = values.size() - 1; i >= 0; i--) head = new Node(values.get(i), head);
        return head;
    }

    private static List<Integer> asList(Node node) {
        List<Integer> values = new ArrayList<>();
        while (node != null) {
            values.add(node.data);
            node = node.next;
        }
        return values;
    }

    @Test void allAlgorithmsMatchIndependentOracles() {
        Random random = new Random(0x5EED);
        for (int trial = 0; trial < 250; trial++) {
            List<Integer> data = new ArrayList<>();
            int length = random.nextInt(35);
            for (int i = 0; i < length; i++) data.add(random.nextInt(31) - 15);
            Node head = linked(data);
            int n = random.nextInt(8) + 1;
            int target = random.nextInt(31) - 15;
            int low = random.nextInt(31) - 15;
            int high = random.nextInt(31) - 15;
            int sum = 0, divisibleSum = 0, divisibleProduct = 1, countTarget = 0;
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, evenPositions = 0, inRange = 0;
            int firstIndex = -1;
            boolean sorted = true, allDivisible = true;
            List<Integer> greaterThan = new ArrayList<>();
            List<Integer> withoutTarget = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                int v = data.get(i);
                sum += v;
                min = Math.min(min, v);
                max = Math.max(max, v);
                if (v % n == 0) {
                    divisibleSum += v;
                    divisibleProduct *= v;
                } else allDivisible = false;
                if (v == target) {
                    countTarget++;
                    if (firstIndex == -1) firstIndex = i;
                } else withoutTarget.add(v);
                if (i % 2 == 0) evenPositions += v;
                if (i > 0 && data.get(i - 1) > v) sorted = false;
                if (v >= low && v <= high) inRange++;
                if (v > n) greaterThan.add(v);
            }
            String message = "trial " + trial + " values=" + data;
            assertEquals(sum, Client.sum(head), message);
            assertEquals(divisibleSum, Client.sumDivisibleByN(n, head), message);
            assertEquals(countTarget, Client.countOccurrences(target, head), message);
            assertEquals(max, Client.findMax(head), message);
            assertEquals(sorted, Client.isSorted(head), message);
            assertEquals(evenPositions, Client.sumEvenPositions(head), message);
            assertEquals(greaterThan, asList(Client.copyGreaterThan(n, head)), message);
            assertEquals(divisibleProduct, Client.productDivisibleByN(n, head), message);
            assertEquals(length, Client.countNodes(head), message);
            assertEquals(firstIndex != -1, Client.contains(target, head), message);
            assertEquals(min, Client.findMin(head), message);
            assertEquals(inRange, Client.countBetween(low, high, head), message);
            assertEquals(-1, Client.getValueAt(-1, head), message);
            assertEquals(-1, Client.getValueAt(length, head), message);
            for (int i = 0; i < length; i++) assertEquals(data.get(i).intValue(), Client.getValueAt(i, head), message);
            assertEquals(allDivisible, Client.allDivisibleByN(n, head), message);
            assertEquals(firstIndex, Client.indexOf(target, head), message);
            assertTrue(Client.areEqual(head, linked(data)), message);
            assertFalse(Client.areEqual(head, linkedWithExtra(data)), message);
            // Operations above must not mutate the shared list.
            assertEquals(data, asList(head), message);
            Node backwards = Client.reverse(linked(data));
            List<Integer> expectedReversed = new ArrayList<>(data);
            java.util.Collections.reverse(expectedReversed);
            assertEquals(expectedReversed, asList(backwards), message);
            assertEquals(withoutTarget, asList(Client.removeAll(target, head)), message);
        }
    }

    private static Node linkedWithExtra(List<Integer> data) {
        List<Integer> copy = new ArrayList<>(data);
        copy.add(0);
        return linked(copy);
    }
}
