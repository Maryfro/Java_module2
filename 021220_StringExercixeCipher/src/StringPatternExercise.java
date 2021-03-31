import java.util.*;

public class StringPatternExercise {


    /**
     * There is text, which contains words and spaces. We need to substring
     * text in such a way that
     * 1. it has max length but not longer than the value of index.
     * 2. it contains full original words.
     * **(Hello world , 3) ->""
     * **(Hello world , 5) ->Hello
     * **(Hello world , 8) ->Hello
     * **(Hello world , 11) ->Hello world
     *
     * @param text * @param index
     * @return
     */
    public String maxLengthSubstring(String text, int index) {
        String res = text;
        if (text.length() > index) {
            res = text.substring(0, index + 1);
        }
        if (res.endsWith(" "))
            return res.trim();
        else if (!res.contains(" "))
            return "";
        res = res.replaceAll("\\s.*", "");
        return res;
    }

}
