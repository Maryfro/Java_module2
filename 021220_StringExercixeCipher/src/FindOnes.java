import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOnes {

    // Есть диапазон чисел от a до b включительно. Найти количество чисел, содержащих цифру 1.

    /**
     * The method returns quantity of numbers, containing the digits between a and b inclusively.
     *
     * @param a should be lower or equal with b
     * @param b
     * @return
     */
    public int findOnes(int a, int b, int digit) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            String temp = String.valueOf(i);
            if (temp.contains(String.valueOf(digit)))
                count++;
        }
        return count;
    }


}
