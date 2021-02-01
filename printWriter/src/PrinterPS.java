import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrinterPS implements Printer{
    @Override
    public void print(String[] strings) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("testTime2.txt");
        PrintStream ps = new PrintStream(fos);
        for (String string : strings) {
            ps.println(string);
        }
    }
}
