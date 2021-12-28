package praktikum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class task3 {

    /**
     * Вам дана статистика по числу запросов в секунду к вашему любимому рекомендательному сервису.
     * <p>
     * Измерения велись n секунд.
     * <p>
     * В секунду i поступает qi запросов.
     * <p>
     * Примените метод скользящего среднего с длиной окна k к этим данным и выведите результат.
     */

    public static void main(String[] args) throws IOException {
        List<String> input = readStrings();
        String[] valuesArr = input.get(1).split(" ");
        Double[] arr = Arrays.stream(valuesArr).map(Double::valueOf).toArray(Double[]::new);
        System.out.println(Arrays.toString(arr));
        int k = Integer.parseInt(input.get(2));
        Double currentSum = 0.0;
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        res.add(currentSum / k);
        for (int i = 0; i < arr.length - k; i++) {
            currentSum -= arr[i];
            currentSum += arr[i + k];
            res.add(currentSum / k);
        }
        String list = Arrays.toString(res.toArray()).replace(",", "");
        System.out.println( list.substring(1, list.length() - 1));
    }

    public static List<String> readStrings() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input1.txt"))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }
}
