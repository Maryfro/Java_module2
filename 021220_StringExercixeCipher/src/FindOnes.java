import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOnes {

    // Есть диапазон чисел от a до b включительно. Найти количество чисел, содержащих цифру 1.

    public int findOnes(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            String temp = String.valueOf(i);
            if (temp.contains("1"))
                count++;
        }
        return count;
    }


}
