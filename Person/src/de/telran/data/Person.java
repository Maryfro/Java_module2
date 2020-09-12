package de.telran.data;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
        } else {
            System.out.println("wrong age");
        }
    }

    @Override
    public String toString() {
        return name +
                ", age: " + age;
    }

    public static void display(Person[] group) {
        for (Person p : group) {
            System.out.println(p);
        }
    }

    public static Person findOldestPerson(Person[] group, int maxAge) {
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
    }

    public static Person findLongestName(Person[] group, int longestName) {
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

    }
}
