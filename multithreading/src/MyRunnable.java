public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start of the runnable thread");
        for (int i = 0; i <20 ; i++) {
        System.out.println("hello");

        }
    }

    // class myRunnable implements Runnable{
    // @Override
    // public void run(){
    // write your logic of thread here
    // }

    /*MyRunnable myRunnable = new MyRunnable();
    Thread thread = new Thread((Runnable) myRunnable);
    thread.start();*/
    // }

    //myRunnable can be extended by smth else
}
