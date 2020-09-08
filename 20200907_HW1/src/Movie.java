
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
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Movie: " +
                name  +
                ", genre: " + genre +
                ", duration: " + duration +
                ", releaseYear: " + releaseYear;
    }

    public static void turnOffMobileDevices() {
        System.out.println("Ladies and gentelmen, please turn off your mobile devices");
    }

    public static void lightsOff() {
        System.out.println("Now it's dark, the movie can go on");
    }

    public void movieStart(){
        System.out.println("the movie starts at 15:00");
    }
}
