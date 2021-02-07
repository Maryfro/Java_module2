import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class FileActionTest {


    FileOperations fo;
    FileAction capLet;

    @BeforeEach
    public void init() {
        fo = mock(FileOperations.class);
        capLet = new FileAction(fo) {
            @Override
            protected List<String> perform(List<String> text) {
                return null;
            }
        };
        capLet = spy(capLet);
    }

    @Test
    public void test_handle() throws IOException {
        when(fo.readStrings("filename.txt")).thenReturn(Arrays.asList("hello world", "guys!"));
        when(capLet.perform(Arrays.asList("hello world", "guys!"))).thenReturn(Arrays.asList("world ", "!guys"));
        capLet.handleFile("filename.txt");
        verify(fo, times(1))
                .writeStrings(Arrays.asList("world ", "!guys"), "filename.txt");
    }
}