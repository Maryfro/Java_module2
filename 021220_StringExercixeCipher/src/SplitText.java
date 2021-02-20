
import java.util.*;

public class SplitText {


    public List<String> splitTextWithDictionary(Set<String> dictionary, String text) {
        int size = dictionary.size();
        List<String> dictList = new ArrayList<>(dictionary);
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




    public static void main(String[] args) {
        SplitText st = new SplitText();
        Set<String> dictionary = new HashSet<>();
        Set<String> dictionary1 = new HashSet<>();
        Collections.addAll(dictionary, "operation", "hello", "hell");
        System.out.println(st.splitTextWithDictionary(dictionary, "helloperation"));

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
