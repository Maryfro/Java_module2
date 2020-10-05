package telran.data;

public class StringExercise {
    public static void main(String[] args) {
        //"I always do my homework" -> [I]
        //                            [always]
        //                            [do]...
        //printString("I always do my homework");
        printString1("I always do my homework");
    }

    public static void printString(String input) {
        System.out.print("[");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                System.out.print(input.charAt(i));
            } else {
                System.out.print("]\n[");
            }
        }
        System.out.print("]");
    }

    public static void printString1(String input) {
        System.out.print("[");
        for (int i = 0; i < input.length(); i++) {
            System.out.print((input.charAt(i) != ' ') ? input.charAt(i) : "]\n[");
        }
        System.out.print("]");
    }
}
