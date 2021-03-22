package telran.data;

public class Trumpet implements Playable {
    private int diameter;

    public Trumpet(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public void play() {
        System.out.println("Plays " + this.getClass().getSimpleName() + " with these characteristics: diameter "
                + this.diameter);
    }
}
