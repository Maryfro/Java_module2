import java.util.*;

public class ExerciseMap {
    /**
     * Given an array int[]. Every number in this array occurs even times, but one.
     *
     * @param arr - int[]
     * @return int number, which occurs in the array odd times.
     * {1,3,1}->3; {1,3,1,1,1}->3;  {1,3,1,3,3}->3
     */
    public int findOddNumber(int[] arr) {
        Map<Integer, Integer> map = countFrequency(arr);
        int oddValue = 1;
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                oddValue = map.get(key);
            }
        }
        return getKey(map, oddValue);
    }

    public Map <Integer, Integer> countFrequency(int[] arr){
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        return map;
    }

    public int getKey(Map map, Integer value) {
        for (Object key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return (int) key;
            }
        }
        throw new NoSuchElementException();
    }

    public static void main(String[] args) {
        ExerciseMap map = new ExerciseMap();
     /*   System.out.println(map.findOddNumber(new int[]{1, 3, 1}));//3
        System.out.println(map.findOddNumber(new int[]{1, 3, 1, 1, 1}));//3
        System.out.println(map.findOddNumber(new int[]{3, 3, 1, 3, 3}));//1
        System.out.println(map.findOddNumber(new int[]{10, -9, 5, 10, -9}));//5
        System.out.println(map.findOddNumber(new int[]{10, -9, -9, 5, 5}));//10
        System.out.println(map.findOddNumber(new int[]{10, -9, -9, 10, 5}));//5*/
        System.out.println(map.findOddNumber(new int[]{1, 3, 1, 3, 3}));//3
    }

}
