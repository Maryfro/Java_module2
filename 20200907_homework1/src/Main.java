public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("The Godfather", "drama", 2.9D, 1972);
        Movie movie2 = new Movie("Titanic", "drama", 3.1D, 1991);
        Movie movie3 = new Movie("Ice Age", "animation", 1.3D, 2002);
        System.out.println(movie1.toString());
        System.out.println(movie2.toString());
        System.out.println(movie3.toString());
        Movie.turnOffMobileDevices();
        Movie.lightsOff();
    }
}
