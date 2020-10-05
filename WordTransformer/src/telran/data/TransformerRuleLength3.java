package telran.data;

public class TransformerRuleLength3 implements Transformable {
    public boolean checkLength(String input) {
        return input.length() == 3;
    }

    public String action(String input) {
        return input.toUpperCase();
    }
}
