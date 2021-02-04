import java.io.IOException;
import java.util.List;

public abstract class FileAction {

    final FileOperations fileOperations;

    protected FileAction(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    protected abstract List<String> perform(List<String> text);

    /**
     * the method receives a filename and must read the file into a List<String>
     * and calls the perform method, then writes the result back to the file.
     *
     * @param filename name of the file to handle
     */
    public void handleFile(String filename) throws IOException {
        List<String> text = fileOperations.readStrings(filename);
        List<String> copy = perform(text);
        fileOperations.writeStrings(copy, filename);
    }
}

//pattern template
//we have a text file
//method handle reads file
// then use method perform which changes text
// then handle file writes the changed text back to file