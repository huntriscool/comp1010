public class BirthdayNode {
    private Person person;
    private BirthdayNode left;  //earlier birthdays in the year
    private BirthdayNode right; //same or later birthdays

    public BirthdayNode(Person person) {
        this.person = person;
        this.left = null;
        this.right = null;
    }

    public Person getPerson() {
        return person;
    }

    public BirthdayNode getLeft() {
        return left;
    }

    public BirthdayNode getRight() {
        return right;
    }

    public void setLeft(BirthdayNode left) {
        this.left = left;
    }

    public void setRight(BirthdayNode right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}