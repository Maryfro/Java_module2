public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 8};
        // create method, which finds missing number in array
        System.out.println(findMissingNumber(a));
        System.out.println(findMissingNumber2(a));
    }

    public static int findMissingNumber(int[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] + 1 != input[i + 1]) {
                result = input[i] + 1;
                break;
            }
        }
        return result;
    }

    public static int findMissingNumber2(int[] input) {
        int sum = 0, sumI = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            sumI = sum + (i + 1);
        }
        return sumI - sum;
    }

}
