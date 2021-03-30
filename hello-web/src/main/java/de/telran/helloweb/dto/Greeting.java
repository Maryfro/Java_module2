package de.telran.helloweb.dto;

//Data transfer object
public class Greeting {

    public String name;
    public String greeting;

    public Greeting(String name, String greeting) {
        this.name = name;
        this.greeting = greeting;
    }

    public Greeting() {
    }

    @Override
    public String toString() {
        return greeting + " " + name;
    }
}
