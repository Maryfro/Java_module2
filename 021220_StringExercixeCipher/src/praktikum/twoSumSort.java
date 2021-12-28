package praktikum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class twoSumSort {

    public static void main(String[] args) throws IOException {
        List<String> input = readStrings();
        String[] valuesArr = input.get(1).split(" ");
        int k = Integer.parseInt(input.get(2));
        Integer[] arr = Arrays.stream(valuesArr).map(Integer::valueOf).toArray(Integer[]::new);
        Arrays.sort(arr);
        int min = 0;
        int max = arr.length - 1;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[min] + arr[max] == k && min!=max) {
                System.out.println(arr[min] + " " + arr[max]);
                found = true;
                break;
            } else if (arr[min] + arr[max] > k) {
                max--;
            } else {
                min++;
            }

        }
        if(!found){
            System.out.println("None");
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
