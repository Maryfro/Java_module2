public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("The Godfather", "drama", 2.9, 1972);
        Movie movie2 = new Movie("Titanic", "drama", 3.1, 1991);
        Movie movie3 = new Movie("Ice Age", "animation", 1.3, 2002);
        System.out.println(movie1.toString());
        System.out.println(movie2.toString());
        System.out.println(movie3.toString());
        movie3.movieStart();
        Movie.turnOffMobileDevices();
        Movie.lightsOff();

    }
}
