package telran.data;

public class Game {

    public void guessNumber(Messenger messenger) {
        messenger.displayMessage("Hello player!");
        messenger.displayMessage("Enter maximal range for number, please");
        int range = messenger.getNumber();
        messenger.displayMessage("I have a number from 0 to " + range);
        int number = randomNumber(range);
        int userNumber;

        while (true) {
            messenger.displayMessage("Enter a number, please");
            userNumber = messenger.getNumber();
            if (userNumber == number) {
                System.out.println("Bingo");
                break;
            } else if (userNumber > number) {
                messenger.displayMessage("My number is less");
            } else {
                messenger.displayMessage("My number is greater");
            }
        }
        messenger.closeScanner();
    }

    public static int randomNumber(int range) {
        return (int) (Math.random() * range);
    }
}
