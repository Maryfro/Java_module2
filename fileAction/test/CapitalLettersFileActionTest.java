import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CapitalLettersFileActionTest {
    CapitalLettersFileAction capLet = new CapitalLettersFileAction(new FileOperations());

    @Test
    public void test_perform_lowerCase() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "APRICOT", "CHERRY"));
        assertEquals(exp, capLet.perform(Arrays.asList("apple", "banana", "apricot", "cherry")));
    }

    @Test
    public void test_perform_mixedCase() {
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "APRICOT", "CHERRY"));
        assertEquals(exp, capLet.perform(Arrays.asList("aPPle", "Banana", "Apricot", "cheRRY")));
    }

    @Test
    public void test_handle() throws IOException {
        capLet.handleFile("source.txt");
        List<String> readStrings = new FileOperations().readStrings("source.txt");
        List<String> exp = Arrays.asList("TWINKLE, TWINKLE, LITTLE STAR, HOW I WONDER WHAT YOU ARE.");
        assertEquals(exp, readStrings);
    }


}