package telran.app;

import telran.dao.Bank;
import telran.data.BankAccount;
import telran.data.Gender;
import telran.data.Person;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        Person client1 = new Person("Ivan", "Ivanov",
                1990, "Potsdamer Platz, 1", Gender.MALE);
        Person client2 = new Person("Ivanka", "Ivanova",
                1980, "Potsdamer Platz, 2", Gender.FEMALE);
        Person client3 = new Person("Tom", "Soyer",
                1982, "USA", Gender.MALE);
        Person client4 = new Person("Harry", "Potter",
                1991, "Buckingham Palace, 4", Gender.MALE);
        Person client5 = new Person("Greta", "Thunberg",
                2001, "Stockholm", Gender.FEMALE);
        Person client6 = new Person("Julia", "Roberts",
                1979, "Hollywood", Gender.FEMALE);
        Person client7 = new Person("Edward", "Snowden",
                1975, "Moscow", Gender.MALE);

        BankAccount account1 = new BankAccount(client1, 2563);
        BankAccount account2 = new BankAccount(client2, 38.5);
        BankAccount account3 = new BankAccount(client3, 1000000000);
        BankAccount account4 = new BankAccount(client4, 555000);
        BankAccount account5 = new BankAccount(client5, 0.01);
        BankAccount account6 = new BankAccount(client6, 999999);
        BankAccount account7 = new BankAccount(client7, 99.99);

        Bank myBank = new Bank(100);
        myBank.addAccount(account1);
        myBank.addAccount(account2);
        myBank.addAccount(account3);
        myBank.addAccount(account4);
        myBank.addAccount(account5);
        myBank.addAccount(account6);
        myBank.addAccount(account7);

       /* myBank.displayAccounts();
        myBank.transferMoney(10100001, 10100002, 1000);
        System.out.println("-------------------");
        myBank.transferMoney(10100001, 10100002, 1800);
        System.out.println("-------------------");
        System.out.println(myBank.getTotalBalance());
        System.out.println("-------------------");*/
        System.out.println(myBank.countClientsPerGender(Gender.MALE));
        System.out.println(myBank.countClientsPerGender(Gender.FEMALE));
        System.out.println("-------------------");
        myBank.displayClientsPerGender(Gender.FEMALE);
        // System.out.println(Arrays.toString(myBank.getClientsPerGender(Gender.FEMALE)));
        //System.out.println(Arrays.toString(myBank.getClientsPerGender(Gender.MALE)));
        Person.displayPersons(myBank.getClientsPerGender(Gender.MALE));


    }

}
