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
        System.out.println("Size of List of numbers is " + numbers.size());

        ArrayList<String> list = new ArrayList<String>();
        Person p1 = new Person("Jack", "Backersfield, 22");
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        System.out.println("Size of List of persons is " + persons.size());

        LinkedList<Integer> digits = new LinkedList<>();
        digits.add(0);
        digits.add(1);
        digits.add(2);
        //digits.removeById(1);
        digits.removeById(0);
        System.out.println("New first value after removal " + digits.get(0).intValue());
        digits.removeById(digits.size() - 1);
        System.out.println("New last value after removal " + digits.get(digits.size() - 1));
        // How to use methods getFirst and getLast?
        // Why test remove by index is passing with the same value and different indices?

    }
}
