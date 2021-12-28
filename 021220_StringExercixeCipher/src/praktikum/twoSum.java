package praktikum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class twoSum {

    public static void main(String[] args) throws IOException {
        List<String> input = readStrings();
        String[] valuesArr = input.get(1).split(" ");
        Integer[] arr = Arrays.stream(valuesArr).map(Integer::valueOf).toArray(Integer[]::new);
        int k = Integer.parseInt(input.get(2));
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for (Integer num : arr) {
            int second = k - num;
            if (map.containsKey(second)) {
                System.out.println(second + " " + num);
                flag = true;
                break;
            } else {
                map.put(num, null);
            }
        }
        if (!flag) {
            System.out.println("None");
        }


    }

    public static List<String> readStrings() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input3.txt"))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            return res;
        }
    }
}
