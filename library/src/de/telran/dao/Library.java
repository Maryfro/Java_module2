package de.telran.dao;

import de.telran.data.Book;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean addBook(Book book) {
        if (size < books.length) {
            books[size] = book;
            size++;
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].equals(book)) {
                books[i] = books[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchBookByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                found = true;
                System.out.println(books[i]);
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }

    }

    public void searchBookByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                found = true;
                System.out.println(books[i]);
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }

    }

    public Book findOldestBook() {
        Book oldestBook = books[0];
        for (int i = 0; i < size; i++) {
            if (oldestBook.getYearOfIssue() > books[i].getYearOfIssue()) {
                oldestBook = books[i];
            }
        }
        return oldestBook;
    }
}
