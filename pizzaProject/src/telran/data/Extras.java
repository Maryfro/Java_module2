package telran.data;

public abstract class Extras implements PizzaBase {
    private PizzaBase pizzaBase;

    public Extras(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    @Override
    public double getPrice() {
        return pizzaBase.getPrice();
    }
}
