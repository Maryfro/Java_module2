package de.telran.data;

import java.util.Objects;

public class Book {
    private String title, author;
    private int yearOfIssue, amountOfPages;

    public Book(String title, String author, int yearOfIssue, int amountOfPages) {
        this.title = title;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.amountOfPages = amountOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfIssue == book.yearOfIssue &&
                amountOfPages == book.amountOfPages &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfIssue, amountOfPages);
    }

    @Override
    public String toString() {
        return "Title " +
                title +
                ", Author " + author  +
                ", year of issue " + yearOfIssue +
                ", amount of pages " + amountOfPages;
    }
}
