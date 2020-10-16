package telran.decorator;

public abstract class AbstractDecorator implements Coffee {
    private Coffee coffee;

    public AbstractDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getPrice() {
        return coffee.getPrice();
    }
}
