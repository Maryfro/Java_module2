package de.telran.application;

import de.telran.data.Person;


public class App {

    public static void main(String[] args) {
        Person person1 = new Person("Jakob", 15, 1.73);
        Person person2 = new Person("Jan", 3, 0.92);
        Person person3 = new Person("Ekaterina", 10, 1.25);
        Person person4 = new Person("Ilya", 4, 1.1);

        Person[] group = {person1, person2, person3, person4};

        System.out.println("initial array of persons");
        Person.display(group);
        Person.sortPersonByAge(group);
        System.out.println("---------------");
        System.out.println("sort by age, downgrading");
        Person.display(group);
        System.out.println("---------------");
        Person.sortPersonByAge1(group);
        System.out.println("sort by age, upgrading");
        Person.display(group);
        System.out.println("---------------");
        Person.sortPersonByName(group);
        System.out.println("sort by name, alphabetically");
        Person.display(group);
        System.out.println("---------------");
        Person.sortPersonByHeight(group);
        System.out.println("sort by height");
        Person.display(group);
        System.out.println("---------------");
        System.out.println("The oldest person is " + Person.findOldestPerson1(group));
        System.out.println("The longest name is " + Person.findLongestName1(group));

             /* int[] age = {person1.getAge(), person2.getAge(), person3.getAge(), person4.getAge()};
        int maxAge = Person.calculateAge(age);
        int[] nameLength = {person1.getName().length(), person2.getName().length(), person3.getName().length(),
                person4.getName().length()};
        int longestName = Person.calculateLongestName(nameLength);*/
    }


}
