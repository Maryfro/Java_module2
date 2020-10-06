package telran.data;

public class TransformToUpperCase implements WordsChecker {
    public boolean checkLength(String input) {
        return input.length() == 3;
    }

    public String action(String input) {
        return input.toUpperCase();
    }
}
