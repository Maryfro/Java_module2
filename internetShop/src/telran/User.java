package telran;

import java.util.Scanner;

public class User {
    Basket basket = new Basket(10);

    interface Authentication {
    }

    boolean checkAuthentication(Authentication authentication) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + authentication.getClass().getSimpleName() + " please");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase(authentication.toString())) {
            System.out.println(authentication.getClass().getSimpleName() + " is correct");
            return true;
        } else {
            System.out.println("your " + authentication.getClass().getSimpleName()
                    + " is not correct, we cannot find you in our system");
            return false;
        }
    }
}





