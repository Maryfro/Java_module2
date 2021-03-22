package telran.data;

public class Basil extends Extras {
    private final static double PRICE_FOR_BASIL = 0.5;

    public Basil(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_BASIL;
    }

}
