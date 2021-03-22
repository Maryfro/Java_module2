public class IncrementingInteger {
    private int source;

    //volatile
    public IncrementingInteger(int source) {
        this.source = source;
    }

    public IncrementingInteger() {
    }

    public synchronized void increment() {
        // synchronized (this) {
        source++;
        //  }


        //this block will be locked for other threads
      /*  synchronized (IncrementingInteger.class){
            source++;
        }*/
    }

    public int get() {
        return source;
    }
}



