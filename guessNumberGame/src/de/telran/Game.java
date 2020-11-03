package de.telran;

public class Game {
    private int attempts;
    private int secretNumber;
    private GameMessenger messenger;
    private NumberReader nm;

    public Game(int attempts, GameMessenger messenger, NumberReader nm) {
        this.attempts = attempts;
        secretNumber = (int) (Math.random() * 10);
        this.messenger = messenger;
        this.nm = nm;
    }

    public void playNew() {
        doGreeting();
        showGameOver(guess());
        if (nm instanceof ConsoleNumberReader) {
            ((ConsoleNumberReader) nm).close();
        }
    }

    private void showGameOver(boolean guessed) {
        if (guessed) {
            doYouWin();
        } else {
            doYouLoose();
        }
    }

    private boolean guess() {
        while (attempts > 0) {
            int userNumber = nm.getUserNumber();
            if (userNumber == secretNumber) {
                return true;
            } else {
                attempts--;
                doTryAgain();
            }
        }
        return false;
    }

    private void doGreeting() {
        messenger.send("Welcome to the game! Enter a number ");
    }

    private void doYouWin() {
        messenger.send("Congrats!");
    }

    private void doYouLoose() {
        messenger.send("you lost");
    }

    private void doTryAgain() {
        messenger.send("Wrong number, attempts remained: " + attempts);
    }
}
