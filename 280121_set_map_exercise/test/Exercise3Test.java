import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Exercise3Test {

    Exercise3 ex = new Exercise3();
    ArrayList<String> input = new ArrayList<>();


    @Test
    public void test_createDictionary() {
        Collections.addAll(input, "бекон", "арбуз", "бобер", "бидон", "алмаз", "банан", "боб");
        List<List<String>> output = ex.createDictionary(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан", "бекон", "бидон", "боб", "бобер"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary2() {
        Collections.addAll(input, "бекон", "арбуз", "бобер", "бидон", "алмаз", "банан", "класс", "ёж");
        List<List<String>> output = ex.createDictionary2(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан", "бекон", "бидон", "бобер"));
        exp.add(Arrays.asList("класс"));
        exp.add(Arrays.asList("ёж"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary_anotherWords() {
        Collections.addAll(input, "вагон", "арбуз", "винил", "галоп", "алмаз", "банан", "глина");
        List<List<String>> output = ex.createDictionary(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан"));
        exp.add(Arrays.asList("вагон", "винил"));
        exp.add(Arrays.asList("галоп", "глина"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary2_anotherWords() {
        Collections.addAll(input, "вагон", "арбуз", "винил", "галоп", "алмаз", "банан", "глина");
        List<List<String>> output = ex.createDictionary2(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("алмаз", "арбуз"));
        exp.add(Arrays.asList("банан"));
        exp.add(Arrays.asList("вагон", "винил"));
        exp.add(Arrays.asList("галоп", "глина"));
        assertEquals(exp, output);
    }


    @Test
    public void test_createDictionary_latinWords() {
        Collections.addAll(input, "cat", "dog", "frog", "cookie", "dragon", "fibonacci");
        List<List<String>> output = ex.createDictionary(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("cat", "cookie"));
        exp.add(Arrays.asList("dog", "dragon"));
        exp.add(Arrays.asList("fibonacci", "frog"));
        assertEquals(exp, output);
    }

    @Test
    public void test_createDictionary2_latinWords() {
        Collections.addAll(input, "cat", "dog", "frog", "cookie", "dragon", "fibonacci");
        List<List<String>> output = ex.createDictionary2(input);
        List<List<String>> exp = new ArrayList();
        exp.add(Arrays.asList("cat", "cookie"));
        exp.add(Arrays.asList("dog", "dragon"));
        exp.add(Arrays.asList("fibonacci", "frog"));
        assertEquals(exp, output);
    }

}