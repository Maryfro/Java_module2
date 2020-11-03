package de.telran;

@FunctionalInterface
public interface LengthCounter {
    int count(String s); // only one abstract method
    String toString();

    default void print() {
        System.out.println("hello");
    }

    static void sayGoodBye() {
        System.out.println("Good bye");
    }
}
