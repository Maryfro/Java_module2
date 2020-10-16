package telran.decorator;

public class MilkDecorator extends AbstractDecorator {
    private static final int MILK_PRICE = 10;

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        int price = super.getPrice() + MILK_PRICE;
        System.out.println("Price for coffee with milk: " + price);
        return price;
    }
}
