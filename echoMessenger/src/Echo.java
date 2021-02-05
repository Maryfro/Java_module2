public class Echo implements Runnable {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            //some complex logic lasting long time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { //checked exception, not an error
                //interrupted exception should be generated there, where we want to interrupt this thread
              //  e.printStackTrace();
                System.out.println(message);
            }
        }
    }
}
