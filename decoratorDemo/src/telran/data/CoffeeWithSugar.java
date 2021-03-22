package telran.data;

public class CoffeeWithSugar extends Coffee {
    private static final int SUGAR_PRICE = 10;

    @Override
    public int getPrice() {
        return super.getPrice() + SUGAR_PRICE;
    }
}
