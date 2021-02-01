import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        printWriter();
        printStream();

        PrintTimeTester ptpw = new PrintTimeTester(new PrinterPW());
        PrintTimeTester ptps = new PrintTimeTester(new PrinterPS());
        ptpw.test(1000, "hello");
        ptps.test(1000, "hello");
    }

    public static void printWriter() throws IOException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);
        PrintWriter pw1 = new PrintWriter("output.txt");

        pw.println("hello");
        pw.println("hello");
        pw.println("hello");
        //commit collected data
        pw.flush();
        pw.println("hello2");
        fos.write("hi ".getBytes());
        pw.close();
    }

    public static void printStream() throws IOException { //this method is slow
        FileOutputStream fos = new FileOutputStream("output2.txt");
        PrintStream ps = new PrintStream(fos);
        ps.println("hello");
        ps.println("hello");
        ps.println("hello");
        ps.println("hello2");

    }
}
