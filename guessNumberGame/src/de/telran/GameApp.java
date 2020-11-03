package de.telran;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Game game = new Game(8, new ConsoleGameMessenger(), new ConsoleNumberReader());
        game.playNew();

        NumberReader nm = ()->{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        };

        Game game1 = new Game(8, str -> System.out.println(str), nm);
    }
}
