import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPatternExerciseTest {
    StringPatternExercise task = new StringPatternExercise();

    @Test
    public void test_maxLengthSubstring_EmptyRes(){
        assertEquals("", task.maxLengthSubstring("Hello world ", 3));
    }

    @Test
    public void test_maxLengthSubstring_OneWord(){
        assertEquals("Hello", task.maxLengthSubstring("Hello world ", 5));
    }

    @Test
    public void test_maxLengthSubstring_OneWord_SubstringSecond(){
        assertEquals("Hello", task.maxLengthSubstring("Hello world ", 8));
    }

    @Test
    public void test_maxLengthSubstring_TwoWords(){
        assertEquals("Hello world", task.maxLengthSubstring("Hello world ", 11));
    }

    @Test
    public void test_maxLengthSubstring_TwoWordsAndSpace(){
        assertEquals("Hello world", task.maxLengthSubstring("Hello world ", 13));
    }

    @Test
    public void test_maxLengthSubstring_TwoWordsCheckingIndices(){
        assertEquals("Hello world", task.maxLengthSubstring("Hello world ", 12));
    }


}