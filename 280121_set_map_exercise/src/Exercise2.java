import java.util.*;

public class Exercise2 {

    static class Auto {
        String make;
        String color;

        public Auto(String make, String color) {
            this.make = make;
            this.color = color;
        }


        @Override
        public String toString() {
            return "Auto{" +
                    "make='" + make + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    public HashMap<String, List<Auto>> groupAutosByMake(List<Auto> autos) {
        HashMap<String, List<Auto>> group = new HashMap<>();
        HashSet<String> keys = new HashSet<>();
        for (Auto auto : autos) {
            keys.add(auto.make);
        }

        for (String key : keys) {
            List<Auto> values = new ArrayList<>();
            for (Auto auto : autos) {
                if (key.equals(auto.make)) {
                    values.add(auto);
                }
                group.put(key, values);
            }
        }
        return group;
    }
}
