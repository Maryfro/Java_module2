import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        try {
            File myFile = new File("chat.txt");
            Scanner fileReader = new Scanner(myFile);
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
