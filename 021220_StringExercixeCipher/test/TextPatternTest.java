import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextPatternTest {
    TextPattern tp = new TextPattern();

    @Test
    void test_textPattern_emptyPattern() {
        assertTrue(tp.findPattern("hello", ""));
    }

    @Test
    void test_textPattern_emptyTextAndPattern() {
        assertTrue(tp.findPattern("", ""));
    }

    @Test
    void test_textPattern_emptyText() {
        assertFalse(tp.findPattern("", "hll"));
    }

    @Test
    void test_textPattern_textIsShorterThanPattern() {
        assertFalse(tp.findPattern("hell", "hello"));
    }

    @Test
    void test_textPattern_textIsEqualWithPattern() {
        assertTrue(tp.findPattern("hello", "hello"));
    }

    @Test
    void test_textPattern_trueCase_borderLetters() {
        assertTrue(tp.findPattern("hello", "ho"));
    }

    @Test
    void test_textPattern_trueCase_oneLetter() {
        assertTrue(tp.findPattern("hello", "l"));
    }

    @Test
    void test_textPattern_trueCase_severalLetters() {
        assertTrue(tp.findPattern("hello", "ell"));
    }

    @Test
    void test_textPattern_falseCase_oneLetter() {
        assertFalse(tp.findPattern("hello", "g"));
    }

    @Test
    void test_textPattern_falseCase_severalLetters() {
        assertFalse(tp.findPattern("hello", "llh"));
    }

    @Test
    void test_textPatternS2_emptyPattern() {
        assertTrue(tp.findPatternSolution2("hello", ""));
    }

    @Test
    void test_textPatternS2_emptyTextAndPattern() {
        assertTrue(tp.findPatternSolution2("", ""));
    }

    @Test
    void test_textPatternS2_emptyText() {
        assertFalse(tp.findPatternSolution2("", "hll"));
    }

    @Test
    void test_textPatternS2_textIsShorterThanPattern() {
        assertFalse(tp.findPatternSolution2("hell", "hello"));
    }

    @Test
    void test_textPatternS2_textIsEqualWithPattern() {
        assertTrue(tp.findPatternSolution2("hello", "hello"));
    }

    @Test
    void test_textPatternS2_trueCase_borderLetters() {
        assertTrue(tp.findPatternSolution2("hello", "ho"));
    }

    @Test
    void test_textPatternS2_trueCase_oneLetter() {
        assertTrue(tp.findPatternSolution2("hello", "l"));
    }

    @Test
    void test_textPatternS2_trueCase_severalLetters() {
        assertTrue(tp.findPatternSolution2("hello", "ell"));
    }

    @Test
    void test_textPatternS2_falseCase_oneLetter() {
        assertFalse(tp.findPatternSolution2("hello", "g"));
    }

    @Test
    void test_textPatternS2_falseCase_severalLetters() {
        assertFalse(tp.findPatternSolution2("hello", "llh"));
    }

}