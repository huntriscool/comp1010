import rdsPractice._08_recursiveDataStructures.Node;
import rdsPractice._08_recursiveDataStructures.attempts.Client;

/** Start here in VS Code: Run Java on App.java to see a working demonstration. */
public class App {
    public static void main(String[] args) {
        if (args.length > 0 && ("--help".equals(args[0]) || "-h".equals(args[0]))) {
            System.out.println("RDSPractice: 18 linked-list exercises with JUnit tests");
            System.out.println("Run: java -cp bin App");
            System.out.println("Test: ./scripts/test.sh  (Windows: scripts\\test.bat)");
            return;
        }
        Node sample = list(3, 6, 9, 4, 12);
        System.out.println("RDSPractice - working linked-list demonstration");
        System.out.println("Example list: " + describe(sample));
        System.out.println("Q1  sum: " + Client.sum(sample));
        System.out.println("Q2  sum divisible by 3: " + Client.sumDivisibleByN(3, sample));
        System.out.println("Q4  maximum: " + Client.findMax(sample));
        System.out.println("Q5  sorted: " + Client.isSorted(sample));
        System.out.println("Q7  new list with values > 5: " + describe(Client.copyGreaterThan(5, sample)));
        System.out.println("Q8  reversed copy: " + describe(Client.reverse(copy(sample))));
        System.out.println("Q17 remove 4 from copy: " + describe(Client.removeAll(4, copy(sample))));
        System.out.println("Original list is still: " + describe(sample));
        System.out.println("Run scripts/test.sh (or scripts\\test.bat) to verify all 18 exercises.");
    }

    private static Node list(int... values) {
        Node result = null;
        for (int i = values.length - 1; i >= 0; i--) result = new Node(values[i], result);
        return result;
    }

    private static Node copy(Node node) {
        // Clone every value, including Integer.MIN_VALUE.
        Node head = null;
        Node tail = null;
        for (Node current = node; current != null; current = current.next) {
            Node newNode = new Node(current.data);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    private static String describe(Node node) {
        if (node == null) return "empty";
        StringBuilder result = new StringBuilder();
        for (Node current = node; current != null; current = current.next) {
            if (result.length() > 0) result.append(" -> ");
            result.append(current.data);
        }
        return result.toString();
    }
}
