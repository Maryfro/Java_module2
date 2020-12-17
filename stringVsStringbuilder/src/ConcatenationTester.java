public class ConcatenationTester {
    private Concatenator concatenator;

    public ConcatenationTester(Concatenator concatenator) {
        this.concatenator = concatenator;
    }

    public void test(int times, String text) {
        String[] arr = composeArray(times, text);
        long beforeConcatenation = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            concatenator.concatenate(arr);
        }
        long timeConcatenated = System.currentTimeMillis() - beforeConcatenation;
        System.out.println(timeConcatenated);
    }

    String[] composeArray(int times, String text) {
        String[] composedArray = new String[times];
        for (int i = 0; i < times; i++) {
            composedArray[i] = text;
        }
        return composedArray;
    }

}
