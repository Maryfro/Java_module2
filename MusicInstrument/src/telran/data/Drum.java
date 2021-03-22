package telran.data;

public class Drum implements Playable {
    private int size;

    public Drum(int size) {
        this.size = size;
    }

    @Override
    public void play() {
        System.out.println("Plays " + this.getClass().getSimpleName() + " with these characteristics: size "
                + this.size);
    }
}
