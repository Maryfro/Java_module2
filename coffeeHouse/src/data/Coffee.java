package data;

public class Coffee implements Menu{
    @Override
    public String nameOfMenuItem() {
        return "Coffee";
    }

    @Override
    public double priceForMenuItem() {
        return 3.5;
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
        return "Coffee, " + "price: " + priceForMenuItem();
    }

}
