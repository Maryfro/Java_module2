import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Task2StringListTest {
    Task2StringList t2 = new Task2StringList(Arrays.asList("mom", "cat", "dad", "granny"));

    @Test

    public void test_mapPalindroms() {
        Map<Boolean, List<String>> exp = new HashMap<>();
        exp.put(true, Arrays.asList("mom", "dad"));
        exp.put(false, Arrays.asList("cat", "granny"));
        assertEquals(exp, t2.mapPalindroms());
    }

}