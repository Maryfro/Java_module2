public class CharThread extends Thread {
    final int times;
    final char ch;

    public CharThread(int times, char ch) {
        this.times = times;
        this.ch = ch;
    }

    @Override
    public void run() {
        System.out.println("start of char thread");
        for (int i = 0; i < times; i++) {
            System.out.println(ch);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("end of char thread");
    }
}
