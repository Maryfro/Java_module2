package telran;

public class Math {

    public static class Factorial {
        private int result;
        private int number;

        private Factorial(int result, int number) {
            this.result = result;
            this.number = number;
        }

        public int getResult() {
            return result;
        }

        public int getNumber() {
            return number;
        }

        public static Factorial getFactorial(int x) {
            int result = 1;
            for (int i = 1; i <= x; i++) {
                result *= i;
            }
            return new Factorial(result, x);
        }
    }
}
