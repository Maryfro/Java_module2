import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrinterPW implements Printer {
    @Override
    public void print(String[] strings) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("testTime.txt");
        PrintWriter pw = new PrintWriter(fos);
        for (String string : strings) {
            pw.println(string);
        }
        pw.close();

    }
}
