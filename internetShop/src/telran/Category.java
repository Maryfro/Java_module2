package telran;

import java.util.Arrays;

public class Category {
    private String name;
    private Product[] products;

    public Category(String name, Product[] products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public static void displayProductsByCategory(Category category) {
        System.out.println("Category: " + category.getName());
        for (Product p : category.products) {
            System.out.println(p);
        }
    }

    public static void displayCategories(String[] categoryNames){
        System.out.println("Available categories: ");
        for (String name: categoryNames) {
            System.out.println(name);
        }
    }

    @Override
    public String toString() {
        return "Category: " +
                name + ", " + '\n' + "products " + Arrays.toString(products);
    }
}


