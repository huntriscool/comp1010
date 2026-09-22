public class Person {
    public String firstName;
    public String lastName;
    public Budget dollarBudget;

    public Person(String firstName, String lastName, Budget dollarBudget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dollarBudget = dollarBudget;
    }

    public String toString() {
        return firstName + " " + lastName + " $" + dollarBudget;
    }

}
