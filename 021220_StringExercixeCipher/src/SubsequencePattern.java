import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsequencePattern {

    public static void main(String[] args) {
        SubsequencePattern task = new SubsequencePattern();

        System.out.println(Arrays.asList(task.addSubsequenceToList("helloworld", "helworeld")).toString());
    }

    /**
     * There is text, we need to split it into subsequences of pattern
     * and add to list. Return null if split is not possible
     * Both Strings contain latin chars in lower case.
     * <p>
     * **"Hello"->"Hlo" is subsequence, "lho" ->not subsequence
     * <p>
     * text "helloworld", pattern "helworeld"
     * result={hel, lo, world}
     *
     * @param text
     * @param pattern
     * @return
     */

    public List<String> addSubsequenceToList2(String text, String pattern) {
        List<String> res = new ArrayList<>();
        String temp = text;
        String control = "";
        for (int i = temp.length(); i >= 0; i--) {
            if (findPattern(pattern, text) && !text.isEmpty()) {
                res.add(text);
                control += text;
                i += text.length();
                text = temp.substring(control.length());
            }
            if (text.length() == 0)
                break;
            text = text.substring(0, text.length() - 1);
        }
        return res;
    }

    public List<String> addSubsequenceToList(String text, String pattern) {
        if (text == null || text.length() == 0)
            return null;
        List<String> sequence = new ArrayList();
/*
        if (findPattern(text, pattern))
            sequence.add(pattern);*/

        if (splitRecursively(text, pattern, 0, sequence))
            return sequence;
        return null;
    }

    boolean findPattern(String text, String pattern) {
        if (pattern.length() == 0) {
            return true;
        }
        if (text.length() < pattern.length()) {
            return false;
        }
        if (text.charAt(text.length() - 1) == pattern.charAt(pattern.length() - 1)) {
            return findPattern(text.substring(0, text.length() - 1), pattern.substring(0, pattern.length() - 1));
        } else {
            return findPattern(text.substring(0, text.length() - 1), pattern);
        }
    }

    private boolean splitRecursively(String text, String pattern, int startIndex, List<String> sequence) {
        if (startIndex == text.length())
            return true;
        String temp = "";
        String textConst = text;
        for (int i = text.length(); i >= 0; i--) {

            if (findPattern(pattern, text)) {
                temp += text;
            }
            if (!temp.isEmpty()) {
                sequence.add(temp);
               // startIndex = temp.length();
                i = startIndex = temp.length();
                 text = textConst.replace("", temp);
                System.out.println(text);
            }
            text = text.substring(0, text.length() - 1);

            boolean isSplit = splitRecursively(text, pattern, startIndex, sequence);
            if (isSplit)
                return true;

            sequence.remove(temp);
        }

        return false;
    }
}
