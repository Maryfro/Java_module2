import java.util.ArrayList;
import java.util.List;

public class FindOnes {

    // Есть диапазон чисел от a до b включительно. Найти количество чисел, содержащих цифру 1.

    public int findOnes(int a, int b) {
        List<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            list.add(i);
        }
        int count = 0;
        for (Integer num : list) {
            String temp = num.toString();
            if (temp.contains("1"))
                count++;
        }
        return count;
    }


}
