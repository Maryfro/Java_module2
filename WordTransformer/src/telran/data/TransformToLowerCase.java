package telran.data;

public class TransformToLowerCase implements WordsChecker {
    @Override
    public boolean checkLength(String input) {
        return input.length()==4;
    }

    @Override
    public String action(String input) {
        return input.toLowerCase();
    }
}
