package de.telran;

public class App {
    public static void main(String[] args) {
        WordsChecker wc = new WordsChecker() {
            @Override
            public boolean checkWord(String word) {
                return word.length() == 3;
            }
        };
        WordsChecker wordsChecker = s -> s.length() == 4;
        WordTransformer wt = new WordTransformer() {
            @Override
            public String transform(String word) {
                return word.toUpperCase();
            }
        };
        WordTransformer wordTransformer = s -> s.replaceAll(".", "*");
        WordTransformer wordTransformer2 = App::transform;

        String word = "Hey";
        String word1 = "java";


        System.out.println(WordsTransform.transformWord(word, wc, wt));
        System.out.println(WordsTransform.transformWord(word1, wc, wordTransformer));

        WordsTransform.transformWord("AS FGK sdlk DN", s -> s.length() == 2, String::toLowerCase);
    }

    private static String transform(String s) {
        return s.toUpperCase();
    }
}
