public class Movie {
    private String name;
    private String genre;
    private double duration;
    private int releaseYear;

    public Movie(String name, String genre, double duration, int releaseYear) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return this.duration;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public String toString() {
        return "Movie: " + this.name + '\'' + ", genre:" + this.genre + '\'' + ", duration: " + this.duration + ", releaseYear: " + this.releaseYear;
    }

    public static void turnOffMobileDevices() {
        System.out.println("Ladies and gentelmen, please turn off your mobile devices");
    }

    public static void lightsOff() {
        System.out.println("Now it's dark, the movie can go on");
    }
}
