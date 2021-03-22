package telran.game;

import javax.tools.ForwardingFileObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Map<Integer, Command> gameMap = new HashMap<>();
        gameMap.put(new DuckHunt().getNumber(), new DuckHunt());
        gameMap.put(new Soccer().getNumber(), new Soccer());
        gameMap.put(new Hockey().getNumber(), new Hockey());
        // System.out.println(gameMap);
        System.out.println("choose game (1 - duck hunt, 2 - soccer, 3 - hockey)");
        gameStart(gameMap);
    }

    public static void gameStart(Map<Integer, Command> gameMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number from 1 to 3");
        int userNum = scanner.nextInt();
        if (gameMap.containsKey(userNum)) {
            gameMap.get(userNum).execute();
        } else {
            System.out.println("wrong game number");
        }
        scanner.close();
    }
}
