import com.sun.tools.javac.util.StringUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FileOperations {
    /**
     * writes the list of strings into the file, clearing it if the file exists and
     * starts every string from a new line.
     *
     * @param strings
     * @param filename
     */
    public void writeStrings(List<String> strings, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename, false)) {
            for (String str : strings) {
                outputStream.write(str.getBytes());
                //outputStream.write('\n');
                outputStream.write(10);
            }
        }
    }

    /**
     * reads all lines of the file into a list
     *
     * @param filename
     * @return
     */
    public List<String> readStrings(String filename) throws IOException {
        List<String> strings = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            strings.add(new String(bytes));
        }
        return strings;
    }

    public void writeBytes(byte[] bytes, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(bytes);
        }
    }

    public byte[] readBytes(String filename) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        }
    }

    /**
     * Writes the list of numbers into the file with space as delimiter. [12, 35, 234]->"12 35 234"
     *
     * @param numbers  to read into the file
     * @param filename
     */
    public void writeInts(List<Integer> numbers, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename, false)) {
            for (Integer i : numbers) {
                outputStream.write(String.valueOf(i).getBytes());
                outputStream.write(32);
            }
        }
    }

    /**
     * the file contains data in the following format "12, 35, 234"
     *
     * @param filename
     * @return
     */
    public List<Integer> readInts(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String res = new String(bytes);
            String[] divided = res.split("\n");
            for (String s : divided) {
                Integer number = Integer.parseInt(s);
                numbers.add(number);


            }
            return numbers;
        }

    }
}
