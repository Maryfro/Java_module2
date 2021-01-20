import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Auto, String> map = new HashMap<>();
        fillMap(map);
        Auto anotherGreyOpel = new Auto("grey", "Opel");
        String value = map.get(anotherGreyOpel);
        System.out.println(value); // null->
        // if equals and hashCode are not overriden
        Map<String, String> map1 = new HashMap<>();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    }

    static void fillMap(Map<Auto, String> map) {
        Auto greyOpel = new Auto("grey", "Opel");
        map.put(greyOpel, "value");

    }
}

class Auto {
    private final String brand; // fields should be immutable
    private final String color;

    public Auto(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return brand.equals(auto.brand) &&
                color.equals(auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }


}
