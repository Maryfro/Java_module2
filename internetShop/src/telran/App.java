package telran;

public class App {
    public static void main(String[] args) {
        Product teddy = new Product("teddy", 9.99, 4.5);
        Product barbie = new Product("barbie", 12.99, 4.8);
        Category toys = new Category("toys", new Product[]{teddy, barbie});
        Category furniture = new Category("furniture", new Product[]
                {new Product("chair", 100, 5.0), new Product("couch", 555, 3.9)});
        Category clothes = new Category("clothes", new Product[]
                {new Product("sweater", 30, 4.3), new Product("jeans", 57.99, 4.0)});
        User user1 = new User("user1", "password", new Basket(10));
        User user2 = new User("user2", "123", new Basket(10));
        // аутентификация пользователя. Пользователь вводит логин-пароль с клавиатуры.
        //  user1.checkLogin();
        //user2.checkPassword();
        System.out.println("-----------------");
        // просмотр списка товаров определенного каталога
         Category.displayProductsByCategory(toys);
         Category.displayProductsByCategory(furniture);
        System.out.println("-----------------");
          // просмотр списка каталогов товаров
        String[] categories = {toys.getName(), furniture.getName(), clothes.getName()};
        Category.displayCategories(categories);
        System.out.println("-----------------");
        // выбор товара в корзину
        user2.basket.addProductToBasket(teddy);
        user1.basket.addProductToBasket(barbie);
        System.out.println("-----------------");
        //покупка товаров, находящихся в корзине.
        user2.basket.buyProductFromBasket(teddy);
        user1.basket.buyProductFromBasket(teddy);
    }
}
