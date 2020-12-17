public class StringBuilder implements Concatenator {
    @Override
    public void concatenate(String[] strings) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
    }
}
