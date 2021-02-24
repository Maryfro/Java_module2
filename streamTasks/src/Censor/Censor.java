package Censor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Censor {
    private final Set<String> dictionary;

    public Censor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * @param text text contains words divided by spaces
     * @return true if the text does not contain words from dictionary
     */
    public boolean verify(String text) {
        String[] res = text.split(" ");
        for (String word : res) {
            if (dictionary.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Censor censor = new Censor(new HashSet<>(Arrays.asList("fuck", "bitch", "suck")));
        System.out.println(censor.verify(" Hello bitch, you suck as fuck"));
        System.out.println(censor.verify(" Hello my dear, you rock as cock"));
    }

}
