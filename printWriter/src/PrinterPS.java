import java.io.*;

public class PrinterPS implements Printer {
    @Override
    public void print(String[] strings) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("testTime2.txt")) {
            PrintStream ps = new PrintStream(fos);
            for (String string : strings) {
                ps.println(string);
            }
        }
    }
}
