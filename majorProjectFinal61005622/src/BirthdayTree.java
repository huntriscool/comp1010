import java.util.ArrayList;

/*
 * A binary search tree of people ordered by birthday (month, then day,
 * year ignored). Earlier birthdays go left, and anything equal or later
 * goes right, so two friends with the same birthday are both kept.
 */
public class BirthdayTree {
    private BirthdayNode root;
    private int size;

    public BirthdayTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Person person) {
        if(person == null) {
            throw new IllegalArgumentException("Cannot insert a null person");
        }
        root = insertInto(root, person);
        size++;
    }

    /*
     * Returns the root of the subtree with the person added.
     * Reaching an empty spot (null) is the base case: that is where
     * the new node goes. Otherwise we pass the job down one level.
     */
    private BirthdayNode insertInto(BirthdayNode node, Person person) {
        if(node == null) {
            return new BirthdayNode(person);
        }
        int order = person.getBirthday().compareMonthDay(node.getPerson().getBirthday());
        if(order < 0) {
            node.setLeft(insertInto(node.getLeft(), person));
        }
        else {
            node.setRight(insertInto(node.getRight(), person));
        }
        return node;
    }

    // Everyone in calendar order (January first, December last)
    public ArrayList<Person> getInOrder() {
        ArrayList<Person> result = new ArrayList<>();
        collectInOrder(root, result);
        return result;
    }

    // Left subtree, then this person, then right subtree
    private void collectInOrder(BirthdayNode node, ArrayList<Person> result) {
        if(node == null) {
            return;
        }
        collectInOrder(node.getLeft(), result);
        result.add(node.getPerson());
        collectInOrder(node.getRight(), result);
    }

    // Reuses getInOrder, so results stay in calendar order
    public ArrayList<Person> getByMonth(int month) {
        ArrayList<Person> result = new ArrayList<>();
        for(Person person : getInOrder()) {
            if(person.getBirthday().isInMonth(month)) {
                result.add(person);
            }
        }
        return result;
    }

    /*
     * The tree is ordered by birthday, not name, so a name search
     * has to check both sides. Returns null if nobody matches.
     */
    public Person findByName(String name) {
        return findIn(root, name);
    }

    private Person findIn(BirthdayNode node, String name) {
        if(node == null) {
            return null;
        }
        if(node.getPerson().getName().equalsIgnoreCase(name)) {
            return node.getPerson();
        }
        Person inLeft = findIn(node.getLeft(), name);
        if(inLeft != null) {
            return inLeft;
        }
        return findIn(node.getRight(), name);
    }

    public boolean contains(String name) {
        return findByName(name) != null;
    }

    // Number of levels: 0 for an empty tree, 1 for a single person
    public int height() {
        return heightOf(root);
    }

    private int heightOf(BirthdayNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(heightOf(node.getLeft()), heightOf(node.getRight()));
    }

    public boolean remove(String name) {
        Person target = findByName(name);
        if(target == null) {
            return false;
        }
        root = removeFrom(root, target);
        size--;
        return true;
    }

    // Searches by object identity so exactly one node is removed, even with duplicate birthdays
    private BirthdayNode removeFrom(BirthdayNode node, Person target) {
        if(node == null) {
            return null;
        }
        if(node.getPerson() == target) {
            return removeNode(node);
        }
        node.setLeft(removeFrom(node.getLeft(), target));
        node.setRight(removeFrom(node.getRight(), target));
        return node;
    }

    /*
     * Takes one node out and returns what should take its place.
     * Zero or one child: the child (or null) just moves up.
     * Two children: the earliest person in the right subtree
     * takes over, which keeps everything in the right order.
     */
    private BirthdayNode removeNode(BirthdayNode node) {
        if(node.getLeft() == null) {
            return node.getRight();
        }
        if(node.getRight() == null) {
            return node.getLeft();
        }
        BirthdayNode replacement = smallestIn(node.getRight());
        BirthdayNode newRight = removeSmallest(node.getRight());
        replacement.setLeft(node.getLeft());
        replacement.setRight(newRight);
        return replacement;
    }

    private BirthdayNode smallestIn(BirthdayNode node) {
        if(node.getLeft() == null) {
            return node;
        }
        return smallestIn(node.getLeft());
    }

    // Returns the subtree with its leftmost (earliest) node cut out
    private BirthdayNode removeSmallest(BirthdayNode node) {
        if(node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeSmallest(node.getLeft()));
        return node;
    }
}