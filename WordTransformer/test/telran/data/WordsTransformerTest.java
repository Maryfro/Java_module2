package telran.data;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsTransformerTest {
    String input = "asd ASDF GHGFdf sdf fdg";
    WordsChecker wc1 = new TransformToUpperCase();
    WordsChecker wc2 = new TransformToLowerCase();
    WordsChecker wc3 = new ReplaceWithStars();

    @Test
    public void testWordTransformNewEqualValuesWc1() {
        String output1 = WordsTransformer.WordTransformNew(input, wc1);
        Assert.assertEquals("ASD ASDF GHGFdf SDF FDG", output1);
    }

    @Test
    public void testWordTransformNewEqualValuesWc2() {
        Assert.assertEquals("asd asdf GHGFdf sdf fdg", WordsTransformer.WordTransformNew(input, wc2));
    }

    @Test
    public void testWordTransformNewEqualValuesWc3() {
        Assert.assertEquals("asd ASDF ****** sdf fdg", WordsTransformer.WordTransformNew(input, wc3));
    }

    @Test
    public void testWordTransformNewNotNullWc1() {
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc1));

    }

    @Test
    public void testWordTransformNewNotNullWc2() {
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc2));
    }

    @Test
    public void testWordTransformNewNotNullWc3() {
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc3));
    }

    @Test
    public void testWordTransformNewNotSameWc1() {
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc1));
    }

    @Test
    public void testWordTransformNewNotSameWc2() {
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc2));
    }

    @Test
    public void testWordTransformNewNotSameWc3() {
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc2));
    }

    @Test
    public void testWordTransformNewLengthOfStringWc1() {
        assertEquals(input.length(), WordsTransformer.WordTransformNew(input, wc1).length());
    }

    @Test
    public void testWordTransformNewLengthOfStringWc2() {
        assertEquals(input.length(), WordsTransformer.WordTransformNew(input, wc2).length());
    }

    @Test
    public void testWordTransformNewLengthOfStringWc3() {
        assertEquals(input.length(), WordsTransformer.WordTransformNew(input, wc3).length());
    }

}