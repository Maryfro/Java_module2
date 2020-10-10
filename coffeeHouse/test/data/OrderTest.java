package data;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
    Order order1 = new Order(5, "John");

    {
        order1.addMenuItemToOrder(new Coffee());
        order1.addMenuItemToOrder(new Water());
    }


    @Test
    public void testTotalPrice() {
        Assert.assertEquals(5, order1.totalPrice(), 0.01);
    }

    @Test
    public void testAddMenuItemToOrderTrueCase() {
        assertTrue(order1.addMenuItemToOrder(new Coffee()));
    }

    @Test
    public void testAddMenuItemToOrderFalseCase() {
        order1.addMenuItemToOrder(new Tea());
        order1.addMenuItemToOrder(new Tea());
        order1.addMenuItemToOrder(new Tea());
        assertFalse(order1.addMenuItemToOrder(new Coffee()));
    }

    @Test
    public void checkSizeOfOrderByAddingMenuItem() {
        order1.addMenuItemToOrder(new Tea());
        assertEquals(3, order1.getSize());
    }

    @Test
    public void checkOrderByAddingMenuItem() {
        assertEquals("Water", order1.getMenu()[1].nameOfMenuItem());
    }

    @Test
    public void testRemoveItemFromOrderTrueCase() {
        assertTrue(order1.removeItemFromOrder(new Coffee()));
    }

    @Test
    public void testRemoveItemFromOrderFalseCase() {
        assertFalse(order1.removeItemFromOrder(new Tea()));
    }

    @Test
    public void checkSizeOfOrderByRemovingMenuItem() {
        order1.removeItemFromOrder(new Water());
        assertEquals(1, order1.getSize());
    }

    @Test
    public void checkOrderByRemovingMenuItem() {
        order1.removeItemFromOrder(new Water());
        assertEquals("Coffee", order1.getMenu()[0].nameOfMenuItem());
    }

    @Test
    public void testRemoveItemFromOrderByEmptyOrder() {
        order1.removeItemFromOrder(new Water());
        order1.removeItemFromOrder(new Coffee());
        assertFalse(order1.removeItemFromOrder(new Coffee()));
    }

}
