import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CapitalLettersFileActionTest {
    // @Mock
    FileOperations fo;
    // @InjectMocks
    CapitalLettersFileAction capLet;

    @BeforeEach
    public void init() {
        fo = mock(FileOperations.class);
        capLet = new CapitalLettersFileAction(fo);
    }


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


}