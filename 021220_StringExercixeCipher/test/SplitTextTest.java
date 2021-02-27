import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    SplitText st;
    Set<String> dictionary = new HashSet<>();

    @Test
    public void test_splitText_regularCase() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("hello", "super"));

        st = new SplitText(dictionary);
        assertEquals(exp, st.splitTextSolution("hellosuper"));
    }

    @Test
    public void test_splitText_repeatedWords() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("super", "super"));

        st = new SplitText(dictionary);
        assertEquals(exp, st.splitTextSolution("supersuper"));
    }

    @Test
    public void test_splitText_repeatedWordsCorrectOrder() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("super", "hello", "super"));

        st = new SplitText(dictionary);
        List<String> res = st.splitTextSolution("superhellosuper");

        assertEquals(exp, res);
    }

    @Test
    public void test_splitText_oneWordFromDictionary_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");

        st = new SplitText(dictionary);
        assertNull(st.splitTextSolution("hellopapa"));
    }

    @Test
    public void test_splitText_misspelling_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");

        st = new SplitText(dictionary);
        assertNull(st.splitTextSolution("superhelloo"));
    }

    @Test
    public void test_splitText_emptyString_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");

        st = new SplitText(dictionary);
        assertNull(st.splitTextSolution(""));
    }

    @Test
    public void test_splitText_closeWordsInDictionary() {
        Collections.addAll(dictionary, "hello", "hell", "operation");
        List<String> exp = new ArrayList<>(Arrays.asList("hello", "operation"));

        st = new SplitText(dictionary);
        assertEquals(exp, st.splitTextSolution("hellooperation"));
    }

    @Test
    public void test_splitText_closeWordsInDictionary1() {
        Collections.addAll(dictionary, "hello", "operation", "hell");
        List<String> exp = new ArrayList<>(Arrays.asList("hell", "operation"));

        st = new SplitText(dictionary);
        assertEquals(exp, st.splitTextSolution("helloperation"));
    }

    @Test
    public void test_splitText_closeWordsInDictionary2() {
        Collections.addAll(dictionary, "megaworld", "world", "word");
        List<String> exp = new ArrayList<>(Arrays.asList("world", "megaworld", "word"));

        st = new SplitText(dictionary);
        assertEquals(exp, st.splitTextSolution("worldmegaworldword"));
    }
}
