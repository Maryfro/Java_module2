package telran.data;

public class ReplaceWithStars implements WordsChecker {
    @Override
    public boolean checkLength(String input) {
        return input.length() == 6;
    }

    @Override
    public String action(String input) {
        return input.replaceAll(".", "*");
    }
}
