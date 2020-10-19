package telran.controller;

import telran.data.*;

public class PizzaApp {
    public static void main(String[] args) {
        PizzaBase basicPizza = new BasicPizza();
        System.out.println("Price for basic pizza with " + ((BasicPizza) basicPizza).getBase() + " and "
                + ((BasicPizza) basicPizza).getSauce() + " is "
                + basicPizza.getPrice());
        PizzaBase hawaii = new Pineapple(new Ham(new BasicPizza()));
        System.out.println("Price for hawaii pizza is " + hawaii.getPrice());
        PizzaBase pepperoni = new Salami(new Mozzarella(new BasicPizza()));
        System.out.println("Price for pepperoni pizza is " + pepperoni.getPrice());
        PizzaBase margherita = new Basil(new Mozzarella(new BasicPizza()));
        System.out.println("Price for margherita pizza is " + margherita.getPrice());
        PizzaBase funghi = new Mushroom(new BasicPizza());
        System.out.println("Price for funghi pizza is " + funghi.getPrice());

    }
}
