package telran.controller;

import telran.data.*;

public class App {
    public static void main(String[] args) {
        Book book = new Book("War and peace", "Leo Tolstoy");
        Printable book2 = new Book("Harry Potter", "J. Rowling");
        Printable magazine = new Magazine("Esquire");
        Printable newspaper = new Newspaper();

        Printable[] printables = {book, book2, magazine, newspaper};

        for (Printable p: printables) {
            p.print();
        }

        System.out.println("--------------");
        book.print2("I am book");
        newspaper.print2("newspaper");
        Printable.print1();

        Printable p = Printable.createObject("Vogue", 2);
        p.print();
        System.out.println("--------------");

        WaterPipe pipe = new WaterPipe();
        Lamp lamp = new Lamp();
        lamp.printState(0);

        Printable print = new Printable() {
            @Override
            public void print() {
                System.out.println("i am a printer");
            }
        };


    }

}
