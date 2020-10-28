package telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>(Arrays.asList(5, 7, 8, 1, 3, 4));
        System.out.println(listNumbers);
        Collections.sort(listNumbers);
        System.out.println(listNumbers);
        Person p1 = new Person("John", 33);
        Person p2 = new Person("Amy", 48);
        Person p4 = new Person("Amy", 28);
        Person p3 = new Person("Kate", 55);
        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        //Collections.sort(people);
        people.sort(new PersonComparatorByNameAndAge());
        System.out.println(people);

    }
}
