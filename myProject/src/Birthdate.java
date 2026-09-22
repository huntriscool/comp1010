public class Birthdate {
    public Person person;
    public Date birthDate;

    public Birthdate(Person person, Date birthDate) {
        this.person = person;
        this.birthDate = birthDate;

    }

    public String toString() {
        return person + " " + birthDate;
    }
}
