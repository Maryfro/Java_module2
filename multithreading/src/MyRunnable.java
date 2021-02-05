public class MyRunnable implements Runnable {
    final int times;
    final char ch;

    public MyRunnable(int times, char ch) {
        this.times = times;
        this.ch = ch;
    }

    @Override
    public void run() {
        System.out.println("start of the runnable thread");
        for (int i = 0; i < times; i++) {
            System.out.println(ch);

        }
    }

    // class myRunnable implements Runnable{
    // @Override
    // public void run(){
    // write your logic of thread here
    // }

    /*MyRunnable myRunnable = new MyRunnable();
    Thread thread = new Thread( myRunnable);
    thread.start();*/
    // }

    //myRunnable can be extended by smth else
}
