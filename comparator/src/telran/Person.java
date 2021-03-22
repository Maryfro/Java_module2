package telran;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

/*@Override
    public int compareTo(Person o) {
      *//*  if (this.age > o.age) return 1;
        else if (this.age < o.age) return -1;
        else return 0;*//*
        return ((Integer)this.age).compareTo(o.age);
    }*/

    @Override
    public int compareTo(Person o) {
      /*  if (this.age > o.age) return 1;
        else if (this.age < o.age) return -1;
        else return 0;*/
        return (this.name).compareTo(o.name);
    }

    @Override
    public String toString() {
        return name +
                ", age: " + age;
    }
}
