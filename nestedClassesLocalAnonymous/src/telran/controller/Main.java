package telran.controller;

import telran.data.Message;
import telran.data.Person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Oleg");
        person1.personIntroduction();
        Person person2 = new Person("Anna") {
            private int age = 18;

            @Override
            public void personIntroduction() {
                super.personIntroduction();
                System.out.println("I am " + age + " y.o.");
            }
        };
        person2.personIntroduction();
        person1.displayMessage(new Message() {
            @Override
            public String greet() {
                return "Hello";
            }
        });
    }
}
