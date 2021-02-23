package AccountServiceFlatMap;

import java.util.Date;

public class Transaction {
    private String uuid;
    private Enum State;
    private long sum;
    private Date date;

    public Transaction(String uuid, Enum state, long sum, Date date) {
        this.uuid = uuid;
        State = state;
        this.sum = sum;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public Enum getState() {
        return State;
    }

    public long getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
