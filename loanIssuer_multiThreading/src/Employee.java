public class Employee implements Runnable {
    private String name;
    private long minSpeed;
    private long maxSpeed;
    private final int loanQty;
    long startingTime;
    long resTime;
    private final boolean isStable;

    public Employee(String name, long minSpeed, long maxSpeed, int loanQty, long startingTime, boolean isStable) {
        this.name = name;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.loanQty = loanQty;
        this.startingTime = startingTime;
        this.isStable = isStable;
    }

    @Override
    public void run() {
        boolean isEnlightened = false;
        int count = 3;
        for (int i = 0; i < loanQty; i++) {
            if (!isStable && isEnlightened || !isStable && (Math.random() * 100 < 20)) {
                minSpeed = 50;
                maxSpeed = 100;
                isEnlightened = true;
                try {
                    Thread.sleep(((long) (Math.random() * (maxSpeed - minSpeed))) + minSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                if (count == 0) {
                    isEnlightened = false;
                    count = 3;
                }
            } else {
                try {
                    Thread.sleep(((long) (Math.random() * (maxSpeed - minSpeed))) + minSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        resTime = System.currentTimeMillis() - startingTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", resTime=" + resTime +
                '}';
    }
}

