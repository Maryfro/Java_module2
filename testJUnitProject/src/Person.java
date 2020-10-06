public class Person {
    private String firstName;
    private String lastName;

    private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static Person createPerson(String input) {
        String[] strings = input.split(" ");
        return new Person(strings[0], strings[1]);
    }
}
