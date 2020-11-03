package de.telran;

import java.util.Scanner;

public class ConsoleNumberReader implements NumberReader {
    private Scanner input = new Scanner(System.in);

    @Override
    public int getUserNumber() {
        return input.nextInt();
    }

    public void close(){
        input.close();
    }
}
