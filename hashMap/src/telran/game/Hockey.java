package telran.game;

public class Hockey implements Command{
    public final int number = 3;

    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {

    }

    @Override
    public String toString() {
        return "Hockey";
    }
}
