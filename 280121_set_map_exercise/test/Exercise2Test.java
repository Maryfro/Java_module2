import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2Test {
    Exercise2 group = new Exercise2();
    Exercise2.Auto opel1 = new Exercise2.Auto("Opel", "grey");
    Exercise2.Auto opel2 = new Exercise2.Auto("Opel", "green");
    Exercise2.Auto opel3 = new Exercise2.Auto("Opel", "red");
    Exercise2.Auto opel4 = new Exercise2.Auto("Opel", "black");
    Exercise2.Auto mazda1 = new Exercise2.Auto("Mazda", "black");
    Exercise2.Auto mazda2 = new Exercise2.Auto("Mazda", "white");
    Exercise2.Auto mazda3 = new Exercise2.Auto("Mazda", "blue");
    ArrayList<Exercise2.Auto> list = new ArrayList<>();


    @Test
    public void test_groupAutosByMake_CorrectKeys() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        HashMap<String, List<Exercise2.Auto>> res = group.groupAutosByMake(list);
        HashSet<String> resKeys = new HashSet<>();
        resKeys.add("Opel");
        resKeys.add("Mazda");
        assertEquals(resKeys, res.keySet());
    }

    @Test
    public void test_groupAutosByMake_CorrectValues_opel() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        HashMap<String, List<Exercise2.Auto>> res = group.groupAutosByMake(list);
        List<Exercise2.Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, opel1, opel2, opel3, opel4);
        assertEquals(expValues, res.get("Opel"));
    }

    @Test
    public void test_groupAutosByMake_CorrectValues_mazda() {
        Collections.addAll(list, opel1, opel2, opel3, opel4, mazda1, mazda2, mazda3);
        HashMap<String, List<Exercise2.Auto>> res = group.groupAutosByMake(list);
        List<Exercise2.Auto> expValues = new ArrayList<>();
        Collections.addAll(expValues, mazda1, mazda2, mazda3);
        assertEquals(expValues, res.get("Mazda"));
    }


}