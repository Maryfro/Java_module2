public class TextPattern {

    public TextPattern() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

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

    boolean findPatternSolution2(String text, String pattern) {
        return recursiveSolution(text, pattern, text.length() - 1, pattern.length() - 1);
    }

    boolean recursiveSolution(String text, String pattern, int lastTextId, int lastPatternId) {
        if (lastPatternId < 0) {
            return true;
        }
        if (lastPatternId > lastTextId) {
            return false;
        }
        if (text.charAt(lastTextId) == pattern.charAt(lastPatternId)) {
            return recursiveSolution(text, pattern, lastTextId - 1, lastPatternId - 1);
        } else {
            return recursiveSolution(text, pattern, lastTextId - 1, lastPatternId);
        }

    }

    //TODO
    //rewrite method using a while loop


}

