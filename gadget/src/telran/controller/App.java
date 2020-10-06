package telran.controller;

import telran.data.Gadget;
import telran.data.Off;
import telran.data.On;
import telran.data.Wait;

public class App {
    public static void main(String[] args) {
        Gadget gadget1 = new Gadget();
       /* gadget1.setState("on");
        gadget1.doAction();
        gadget1.setState("off");
        gadget1.doAction();*/

        gadget1.setState(new On());
        gadget1.doAction();
        gadget1.setState(new Off());
        gadget1.doAction();
        gadget1.setState(new Wait());
        gadget1.doAction();
    }
}
