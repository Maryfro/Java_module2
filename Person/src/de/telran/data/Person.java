package de.telran.data;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
        } else {
            System.out.println("wrong age");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name +
                ", age: " + age
                + ", height: " + height;
    }

    public static void display(Person[] group) {
        for (Person p : group) {
            System.out.println(p);
        }
    }

    private int compareToPersonByHeight(Person p) {
        if (this.height > p.height) {
            return 1;
        } else if (this.height < p.height) {
            return -1;
        } else {
            return 0;
        }
    }

    private static int comparePersonByAge(Person p1, Person p2) {
        if (p1.age > p2.age) {
            return 1;
        } else if (p1.age < p2.age) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void sortPersonByHeight(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < (group.length - 1) - i; j++) {
                if (group[j].compareToPersonByHeight(group[j + 1]) > 0) {
                    Person temp = group[j + 1];
                    group[j + 1] = group[j];
                    group[j] = temp;
                }
            }
        }
    }

    private int compareToPersonByAge(Person p) {
        if (this.age > p.age) {
            return 1;
        } else if (this.age < p.age) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void sortPersonByAge1(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < (group.length - 1) - i; j++) {
                if (group[j].compareToPersonByAge(group[j + 1]) < 0) {
                    Person temp = group[j + 1];
                    group[j + 1] = group[j];
                    group[j] = temp;
                }
            }
        }
    }

    public static void sortPersonByAge(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < (group.length - 1) - i; j++) {
                if (comparePersonByAge(group[j], group[j + 1]) > 0) {
                    Person temp = group[j + 1];
                    group[j + 1] = group[j];
                    group[j] = temp;
                }
            }
        }
    }

    public static void sortPersonByName(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < (group.length - 1) - i; j++) {
                if (group[j].name.compareTo(group[j + 1].name) > 0) {
                    Person temp = group[j + 1];
                    group[j + 1] = group[j];
                    group[j] = temp;
                }
            }
        }
    }


    public static Person findOldestPerson1(Person[] group) {
        Person oldestPerson = group[0];
        for (int i = 0; i < group.length; i++) {
            if (group[i].getAge() > oldestPerson.getAge()) {
                oldestPerson = group[i];
            }
        }
        return oldestPerson;
    }

    public static Person findLongestName1(Person[] group) {
        Person n = group[0];
        for (int i = 0; i < group.length; i++) {
            if (group[i].getName().length() > n.getName().length()) {
                n = group[i];
            }
        }
        return n;
    }

/*    public static Person findOldestPerson(Person[] group, int maxAge) {
        Person p = group[0];
        for (int i = 0; i < group.length; i++) {
            if(group[i].getAge() == maxAge){
                p = group[i];
                break;
            }
        }
        return p;
    }

    public static int calculateAge(int[] age) {
        int max = age[0];
        for (int a : age) {
            max = Math.max(max, a);
        }
        return max;
    }*/

 /*   public static Person findLongestName(Person[] group, int longestName) {
        Person n = group[0];
        for (int i = 0; i < group.length; i++) {
            if(group[i].getName().length() == longestName){
                n = group[i];
                break;
            }
        }
        return n;
    }

    public static int calculateLongestName(int[] name) {
        int max = name[0];
        for (int n : name) {
            max = Math.max(max, n);
        }
        return max;

    }*/
}
