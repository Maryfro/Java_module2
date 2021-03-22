import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    final static String FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException {
        String hello = "hello, world!sdfsdf";
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME, true);
        outputStream.write(hello.getBytes());
        outputStream.close();
    }
}
