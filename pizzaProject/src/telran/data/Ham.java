package telran.data;

public class Ham extends Extras {
    private final static double PRICE_FOR_HAM = 2;

    public Ham(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_HAM;
    }
}
