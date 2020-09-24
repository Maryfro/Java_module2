package telran.data;


import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int birthDay;
    private String address;
    private Gender gender;

    public Person(String firstName, String lastName, int birthDay, String address, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                birthDay == (person.birthDay) &&
                address.equals(person.address) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDay, address, gender);
    }

    @Override
    public String toString() {
        return "Client " + firstName + " " +
                lastName +
                ", birthDay " + birthDay +
                ", address " + address +
                ", gender " + gender;
    }

    public String toStringName() {
        return "Client " + firstName + " " + lastName;
    }

    public static void displayPersons(Person[] clients) {
        for (Person p : clients) {
            System.out.println(p.toStringName());
        }
    }
}
