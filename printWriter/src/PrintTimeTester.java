import java.io.FileNotFoundException;

public class PrintTimeTester {
    private Printer printer;

    public PrintTimeTester(Printer printer) {
        this.printer = printer;
    }

    public void test(int times, String text) throws FileNotFoundException {
        String[] arr = composeArray(times, text);
        long beforePrinting = System.currentTimeMillis();
        printer.print(arr);
        long timeConcatenated = System.currentTimeMillis() - beforePrinting;
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
