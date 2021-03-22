import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    final static String FILE_NAME = "input.txt";

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_NAME);
        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes);
        String res = new String(bytes);
        System.out.println(res);
    }
}
