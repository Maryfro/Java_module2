import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {
    FileOperations fo = new FileOperations();

    @Test
    public void test_writeStrings() throws IOException {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "banana", "apple", "orange");
        fo.writeStrings(strings, "outputStrings.txt");
       // assertEquals(17, "outputString.txt".length());

    }

    @Test
    public void test_readInts() throws IOException {

        // assertEquals(, fo.readInts("inputNumbers.txt").size());

    }

}