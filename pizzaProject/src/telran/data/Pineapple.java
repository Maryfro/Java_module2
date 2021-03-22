package telran.data;

public class Pineapple extends Extras {
    private final static double PRICE_FOR_PINEAPPLES = 0.5;


    public Pineapple(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_PINEAPPLES;
    }
}
