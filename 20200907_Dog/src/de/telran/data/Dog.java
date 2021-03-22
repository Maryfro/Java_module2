package de.telran.data;

public class Dog {

    private String name;
    private int age;
    private String breed;
    private double weight;
    private String nameOwner;
    private boolean dogStatus;

    public Dog() {
    }

    ;

    public Dog(String name, int age) {
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
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public boolean isDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(boolean dogStatus) {
        this.dogStatus = dogStatus;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                ", nameOwner='" + nameOwner + '\'' +
                '}';
    }
}
