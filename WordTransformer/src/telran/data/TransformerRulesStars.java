package telran.data;

public class TransformerRulesStars extends TransformerRuleLength3 {
    @Override
    public boolean checkLength(String input) {
        return input.length() == 6;
    }

    @Override
    public String action(String input) {
        return input.replaceAll(input, "******");
    }
}
