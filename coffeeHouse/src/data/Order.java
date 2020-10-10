package data;

import java.util.Arrays;
import java.util.Objects;

public class Order {
    private static int id = 10100;
    private int idOrder;
    private Menu[] menu;
    private int size;
    private String clientsName;

    {
        idOrder = ++id;
    }

    public Menu[] getMenu() {
        return menu;
    }

    public int getSize() {
        return size;
    }

    public Order(int capacity, String clientsName) {
        menu = new Menu[capacity];
        size = 0;
        this.clientsName = clientsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder &&
                size == order.size &&
                Arrays.equals(menu, order.menu) &&
                clientsName.equals(order.clientsName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idOrder, size, clientsName);
        result = 31 * result + Arrays.hashCode(menu);
        return result;
    }

    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += menu[i].priceForMenuItem();
        }
        return total;
    }

    public boolean addMenuItemToOrder(Menu item) {
        if (size < menu.length) {
            menu[size] = item;
            size++;
            return true;
        } else {
            removeItemFromOrder(item);
        }
        return false;
    }

    public boolean removeItemFromOrder(Menu item) {
        for (int i = 0; i < size; i++) {
            if (menu[i].nameOfMenuItem().equals(item.nameOfMenuItem())) {
                menu[i] = menu[size - 1];
                size--;
                return true;
            }
        }
        System.out.println("Item was not found and cannot be removed");
        return false;
    }


    public void displayOrder() {
        System.out.println("Order " + idOrder + ": " +
                " client: " + clientsName);
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ". " + menu[i]);
        }
        System.out.println("Total: " + totalPrice());
        System.out.println("----------------");
    }


}
