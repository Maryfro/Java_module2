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
    public void testWordTransformNewEqualValues() {
        String output1 = WordsTransformer.WordTransformNew(input, wc1);
        Assert.assertEquals("ASD ASDF GHGFdf SDF FDG", output1);
        Assert.assertEquals("asd asdf GHGFdf sdf fdg", WordsTransformer.WordTransformNew(input, wc2));
        Assert.assertEquals("asd ASDF ****** sdf fdg", WordsTransformer.WordTransformNew(input, wc3));
    }

    @Test
    public void testWordTransformNewNotNull() {
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc1));
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc2));
        Assert.assertNotNull(WordsTransformer.WordTransformNew(input, wc3));
    }

    @Test
    public void testWordTransformNewNotSame() {
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc1));
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc2));
        assertNotSame(input, WordsTransformer.WordTransformNew(input, wc3));
    }
}