package telran.data;

import java.util.Scanner;

public class Admin {
    private String password;

    public Admin(String password) {
        this.password = password;
    }
    public boolean checkPassword(Scanner scanner) {
        int count = 3;
        while (count > 0) {
            System.out.println("enter password ");
            String password = scanner.nextLine();
            if (this.password.equals(password))
                return true;
            else
                count--;
        }
        return false;
    }
}
