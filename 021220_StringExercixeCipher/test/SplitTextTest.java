import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SplitTextTest {
    SplitText st = new SplitText();
    Set<String> dictionary = new HashSet<>();

    @Test
    public void test_splitTextWithDictionary_regularCase() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("hello", "super"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "hellosuper"));
    }

    @Test
    public void test_splitTextWithDictionary_repeatedWords() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("super", "super"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "supersuper"));
    }

    @Test
    public void test_splitTextWithDictionary_repeatedWordsCorrectOrder() {
        Collections.addAll(dictionary, "hello", "world", "super");
        List<String> exp = new ArrayList<>(Arrays.asList("super", "hello", "super"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "superhellosuper"));
    }

    @Test
    public void test_splitTextWithDictionary_oneWordFromDictionary_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");
        assertNull(st.splitTextWithDictionary(dictionary, "hellopapa"));
    }

    @Test
    public void test_splitTextWithDictionary_misspelling_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");
        assertNull(st.splitTextWithDictionary(dictionary, "superhelloo"));
    }

    @Test
    public void test_splitTextWithDictionary_emptyString_expNull() {
        Collections.addAll(dictionary, "hello", "world", "super");
        assertNull(st.splitTextWithDictionary(dictionary, ""));
    }

    @Test
    public void test_splitTextWithDictionary_closeWordsInDictionary() {
        Collections.addAll(dictionary, "hello", "hell", "operation");
        List<String> exp = new ArrayList<>(Arrays.asList("hello", "operation"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "hellooperation"));
    }

    @Test
    public void test_splitTextWithDictionary_closeWordsInDictionary1() {
        Collections.addAll(dictionary, "hello", "operation", "hell");
        List<String> exp = new ArrayList<>(Arrays.asList("hell", "operation"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "helloperation"));
    }

    @Test
    public void test_splitTextWithDictionary_closeWordsInDictionary2() {
        Collections.addAll(dictionary, "megaworld", "world", "word");
        List<String> exp = new ArrayList<>(Arrays.asList("world", "megaworld", "word"));
        assertEquals(exp, st.splitTextWithDictionary(dictionary, "worldmegaworldword"));
    }


}