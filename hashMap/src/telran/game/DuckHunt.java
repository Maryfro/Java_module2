package telran.game;

public class DuckHunt implements Command {
    private final int number = 1;

    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        System.out.println("Hunt started ");
    }

    @Override
    public String toString() {
        return "DuckHunt";
    }
}

