package praktikum;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task4 {

    /**
     * Нужно вывести два числа, в сумме дающие k.
     *
     * Если таких пар несколько, то можно вывести любую из них.
     *
     * Если таких пар не существует, то вывести «None».
     */

    public static void main(String[] args) throws IOException {
        List<String> input = readStrings();
        String[] valuesArr = input.get(1).split(" ");
        Integer[] arr = Arrays.stream(valuesArr).map(Integer::valueOf).toArray(Integer[]::new);
        int k = Integer.parseInt(input.get(2));
        int[] res = new int[2];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i] + arr[j] == k){
                   res[0] = arr[i];
                   res[1] = arr[j];
                    flag = true;

                }
            }
        }
        if(!flag)
            System.out.println("None");
       else{
            String list = Arrays.toString(res).replace(",", "");
            System.out.println( list.substring(1, list.length() - 1));
        }
    }

    public static List<String> readStrings() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input2.txt"))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }
}
