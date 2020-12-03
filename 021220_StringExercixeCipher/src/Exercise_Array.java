public class Exercise_Array {

    public static void main(String[] args) {
        Exercise_Array arr = new Exercise_Array();
       // System.out.println(arr.countRepeatedNumbers(new int[]{5, -3, -3, -3, -3}));
        System.out.println(arr.findSwitchingSequence(new int[]{5, -3, 5, -3, 5})); // 5
        System.out.println(arr.findSwitchingSequence(new int[]{5})); //1
        System.out.println(arr.findSwitchingSequence(new int[]{})); //0
        System.out.println(arr.findSwitchingSequence(new int[]{5, 3, 2, 4, 3, 4})); // 3
        //TODO fix this case
        System.out.println(arr.findSwitchingSequence(new int[]{5, 5, 5, 5, 5, 5})); // 1
    }

    /**
     * Given an array int[]
     *
     * @return the number, which is mostly repeated.
     **/
    public int countRepeatedNumbers(int[] arr) {
        if (arr.length == 0)
            return 0;
        int count = 1;
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
            num = arr[i];
        }
        return count;
    }


    /**
     * We name a sequence "switching" if elements with odd and even indices are equal.
     *
     * @return max length of switching sequence
     * {5, -3, 5, -3, 5}->5; {5}->1; {}->0
     */
    public int findSwitchingSequence(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        int num = arr[0];
        int count = 2;
            for (int i = 1; i < arr.length - 1; i++) {
                if (num == arr[i + 1] && num != arr[i])
                    count++;
                num = arr[i];
            }
            return count;

    }
}
