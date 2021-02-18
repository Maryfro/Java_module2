import com.sun.tools.javac.util.StringUtils;

import java.util.*;

public class SplitText {


    public List<String> splitTextWithDictionary(Set<String> dictionary, String text) {
        if (text.isEmpty())
            return null;
        List<String> res = new ArrayList<>();
        String temp = text;
        boolean flag = true;
        int mismatchCounter = 0;
        while (flag) {
            for (String word : dictionary) {
                if (temp.startsWith(word)) {
                    res.add(word);
                    temp = temp.substring(word.length());
                } else {
                    mismatchCounter++;
                }
            }
            if (temp.length() == 0 || mismatchCounter > dictionary.size()) {
                flag = false;
            }
        }
        String temp2 = String.join("", res);
        if (!temp2.equals(text))
            return null;
        return res;

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
