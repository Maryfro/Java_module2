package telran.game;

public class Soccer implements Command {
    public final int number = 2;

    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        System.out.println("soccer started");
    }

    @Override
    public String toString() {
        return "Soccer";
    }
}
