package telran.controller;

import telran.decorator.Coffee;
import telran.decorator.CoffeeImplementation;
import telran.decorator.MilkDecorator;
import telran.decorator.SugarDecorator;

public class App {
    public static void main(String[] args) {
        Coffee coffee1 = new CoffeeImplementation();
        coffee1.getPrice();
        Coffee coffee2 = new MilkDecorator(coffee1);
        System.out.println("-----------------");
        coffee2.getPrice();
        System.out.println("-----------------");
        Coffee coffee3 = new MilkDecorator(new SugarDecorator(new CoffeeImplementation()));
        coffee3.getPrice();
    }

}
