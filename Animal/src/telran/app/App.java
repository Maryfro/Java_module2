package telran.app;

import telran.data.*;

public class App {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Spitz", "white", "Chappy", "Nick");
        System.out.println("dog 1 can do the following ");
        dog1.eat();
        dog1.sleep();
        dog1.bark();
        System.out.println("----------------------");

        Animal dog2 = new Dog("Corgi", "multicolored", "Cookie", "Jack");
        System.out.println("dog 2 can do the following ");
        dog2.eat();
        dog2.sleep();
        ((Dog) dog2).bark(); // type casting
        //  ((Dog)animal).bark(); !!ClassCastException
        System.out.println("----------------------");

        Cat cat1 = new Cat("Siam", "grey", "Brianna", "Kate");
        System.out.println("cat 1 can do the following ");
        cat1.play();
        System.out.println("----------------------");

        WildAnimal bear = new WildAnimal("bear", "brown", "Canada");
        System.out.println("wild bear can do the following ");
        bear.run();
        System.out.println("the habitat of bear is " + bear.getHabitat());
        bear.migration("Alaska");
        System.out.println("----------------------");

        Pet pet1 = new Cat("cat", "white", "Luna", "Anna");
        Pet pet2 = new Dog("dog", "brown", "Jackie", "Jim");
        System.out.print(pet1.getType() + " ");
        pet1.voice();
        System.out.print(pet2.getType() + " ");
        pet2.voice();
        System.out.println("----------------------");
        // Pet.displayVoice(pet1);
        // Pet.displayVoice(pet2);

        Animal animal = new WildAnimal("cow", "white and brown", "Europe");
        System.out.println("Habitat of cow is ");
        System.out.println(((WildAnimal) animal).getHabitat());

        System.out.println("----------------------");
        System.out.println("info about dog 1: ");
        dog1.displayInfo("black");
        //  System.out.println(animal.getType());
        System.out.println("----------------------");

        System.out.print("cat 1 is instance of Animal: ");
        System.out.println(cat1 instanceof Animal);
        System.out.print("animal is instance of Dog: ");
        System.out.println(animal instanceof Dog);
        System.out.print("bear is instance of Animal: ");
        System.out.println(bear instanceof Animal);
        // System.out.println(bear instanceof Pet); incompatible types:
    }
}
