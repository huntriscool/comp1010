package rdsPractice._08_recursiveDataStructures;

/**
 * A node in a singly-linked list of integers.
 * The fields are public deliberately, to match the linked-list exercises.
 * Lists used by the exercises must be finite and must not contain cycles.
 */
public class Node {
    public int data;
    public Node next;

    public Node() {
        this(0, null);
    }

    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
