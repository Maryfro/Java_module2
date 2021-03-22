package telran.decorator;

public class CoffeeImplementation implements Coffee {
    private static final int BASIC_COFFEE_PRICE = 50;

    @Override
    public int getPrice() {
        System.out.println("Price for Coffee is: " + BASIC_COFFEE_PRICE);
        return BASIC_COFFEE_PRICE;
    }
}
