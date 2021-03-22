package de.telran.application;

import de.telran.data.Dog;

public class DogApplication {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog("Sharik", 2);
        System.out.println(dog1);
        System.out.println(dog1.getName());
        dog.setName("Bobik");
        System.out.println(dog.getName());

    }


}
