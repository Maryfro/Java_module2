package Censor;

import java.util.Set;
import java.util.stream.Stream;

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
        String[] words = text.split(" ");
        return Stream.of(words)
                .map(String::toLowerCase)
                .noneMatch(dictionary::contains);
    }
}
