package de.telran.dao;

import de.telran.data.Book;

import java.util.ArrayList;
import java.util.List;

public class MyLibrary {
    private List<Book> myLibrary;

    public MyLibrary() {
        myLibrary = new ArrayList<>();
    }

    public List<Book> getMyLibrary() {
        return myLibrary;
    }
}
