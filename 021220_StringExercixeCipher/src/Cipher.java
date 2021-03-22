public class Cipher {


    //"aaabbcdddd"-> a3b2cd4"

    public String toCipher(String input) {
        if (input.isEmpty()) {
            return "";
        }
        int count = 1;
        char c = input.charAt(0);
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == c) {
                count++;
            } else {
                output.append(c);
                if (count > 1)
                    output.append(count);
                c = input.charAt(i);
                count = 1;
            }
        }
        output.append(c);
        if (count > 1)
            output.append(count);
        return output.toString();
    }

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.toCipher("aaabbcdddd"));

    }
}
