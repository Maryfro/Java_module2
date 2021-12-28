package praktikum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Даны два массива чисел длины n. Составьте из них один массив длины 2n,
 * в котором числа из входных массивов чередуются (первый — второй — первый — второй — ...).
 * При этом относительный порядок следования чисел из одного массива должен быть сохранён.
 */
public class task2 {
    public static void main(String[] args) throws IOException {
       List<String>input = readStrings();
        String one = input.get(1);
        String two = input.get(2);
        String[]arr1 = one.split(" ");
        String[]arr2 = two.split(" ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
            System.out.print(arr2[i] + " ");
        }
    }

    public static List<String> readStrings() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }
}
