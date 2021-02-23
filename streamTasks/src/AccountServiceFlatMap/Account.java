package AccountServiceFlatMap;

import java.util.List;

public class Account {

private String id;
   private long balance;
   private List<Transaction> transactions;

    public Account(String id, long balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
