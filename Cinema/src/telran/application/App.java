package telran.application;

import telran.dao.Schedule;
import telran.data.Address;
import telran.data.Cinema;
import telran.data.Genre;
import telran.data.Movie;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Cinema cinema1 = new Cinema("Kino International");
        Address address2 = new Address("Mehringdamm", 33);
        Cinema cinema2 = new Cinema("Kosmos", address2);
        Cinema cinema3 = new Cinema("Star", new Address("Potsdamer Platz", 9));
        Cinema cinema4 = new Cinema("Babylon", new Address("Turmstr", 98));
        cinema1.setAddress(new Address("Kudamm", 56));

        Cinema[] cinemas = {cinema1, cinema2, cinema3, cinema4};
        Cinema[] cinemas1 = {cinema1, cinema2};


        Movie movie1 = new Movie("Avengers", LocalDate.of(2020, 05, 05),
                Genre.DRAMA, cinemas);
        Movie movie2 = new Movie("Vertigo", LocalDate.of(2020, 05, 10),
                Genre.THRILLER, cinemas);
        Movie movie3 = new Movie("Frozen 2", LocalDate.of(2020, 06, 01),
                Genre.ADVENTURE, cinemas1);
        Movie movie4 = new Movie("The Gentelmen", LocalDate.of(2020, 01, 01),
                Genre.CRIME, cinemas1);
        Movie movie5 = new Movie("American Pie", LocalDate.of(2020, 05, 05),
                Genre.COMEDY, cinemas);
        Movie movie6 = new Movie("Shape of water", LocalDate.of(2020, 01, 01),
                Genre.DRAMA, cinemas);
        Movie movie7 = new Movie("Jojo Rabbit", LocalDate.of(2020,05,05),
                Genre.COMEDY, cinemas);
        Movie[] movies = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};



        Schedule schedule = new Schedule(50);
        schedule.addMovie(movie1);
        schedule.addMovie(movie2);
        schedule.addMovie(movie3);
        schedule.addMovie(movie4);
        schedule.addMovie(movie5);
        schedule.addMovie(movie6);
        schedule.addMovie(movie7);
        // schedule.displayMovies();
      // schedule.displayMoviesByCinema("Star");
        schedule.displayMoviesByGenre("Babylon", Genre.COMEDY);
        schedule.displayMoviesByDate("Kosmos", LocalDate.of(2020, 02, 01));
        System.out.println("-------------------------");
        schedule.displayMoviesByDate("Kosmos", LocalDate.of(2020, 01, 01));
        System.out.println("-------------------------");
        System.out.println("display movie by date");
        schedule.displayMoviesByDate1(movies, LocalDate.of(2020, 02, 05));
        System.out.println("-------------------------");
        System.out.println("display movie by date");
        schedule.displayMoviesByDate1(movies, LocalDate.of(2020, 05, 05));
        System.out.println("-------------------------");
        System.out.println("display movie by genre");
        schedule.displayMoviesByGenre1(movies, Genre.DRAMA);

    }
}
