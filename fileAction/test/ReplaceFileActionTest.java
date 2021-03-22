import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceFileActionTest {
    ReplaceFileAction replace = new ReplaceFileAction(new FileOperations(), " ", "*");

    @Test
    public void test_perform() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("212*8506", "xx*x", "40*4", "1*12"));
        assertEquals(exp, replace.perform(Arrays.asList("212 8506", "xx x", "40 4", "1 12")));
    }

    @Test
    public void test_handle() throws IOException {
        replace.handleFile("source2.txt");
        List<String> readStrings = new FileOperations().readStrings("source2.txt");
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("Up*above*the*world*so*high,*like*a*diamond*in*the*sky."));
        assertEquals(exp, readStrings);
    }


}