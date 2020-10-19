package telran;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.removeById(0);
        System.out.println(numbers.size());

        ArrayList<String> list = new ArrayList<String>();
        Person p1 = new Person("Jack", "Backersfield, 22");
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        System.out.println(persons.size());
    }
}
