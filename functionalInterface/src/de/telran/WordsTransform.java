package de.telran;

public class WordsTransform {

    public static String transformWord(String input, WordsChecker wc, WordTransformer wt) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (wc.checkWord(strings[i])) {
                strings[i] = wt.transform(strings[i]);
            }
        }
        return String.join(" ", strings);
    }
}
