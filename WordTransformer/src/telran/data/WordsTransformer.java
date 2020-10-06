package telran.data;

public class WordsTransformer {

    public static String WordTransformNew(String input, WordsChecker wc) {
        String[] strings = input.split(" ");
        for (int j = 0; j < strings.length; j++) {
            if (wc.checkLength(strings[j])) {
                strings[j] = wc.action(strings[j]);
            }
        }
        String str = String.join(" ", strings);
        return str;
    }

   public static String WordTransformAllActions(String input, WordsChecker[] transformables) {
        String[] strings = input.split(" ");
        for (int i = 0; i < transformables.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (transformables[i].checkLength(strings[j])) {
                    strings[j] = transformables[i].action(strings[j]);
                }
            }
        }
        String str = String.join(" ", strings);
        return str;
    }
}


