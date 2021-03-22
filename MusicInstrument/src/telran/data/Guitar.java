package telran.data;

public class Guitar implements Playable {
    private int numberOfString;

    public Guitar(int numberOfString) {
        this.numberOfString = numberOfString;
    }

    @Override
    public void play() {
        System.out.println("Plays " + this.getClass().getSimpleName() + " with these characteristics: "
                + this.numberOfString + " strings");
    }
}
