package telran;

public class Product {

        private String name;
        private double price;
        private double ranking;

        public Product(String name, double price, double ranking) {
            this.name = name;
            this.price = price;
            this.ranking = ranking;
        }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name +
                ", price: " + price +
                ", ranking: " + ranking;
    }
}

