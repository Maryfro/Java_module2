public class Main {
    public static void main(String[] args) throws InterruptedException {
        OneItemStringQueue queue = new OneItemStringQueue();
        MessageSupplier supplier = new MessageSupplier(queue);
        MessageConsumer consumer1 = new MessageConsumer(queue);
        MessageConsumer consumer2 = new MessageConsumer(queue);
        MessageConsumer consumer3 = new MessageConsumer(queue);
        Thread supplierThread = new Thread(supplier);
        Thread consumer1Thread = new Thread(consumer1);
        consumer1Thread.setDaemon(true);
        Thread consumer2Thread = new Thread(consumer2);
        consumer2Thread.setDaemon(true);
        Thread consumer3Thread = new Thread(consumer3);
        consumer3Thread.setDaemon(true);
        supplierThread.start();
        consumer1Thread.start();
        consumer2Thread.start();
        consumer3Thread.start();


    }
}
