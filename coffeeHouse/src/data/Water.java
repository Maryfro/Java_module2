package data;

public class Water implements Menu{
    @Override
    public String nameOfMenuItem() {
        return "Water";
    }

    @Override
    public double priceForMenuItem() {
        return 1.5;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Water, " + "price: " + priceForMenuItem();
    }
}
