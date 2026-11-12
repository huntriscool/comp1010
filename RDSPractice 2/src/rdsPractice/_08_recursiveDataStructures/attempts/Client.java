package rdsPractice._08_recursiveDataStructures.attempts;

import rdsPractice._08_recursiveDataStructures.Node;

public final class Client {
    private Client() {
        // Static utility class.
    }

    // Q1. Return the sum of all the values in the list.
    public static int sum(Node start) {
        if (start == null) {
            return 0;
        }
        return start.data + sum(start.next);
    }

    // Q2. Return the SUM (not the COUNT) of values divisible by n.
    public static int sumDivisibleByN(int n, Node start) {
        if (start == null) {
            return 0;
        }
        if (start.data % n == 0) {
            return start.data + sumDivisibleByN(n, start.next);
        }
        return sumDivisibleByN(n, start.next);
    }

    // Q3. Return how many times target appears in the list.
    public static int countOccurrences(int target, Node start) {
        if (start == null) {
            return 0;
        }
        if (start.data == target) {
            return 1 + countOccurrences(target, start.next);
        }
        return countOccurrences(target, start.next);
    }

    // Q4. Return the largest value, or Integer.MIN_VALUE for an empty list.
    public static int findMax(Node start) {
        if (start == null) {
            return Integer.MIN_VALUE;
        }
        int max = start.data;
        int maxOfRest = findMax(start.next);
        if (max < maxOfRest) {
            return maxOfRest;
        }
        return max;
    }

    

    // Q5. Ascending (non-decreasing) order; empty and single-node lists are sorted.
    public static boolean isSorted(Node start) {
        if (start == null || start.next == null) {
            return true;
        }
        if (start.data > start.next.data) {
            return false;
        }
        return isSorted(start.next);
    }

    // Q6. Sum the values at indexes 0, 2, 4, ...
    public static int sumEvenPositions(Node start) {
        if (start == null) {
            return 0;
        }
        if (start.next != null && start.next.next != null) {
            return start.data + sumEvenPositions(start.next.next);
        }
        return start.data;
        
    }

    // Q7. Make a separate list with values > n, retaining original order.
    public static Node copyGreaterThan(int n, Node start) {
        if (start == null) {
            return null;
        }
        Node restCopy = copyGreaterThan(n, start.next);

        if (start.data > n) {
            return new Node(start.data, restCopy);

        }
        return restCopy;
    }

    // Q8. Reverse links IN PLACE; return the new head. No new nodes are made.
    public static Node reverse(Node start) {
        Node reversed = null;
        Node current = start;
        while (current != null) {
            Node next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        return reversed;
    }

    // Q9. Product of values divisible by n; identity for none (including empty).
    public static int productDivisibleByN(int n, Node start) {
        if (start == null) {
            return 1;
        }
        if (start.data % n == 0) {
            return 1 * start.data * productDivisibleByN(n, start.next);
        }
        return productDivisibleByN(n, start.next);
    }

    // Q10. Return the number of nodes.
    public static int countNodes(Node start) {
        int count = 0;
        for (Node current = start; current != null; current = current.next) {
            count++;
        }
        return count;
    }

    // Q11. Return true if the list contains target.
    public static boolean contains(int target, Node start) {
        if (start == null) {
            return false;
        }
        if (start.data != target) {
            return contains(target, start.next);
        }
        return true;
    }

    // Q12. Return the smallest value, or Integer.MAX_VALUE for an empty list.
    public static int findMin(Node start) {
        if (start == null) {
            return Integer.MAX_VALUE;
        }
        int smallest = start.data;
        int restSmallest = findMin(start.next);
        if (smallest > restSmallest) {
            return findMin(start.next);
        }
        return smallest;
    }

    // Q13. Count values in the inclusive range [low, high].
    public static int countBetween(int low, int high, Node start) {
        if (start == null) {
            return 0;
        }
        if (start.data >= low && start.data <= high) {
            return 1 + countBetween(low, high, start.next);
        }
        return countBetween(low, high, start.next);
    }

    // Q14. Return value at zero-based index, or -1 if missing/negative.
    public static int getValueAt(int index, Node start) {
        if (index < 0) {
            return -1;
        }
        int i = 0;
        for (Node current = start; current != null; current = current.next) {
            if (i == index) {
                return current.data;
            }
            i++;
        }
        return -1;
    }

    // Q15. Return whether every value is divisible by n; empty => true.
    public static boolean allDivisibleByN(int n, Node start) {
        if (start == null) {
            return true;
        }
        if (start.data % n != 0) {
            return false;
        }
        return allDivisibleByN(n, start.next);
    }

    // Q16. Return zero-based index of first target, or -1 if absent.
    public static int indexOf(int target, Node start) {
        if (start == null) {
            return -1;
        }
        if (start.data == target) {
            return 0;
        }
        int result = indexOf(target, start.next);
        if (result == -1) {
            return -1;
        }
        return 1 + result;
    }

    // Q17. Remove all occurrences IN PLACE, returning the possibly new head.
    public static Node removeAll(int target, Node start) {
        while (start != null && start.data == target) {
            Node removed = start;
            start = start.next;
            removed.next = null;
        }
        Node current = start;
        while (current != null && current.next != null) {
            if (current.next.data == target) {
                Node removed = current.next;
                current.next = removed.next;
                removed.next = null;
            } else {
                current = current.next;
            }
        }
        return start;
    }

    // Q18. True if both lists contain identical values in identical order.
    public static boolean areEqual(Node first, Node second) {
        Node a = first;
        Node b = second;
        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    private static void requireNonZeroDivisor(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("n must not be zero");
        }
    }
}
