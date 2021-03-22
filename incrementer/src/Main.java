public class Main {
    public static void main(String[] args) throws InterruptedException {
        IncrementingInteger inInteger = new IncrementingInteger();
        Thread th1 = new IncrementingThread(inInteger, 100000);
        Thread th2 = new IncrementingThread(inInteger, 100000);
        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(inInteger.get());
    }
}
