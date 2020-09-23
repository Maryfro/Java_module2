package telran.dao;

import telran.data.BankAccount;
import telran.data.Gender;


public class Bank {
    private BankAccount[] accounts;
    private int size;

    public Bank(int capacity) {
        accounts = new BankAccount[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int checkAccount(int accountNumber) {
        for (int i = 0; i < size; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAccount(BankAccount account) {
        if (checkAccount(account.getAccountNumber()) >= 0 || size >= accounts.length) {
            return false;
        }
        accounts[size] = account;
        size++;
        return true;
    }

    public boolean closeAccount(int accountNumber) {
        int index = checkAccount(accountNumber);
        if (index < 0) {
            return false;
        }
        accounts[index] = accounts[size - 1];
        size--;
        return true;
    }

    public void displayAccounts() {
        for (int i = 0; i < size; i++) {
            System.out.println(accounts[i]);
            System.out.println("-------------");
        }
    }

    public BankAccount[] getExistingAccounts() {
        BankAccount[] allAccounts = new BankAccount[size];
        for (int i = 0; i < size; i++) {
            allAccounts[i] = accounts[i];
        }
        return allAccounts;
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (int i = 0; i < size; i++) {
            totalBalance += accounts[i].getBalance();
        }
        return totalBalance;
    }

    public boolean transferMoney(int accountFrom, int accountTo, double amount) {
        int indexFrom = checkAccount(accountFrom);
        if (indexFrom < 0) {
            System.out.println("Sorry, withdrawal account was not founded, please try again");
            return false;
        }
        int indexTo = checkAccount(accountTo);
        if (indexFrom < 0) {
            System.out.println("Sorry, recipient's account was not founded, please try again");
            return false;
        }
        if (!accounts[indexFrom].credit(amount)) {
            System.out.println("Transfer is not possible, your balance is insufficient");
            return false;
        }
        accounts[indexTo].debit(amount);
        System.out.println("Your transfer is accomplished as stated below: ");
        System.out.println("amount of transfer " + amount + " was transferred to " + accounts[indexTo].getClient());
        System.out.println("your balance is " + accounts[indexFrom].getBalance());
        return true;
    }

    public int countClientsPerGender(Gender gender) {
        int count = 0;
        for (BankAccount account : getExistingAccounts()) {
            if (account.getClient().getGender().equals(gender)) {
                count++;
            }
        }
        return count;
    }

    public void displayClientsPerGender(Gender gender) {
        for (BankAccount account : getExistingAccounts()) {
            if (account.getClient().getGender().equals(gender)) {
                System.out.println(account);
                System.out.println("------------------");
            }
        }
    }

    public String[] getClientsPerGender(Gender gender) {
        int newSize = countClientsPerGender(gender);
        int newIndex = 0;
        String[] clientsPerGender = new String[newSize];
        for (int i = 0; i < size; i++) {
            if (accounts[i].getClient().getGender().equals(gender) && accounts[i] != null) {
                clientsPerGender[newIndex] = accounts[i].getClient().toStringName();
                newIndex++;
                if (newIndex == newSize) {
                    break;
                }
            }
        }
        return clientsPerGender;
    }
}
