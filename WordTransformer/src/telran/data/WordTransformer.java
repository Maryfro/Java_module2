package telran.data;

public class WordTransformer {

    public static String transformWord(String input) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 3) {
               strings[i] = strings[i].toUpperCase();
            }
        }
        String str = String.join(" ", strings);
        return str;
    }

    public static String transformWord1(String input, int action) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(action == 1) {
                if (strings[i].length() == 3) {
                    strings[i] = strings[i].toUpperCase();
                }
            } else if(action == 2){
                if (strings[i].length() == 4) {
                    strings[i] = strings[i].toLowerCase();
                }
            }
        }
        String str = String.join(" ", strings);
        return str;
    }

    public static String WordTransformNew(String input, TransformerRuleLength3 tr3){
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++){
            if(tr3.checkLength(strings[i])){
                strings[i] = tr3.action(strings[i]);
            }
        }
        String str = String.join(" ", strings);
        return str;
    }
}
