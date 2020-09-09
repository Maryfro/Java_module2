import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // static void greeting(String[] names){}
        //you have a String array, for example {Petya, Kolya, Olya, Katya}.
        // Write a method that will ask the user what is his name, if this name is in the array,
        // then the method print: “Hello, name!”. And if the name is not in the array - "Sorry, we don't know each other".
        String[] names = {"Petya", "Kolya", "Olya", "Katya"};
        greeting(names);
    }

    public static void greeting(String[] names) {
        int found = 0;
        String inputName = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        inputName = scanner.next();
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(inputName)) {
                found++;
                System.out.println("Hello, " + names[i]);
            }
        }
        if (found == 0) {
            System.out.println("Sorry, we don't know each other.");
        }
    }


}
