package telran.decorator;

public class SugarDecorator extends AbstractDecorator {
    private static final int SUGAR_PRICE = 5;

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getPrice() {
        int price = super.getPrice() + SUGAR_PRICE;
        System.out.println("Price for coffee with sugar: " + price);
        return price;
    }
}
