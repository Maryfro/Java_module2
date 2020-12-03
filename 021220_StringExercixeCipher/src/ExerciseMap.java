import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ExerciseMap {
    /**
     * Given an array int[]. Every number in this array occurs even times, but one.
     *
     * @param arr - int[]
     * @return int number, which occurs in the array odd times.
     * {1,3,1}->3; {1,3,1,1,1}->3;  {1,3,1,3,3}->3
     */
    public int findOddNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        int count = 1;
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, count++);
            } else {
                if (map.containsKey(j)) {
                    count++;
                }
            }
        }
        return getKey(map, Collections.max(map.values()));
    }

    int getKey(Map map, Integer value) {
        for (Object key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return (int) key;
            }
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        ExerciseMap map = new ExerciseMap();
        System.out.println(map.findOddNumber(new int[]{1, 3, 1}));//3
        System.out.println(map.findOddNumber(new int[]{1, 3, 1, 1, 1}));//3
        System.out.println(map.findOddNumber(new int[]{3, 3, 1, 3, 3}));//1
    }

}
