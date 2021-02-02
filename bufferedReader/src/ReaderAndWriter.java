import java.io.*;

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
}
