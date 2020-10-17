package telran.data;

public class Salami extends Extras {
    private final static double PRICE_FOR_SALAMI = 1.5;

    public Salami(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_SALAMI;
    }
}


