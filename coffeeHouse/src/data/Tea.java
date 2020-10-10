package data;

public class Tea implements Menu{
    @Override
    public String nameOfMenuItem() {
        return "Tea";
    }

    @Override
    public double priceForMenuItem() {
        return 2.5;
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
        return "Tea, " + "price: " + priceForMenuItem();
    }
}
