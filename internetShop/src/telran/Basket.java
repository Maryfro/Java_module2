package telran;

public class Basket {
    private Product[] products;
    private int size = 0;

    public Basket(int capacity) {
        products = new Product[capacity];
    }

    public boolean addProductToBasket(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
            System.out.println(product.getName() + " was added to basket");
            return true;
        } else {
            System.out.println(product.getName() + " could not be added to basket");
            return false;
        }
    }

    public void buyProductFromBasket(Product product) {
        for (int i = 0; i < size; i++) {
            if (products[i].equals(product)) {
                products[i] = products[size - 1];
                size--;
                System.out.println("Thank you for your order, have fun with your new " + product.getName());
                break;
            } else {
                System.out.println("Unfortunately, your preferred product was not found, please add the product " +
                        "of your choice to the basket");
            }
        }
    }
}
