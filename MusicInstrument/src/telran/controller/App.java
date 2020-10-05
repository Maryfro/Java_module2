package telran.controller;

import telran.data.Drum;
import telran.data.Guitar;
import telran.data.Playable;
import telran.data.Trumpet;

public class App {
    public static void main(String[] args) {
        Guitar guitar1 = new Guitar(6);
        Playable guitar2 = new Guitar(7);
        Drum drum1 = new Drum(5);
        Playable drum2 = new Drum(10);
        Trumpet trumpet1 = new Trumpet(30);
        Playable trumpet2 = new Trumpet(15);

        Playable[] playables = {guitar1, guitar2, drum1, trumpet1, drum2, trumpet2};

        for (Playable p : playables) {
            p.play();
        }
    }
}
