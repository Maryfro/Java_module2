public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start of main thread");
        CharThread starThread = new CharThread(20, '*');
        CharThread plusThread = new CharThread(20, '+');
      /*  starThread.start();
        plusThread.start();
        starThread.join(); //thread from which method join is called waits the thread (main waits for char thread)
        plusThread.join();*/
        System.out.println("End of main");

        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread((Runnable) mr);
        thread.start();
    }
}
