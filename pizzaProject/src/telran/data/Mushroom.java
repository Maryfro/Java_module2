package telran.data;

public class Mushroom extends Extras{
    private final static double PRICE_FOR_MUSHROOMS = 1.5;

    public Mushroom(PizzaBase pizzaBase) {
        super(pizzaBase);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE_FOR_MUSHROOMS;
    }

}
