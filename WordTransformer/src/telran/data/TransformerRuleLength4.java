package telran.data;

public class TransformerRuleLength4 extends TransformerRuleLength3{
    @Override
    public boolean checkLength(String input) {
        return input.length()==4;
    }

    @Override
    public String action(String input) {
        return input.toLowerCase();
    }
}
