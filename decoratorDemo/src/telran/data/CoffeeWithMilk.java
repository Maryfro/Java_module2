package telran.data;

public class CoffeeWithMilk extends Coffee {
    private static final int MILK_PRICE = 10;

    @Override
    public int getPrice() {
        return super.getPrice() + MILK_PRICE;
    }
}
