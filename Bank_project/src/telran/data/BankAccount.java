package telran.data;

import java.util.Objects;

public class BankAccount {
    private int accountNumber;
    private Person client;
    private double balance;
    private static int accountsNumber = 10100000;

    public BankAccount(Person client, double balance) {
        accountNumber = ++accountsNumber;
        this.client = client;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Person getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber &&
                Double.compare(that.balance, balance) == 0 &&
                client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, client, balance);
    }

    @Override
    public String toString() {
        return "BankAccount " +
                "accountNumber: " + accountNumber +
                " \n" + client.toStringName() +
                "\nbalance " + balance;
    }

    public void debit(double sum) {
        balance += sum;
    }

    public boolean credit(double sum) {
        if (sum <= balance) {
            balance = balance - sum;
            return true;
        }
        return false;
    }
}
