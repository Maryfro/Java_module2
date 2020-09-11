public class PowNumber {
    public static void main(String[] args) {
        System.out.println(powNumber(5, 3));
        System.out.println(pow(5, 3));
    }

    public static int powNumber(int number, int pow) {
        while (pow != 1) {
            return powNumber(number, --pow) * number;
        }
        return number;
    }
    public static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
}
