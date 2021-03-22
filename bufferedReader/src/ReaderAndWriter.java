import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter {


    private void writeToFile(String line) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("result.txt", true))) {
            pw.println(line);
        }
    }


    public void readFromConsole() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                writeToFile(line);
            }
        }
    }

    public List<String> readFromConsole2() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            List<String> res = new ArrayList<>();
            while ((line = br.readLine()) != null && !line.equals("exit")) {
                res.add(line);
            }
            return res;
        }
    }

    public void writeToFile2(List<String> strings) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("result1.txt", true)) {
            PrintWriter pw = new PrintWriter(fos);
            for (String string : strings) {
                pw.println(string);
            }
        }
    }
}
