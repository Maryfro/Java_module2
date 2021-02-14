package operation;

public class UpperCaseSO implements IStringOperation{
private String name;

    public UpperCaseSO() {
        this.name = "upper_case";
    }

    @Override
    public String operate(String input) {
        String res;
        res = input.toUpperCase();
        return res;
    }

    @Override
    public String getName() {
        return name;
    }
}
