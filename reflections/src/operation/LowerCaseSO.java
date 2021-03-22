package operation;

public class LowerCaseSO implements IStringOperation {
    @Override
    public String operate(String input) {
        String res;
        res = input.toLowerCase();
        return res;
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
