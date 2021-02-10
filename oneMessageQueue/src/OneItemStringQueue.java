public class OneItemStringQueue {

    private String source;

    public void addFirst(String item) {
        synchronized (this) {
            source = item;
            //wake up one thread
            this.notify();
        }
    }

    public String removeLast() throws InterruptedException {
        synchronized (this) {
            while (source == null)
                //thread sleeps
                this.wait();
        }
        String res = source;
        source = null;
        return res;
    }

    @Override
    public String toString() {
        return "OneItemStringQueue{" +
                "source='" + source + '\'' +
                '}';
    }
}
