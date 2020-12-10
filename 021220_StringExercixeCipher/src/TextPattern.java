public class TextPattern {

    /***
     * Is pattern subsequence of text?
     * //hello, hll ->true
     * //hello, llh ->false
     * //hello, hello ->true
     * //hello, eo ->true
     */

    boolean findPattern(String text, String pattern) {
        if (pattern.length() == 0) {
            return true;
        }
        if (text.length() < pattern.length()) {
            return false;
        }
        if (text.charAt(text.length() - 1) == pattern.charAt(pattern.length() - 1)) {
            return findPattern(text.substring(0, text.length() - 1), pattern.substring(0, pattern.length() - 1));
        } else {
            return findPattern(text.substring(0, text.length() - 1), pattern);
        }
    }
}
