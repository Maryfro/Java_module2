package telran.app;


public class CountLetters {
    public static void main(String[] args) {
        System.out.println(printRepeatChar("aaabbcdddd"));
        System.out.println(printRepeatChar("wwwggkiii"));
        printRepeatCharSolution("wwwggkiii");
        StringBuffer sb = new StringBuffer("aaabbcdddd");
        System.out.println("------------");
        printRepeatChar(sb);
        System.out.println("------------");
        //countSameLettersInString("aaabbcdddd");
    }

    private static String printRepeatChar(String input) {
        String output = "";
        int start = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                output += input.charAt(i) + String.valueOf(i + 1 - start);
                start = i + 1;
            } else if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(input.length() - 1)) {
                output += input.charAt(i) + String.valueOf(input.length() - i);
                break;
            }
        }
        return output;
    }

    private static void printRepeatChar(StringBuffer input) {
        int start = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                System.out.print(input.charAt(i) + String.valueOf(i + 1 - start));
                start = i + 1;
            } else if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(input.length() - 1)) {
                System.out.print(input.charAt(i) + String.valueOf(input.length() - i));
                break;
            }
        }
        System.out.println();
    }

    private static void countSameLettersInString(String input) {
        String output = "";
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                String sameLetters = input.substring(0, i + 1);
                input = input.substring(i + 1);
                int countSameLetters = sameLetters.codePointCount(0, i + 1);
                output += sameLetters.substring(0, 1) + countSameLetters;
                i = 0;
            }
        }
        System.out.println(output);
    }

    private static void printRepeatCharSolution(String input) {
        int count = 1;
        char c = input.charAt(0);
        StringBuffer output = new StringBuffer();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                count++;
            } else {
                output = output.append(c).append(count);
                c = input.charAt(i);
                count = 1;
            }
        }
        output = output.append(c).append(count);
        System.out.println(output);
    }
}
