package operation;

public class UpperCaseSO implements IStringOperation{

    @Override
    public String operate(String input) {
        String res;
        res = input.toUpperCase();
        return res;
    }

    @Override
    public String getName() {
        return "upper_case";
    }
}
