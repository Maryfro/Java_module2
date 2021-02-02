

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


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
                // outputStream.write(System.lineSeparator().getBytes());
            }
            //another way
           /* String output = String.join(System.lineSeparator(), strings);
            outputStream.write(output.getBytes());*/
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
            String input = new String(bytes);
            return Arrays.asList(input.split(System.lineSeparator()));
        }
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

    public void writeInts1(List<Integer> numbers, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename, false)) {
            if (numbers == null || numbers.size() == 0)
                return;

            StringBuilder sb = new StringBuilder();
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                sb.append(" ").append(iterator.next());
            }
            outputStream.write(sb.toString().getBytes());
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
            String[] divided = res.split(" ");
            for (String s : divided) {
                Integer number = Integer.parseInt(s);
                numbers.add(number);

            }
            return numbers;
        }

    }
}
