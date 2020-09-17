package telran.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;


public class Movie {
    private String title;
    private LocalDate date; // yyyy. mm. dd LocalDate.of(2020, 09, 17);
    private Genre genre;
    private Cinema[] cinemas;

    public Movie(String title, LocalDate date, Genre genre, Cinema[] cinemas) {
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.cinemas = cinemas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Cinema[] getCinemas() {
        return cinemas;
    }

    public void setCinemas(Cinema[] cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title) &&
                date.equals(movie.date) &&
                genre == movie.genre &&
                Arrays.equals(cinemas, movie.cinemas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, date, genre);
        result = 31 * result + Arrays.hashCode(cinemas);
        return result;
    }

    @Override
    public String toString() {
        return "Movie " +
                 title +
                ", date " + date +
                ", genre " + genre +
                ", cinemas " + Arrays.toString(cinemas) +
                '}';
    }
    
    public void displayCinemas(){
        for (Cinema c: cinemas) {
            System.out.println(c);
        }
    }
}
