import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public List<String> readStrings(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }

    public void writeStrings(List<String> strings, String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (String string : strings) {
                pw.println(string);
            }
        }

    }
}
