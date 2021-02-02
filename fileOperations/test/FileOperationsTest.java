import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {
    FileOperations fo = new FileOperations();

    @Test
    public void test_writeReadStrings() throws IOException {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "banana", "apple", "orange");
        fo.writeStrings(strings, "outputStrings.txt");
        List<String> readStrings = fo.readStrings("outputStrings.txt");
        assertEquals(strings, readStrings);
    }

    @Test
    public void test_writeReadInts() throws IOException {
        List<Integer> ints = Arrays.asList(333, -5, 0);
        fo.writeInts(ints, "outputNumbers.txt");
        List<Integer> readInts = fo.readInts("outputNumbers.txt");
        assertEquals(ints, readInts);
    }

}