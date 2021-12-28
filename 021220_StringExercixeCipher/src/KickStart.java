import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class KickStart {
    /**
     * fragment is lucky when it starts with the string KICK,
     * then goes on with 0 or more characters, and eventually ends with the string START
     * count the number of different lucky fragments Two fragments are considered to be different
     * if they start or end at different positions in the text, even if the fragments read the same.
     * Also note that different lucky fragments may overlap.
     */


    public static int countLuckyFragments(String input) {
        String kick = "KICK";
        String start = "START";
        int count = 0;
        int startIndex = input.indexOf(kick);
        List<String> res = new ArrayList<>();
        String temp = "";
        String temp2 = "";
        for (int i = 0; i < input.length(); i++) {
            temp += input.charAt(i);
            temp2 += input.charAt(i);
            if (temp.contains(kick) || temp2.contains(start)) {
                res.add(temp);
                temp = "";
                temp2 = "";
            }
        }
        System.out.println("list " + res);
        System.out.println("start index " + startIndex);
        if (!(input.contains(kick) || !input.contains(start))) {
            return 0;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countLuckyFragments("AKICKSTARTPROBLEMNAMEDKICKSTART"));//3
        System.out.println(countLuckyFragments("STARTUNLUCKYKICK"));//0
        System.out.println(countLuckyFragments("KICKXKICKXSTARTXKICKXSTART"));//5

    }

}
