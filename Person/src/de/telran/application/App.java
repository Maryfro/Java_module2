package de.telran.application;

import de.telran.data.Person;


public class App {


    public static void main(String[] args) {
        Person person1 = new Person("Jakob", 15);
        Person person2 = new Person("Jan", 3);
        Person person3 = new Person("Ekaterina", 10);
        Person person4 = new Person("Olya", 4);

        Person[] group = {person1, person2, person3, person4};

        Person.display(group);

        int[] age = {person1.getAge(), person2.getAge(), person3.getAge(), person4.getAge()};
        int maxAge = Person.calculateAge(age);
        int[] nameLength = {person1.getName().length(), person2.getName().length(), person3.getName().length(),
                person4.getName().length()};
        int longestName = Person.calculateLongestName(nameLength);
        System.out.println("The oldest person is " + Person.findOldestPerson(group, maxAge));
        System.out.println("The longest name is " + Person.findLongestName(group, longestName));
    }


}
