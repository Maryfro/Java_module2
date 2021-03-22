package operation;

public class UpperCaseSO implements IStringOperation {


    public UpperCaseSO() {
    }

    public UpperCaseSO(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    String name;
    Integer num;


    @Override
    public String toString() {
        return "UpperCaseSO{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

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
