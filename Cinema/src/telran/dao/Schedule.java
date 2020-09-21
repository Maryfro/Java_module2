package telran.dao;

import telran.data.Cinema;
import telran.data.Genre;
import telran.data.Movie;

import java.time.LocalDate;

public class Schedule {
    private Movie[] movies;
    private int arraySize;

    public Schedule(int capacity) {
        movies = new Movie[capacity];
        arraySize = 0;
    }

    public boolean addMovie(Movie movie) {
        if (arraySize < movies.length) {
            movies[arraySize] = movie;
            arraySize++;
            return true;
        }
        return false;
    }

    public boolean removeMovie(Movie movie) {
        for (int i = 0; i < arraySize; i++) {
            if (movies[i].equals(movie)) {
                movies[i] = movies[arraySize - 1];
                arraySize--;
                return true;
            }
        }
        return false;
    }

    public void displayMovies() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(movies[i]);
        }
    }

    public void displayMoviesByCinema(String cinema) {
        System.out.println("In cinema " + cinema + " you can watch: ");
        boolean found = false;
        for (int i = 0; i < arraySize; i++) {
            if (Cinema.isCinemaInArray(cinema, movies[i].getCinemas())) {
                System.out.println(movies[i].getTitle() + ", " + movies[i].getGenre() + ", " + movies[i].getDate());
                found = true;
            }
        }
        System.out.println(found ? "" : "There is no info about this cinema");

    }

    public void displayMoviesByDate(LocalDate date) {
        boolean found = false;
        for (int i = 0; i < arraySize; i++) {
            if (movies[i].getDate().equals(date)) {
                found = true;
                System.out.println(movies[i].getTitle() + ", " + movies[i].getGenre());
                movies[i].displayCinemas();
            }
        }
        System.out.println(found ? "" : "There is no movie on this date");
    }

    public void displayMoviesByGenre(Genre genre) {
        for (int i = 0; i < arraySize; i++) {
            if (movies[i].getGenre().equals(genre)) {
                System.out.println(movies[i].getTitle() + ", " + movies[i].getDate());
                movies[i].displayCinemas();
            }
        }
    }
}

