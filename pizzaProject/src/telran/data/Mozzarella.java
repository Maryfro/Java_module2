package telran.data;

public class Mozzarella extends Extras{
    private final static double PRICE_FOR_MOZZARELLA = 0.5;

    public Mozzarella(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_MOZZARELLA;
    }
}
