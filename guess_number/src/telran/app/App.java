package telran.app;

import telran.data.Game;
import telran.data.Messenger;

public class App {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        Game game = new Game();

        game.guessNumber(messenger);

    }
}
