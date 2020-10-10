package controller;

import data.*;

public class CoffeeHouseApp {
    public static void main(String[] args) {
        Order order1 = new Order(5, "John");
        Order order2 = new Order(5, "Sam");
        Order order3 = new Order(5, "Anna");
        order1.addMenuItemToOrder(new Coffee());
        order1.addMenuItemToOrder(new Water());
        order1.displayOrder();
        order2.addMenuItemToOrder(new Tea());
        order2.displayOrder();
        order3.addMenuItemToOrder(new Water());
        order3.addMenuItemToOrder(new Tea());
        order3.addMenuItemToOrder(new Coffee());
        order3.addMenuItemToOrder(new Coffee());
        order3.addMenuItemToOrder(new Coffee());
        order3.removeItemFromOrder(new Tea());
        order3.addMenuItemToOrder(new Coffee());
        order3.addMenuItemToOrder(new Coffee());
        order3.addMenuItemToOrder(new Coffee());
        order3.displayOrder();

    }
}
