import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CoronaComparator<Human> cc = new CoronaComparator();
        Human oleg = new Human(true, 71);
        Human max = new Human(false, 70);
        Human carla = new Human(true, 25);
        int comparison = cc.compare(oleg, max);
        if (comparison < 0) {
            System.out.println("max will be vaccinated first");
        } else if (comparison > 0) {
            System.out.println("oleg will be vaccinated first");
        } else {
            System.out.println("equal priority");
        }
        //how to use comparators in java
        List<Human> humans = Arrays.asList(oleg, max, carla);
        // Collections.sort(humans, cc);
        humans.sort(cc);
        System.out.println(humans);

        Collections.sort(humans, cc.reversed());
        // humans.sort(cc.reversed());
        System.out.println(humans);

    }
}
