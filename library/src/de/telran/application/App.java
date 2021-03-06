package de.telran.application;

import de.telran.dao.Library;
import de.telran.dao.MyLibrary;
import de.telran.data.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Book book1 = new Book("War and peace", "Leo Tolstoy", 1865, 2345);
        Book book2 = new Book("The Shining", "Steven King", 1977, 765);
        Book book3 = new Book("The Idiot", "Fedor Dostoevsky", 1861, 1276);
        Book book4 = new Book("Catcher in the rye", "Jerome Salinger", 1951, 372);
        Library myLibrary = new Library(10);
        //System.out.println(myLibrary.getSize());
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);
        //System.out.println(myLibrary.getSize());
        System.out.println("My initial library ");
        myLibrary.display();
        System.out.println("---------------------");
        myLibrary.addBook(new Book("Little Prince", "Saint-Exupery", 1938, 300));
        //System.out.println(myLibrary.getSize());
        myLibrary.removeBook(book4);
        System.out.println("Added a new book, removed one book ");
        myLibrary.display();
        System.out.println("---------------------");
        System.out.println("Search by author");
        myLibrary.searchBookByAuthor("Leo Tolstoy");
        myLibrary.searchBookByAuthor("Alexander Pushkin");
        System.out.println("---------------------");
        System.out.println("Search by title");
        myLibrary.searchBookByTitle("Little prince");
        myLibrary.searchBookByTitle("Alice in Wonderland");
        System.out.println("---------------------");
        System.out.println("The oldest book");
        System.out.println(myLibrary.findOldestBook());

        System.out.println("---------------------");

        MyLibrary myLibrary1 = new MyLibrary();
        Collections.addAll(myLibrary1.getMyLibrary(), myLibrary.getBooks());
        // System.out.println(myLibrary1.getMyLibrary());
        for (Book b : myLibrary1.getMyLibrary()) {
            if (b != null)
                System.out.println(b);
        }


    }
}
