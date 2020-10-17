package telran.data;

public class BasicPizza implements PizzaBase {
    String base = "pizza base";
    String sauce = "tomato sauce";
    double basicPrice = 3;

    public String getBase() {
        return base;
    }

    public String getSauce() {
        return sauce;
    }

    @Override
    public double getPrice() {
        return basicPrice;
    }
}
