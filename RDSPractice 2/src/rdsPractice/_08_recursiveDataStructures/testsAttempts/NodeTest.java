package rdsPractice._08_recursiveDataStructures.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import rdsPractice._08_recursiveDataStructures.Node;

class NodeTest {
    @Test void constructorsAndPublicLinks() {
        Node zero = new Node();
        assertEquals(0, zero.data);
        assertNull(zero.next);
        Node end = new Node(7);
        assertEquals(7, end.data);
        assertNull(end.next);
        Node head = new Node(-2, end);
        assertEquals(-2, head.data);
        assertSame(end, head.next);
    }
}
