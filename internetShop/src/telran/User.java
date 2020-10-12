package telran;

import java.util.Scanner;

public class User {
    private String login;
    private String password;
    Basket basket;

    public User(String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public boolean checkLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login please");
        String userLogin = scanner.nextLine();
        if (userLogin.equalsIgnoreCase(login)) {
            System.out.println("login is correct");
            return true;
        } else {
            System.out.println("your login is not correct, we cannot find you in our system");
            scanner.close();
            return false;
        }
    }

    public boolean checkPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password please");
        String userPassword = scanner.nextLine();
        scanner.close();
        if (userPassword.equalsIgnoreCase(password)) {
            System.out.println("password is correct");
            return true;
        } else {
            System.out.println("your password is not correct, we cannot verify you in our system");
            return false;
        }
    }
}




