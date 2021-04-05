
import java.util.*;

public class SplitText {
    private final Set<String> words;

    public SplitText(Collection<String> words) {
        this.words = new HashSet<>();
        this.words.addAll(words);
    }



    public List<String> splitTextWithDictionary(String text) {
        int size = words.size();
        List<String> dictList = new ArrayList<>(words);
        List<String> res = new ArrayList<>();
        String temp = text;
        boolean flag = true;
        int wordsInResListCounter = 0;
        int mismatchCounter = 0;
        while (flag) {
            for (String word : dictList) {
                if (temp.startsWith(word)) {
                    res.add(word);
                    wordsInResListCounter++;
                    temp = temp.substring(word.length());
                } else {
                    mismatchCounter++;
                }
            }
            if (wordsInResListCounter < size && temp.length() != 0) {
                Collections.rotate(dictList, 1);
                temp = text;
                res.clear();
                mismatchCounter = 0;

            }
            if (temp.length() == 0 || mismatchCounter > size) {
                flag = false;
            }
        }
        String temp2 = String.join("", res);
        if (!temp2.equals(text) || text.isEmpty())
            return null;
        return res;
    }

    public List<String> splitTextSolution(String text) {
        if (text == null || text.length() == 0)
            return null;

        Deque<String> sequence = new ArrayDeque<>();

        if (splitRecursively(text, 0, sequence))
            return new ArrayList<>(sequence);

        return null;
    }


    private boolean splitRecursively(String text, int startIndex, Deque<String> sequence) {
        if (startIndex == text.length())
            return true;

        for (String word : words) {
            if (text.startsWith(word, startIndex)) {
                System.out.println(word);
                sequence.addLast(word);
                System.out.println(sequence);

                boolean isSplit = splitRecursively(text, startIndex + word.length(), sequence);
                if (isSplit)
                    return true;

                sequence.removeLast();
            }
        }
        return false;
    }

   public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();

            Collections.addAll(dictionary, "hell", "world", "o");
        SplitText st = new SplitText(dictionary);
        st.splitTextSolution("helloworld");
      // System.out.println(st.splitTextWithDictionary("helloworld"));
    }


    // Task 2
    //There is a "dictionary" of lowercase words - set<String>, and there is a String text
    //RETURN  a list of words, which are splits, if a text could be split by words from dictionary
    // else return null
    //* set: hello world super text: hellosuper->List [hello, super]
    // set: hello world super text: supersuper->List [super, super]
    // set: hello world super text: superhellosuper->List [super,hello, super]
    // set: hello world super text: superhelloo->List [null]
    // set: hello world super text: hellopapa->List [null]
//Solution is recursive!use method startwith

}
