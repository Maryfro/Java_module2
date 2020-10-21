package telran;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.removeById(1);
        System.out.println(numbers.size());

        ArrayList<String> list = new ArrayList<String>();
        Person p1 = new Person("Jack", "Backersfield, 22");
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        System.out.println(persons.size());

        LinkedList <Integer> digits = new LinkedList<>();
        digits.add(1);
        digits.add(2);
        digits.add(3);
        digits.removeById(1);
       // digits.removeById(0);
       // System.out.println(digits.get(0).intValue());
    }
}
