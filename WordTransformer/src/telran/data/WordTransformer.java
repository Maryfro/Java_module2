package telran.data;

public class WordTransformer {

    public static String WordTransformNew(String input, Transformable tr) {
        String[] strings = input.split(" ");
        for (int j = 0; j < strings.length; j++) {
            if (tr.checkLength(strings[j])) {
                strings[j] = tr.action(strings[j]);
            }
        }
        String str = String.join(" ", strings);
        return str;
    }

 /*   public static String WordTransformAllActions(String input, Transformable[] transformables) {
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
    }*/
}


