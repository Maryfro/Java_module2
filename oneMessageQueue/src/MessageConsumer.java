public class MessageConsumer implements Runnable {
    OneItemStringQueue queue;

    public MessageConsumer(OneItemStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String res = queue.removeLast();
                System.out.println(res);
                System.out.println(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
