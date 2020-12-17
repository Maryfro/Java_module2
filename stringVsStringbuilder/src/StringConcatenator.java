public class StringConcatenator implements Concatenator {
    @Override
    public void concatenate(String[] strings) {
        String res = "";
        for (String s :
                strings) {
            res += s;
        }
    }
}
