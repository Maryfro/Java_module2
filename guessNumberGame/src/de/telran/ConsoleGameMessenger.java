package de.telran;

public class ConsoleGameMessenger implements GameMessenger {

    @Override
    public void send(String str) {
        System.out.println(str);
    }
}
