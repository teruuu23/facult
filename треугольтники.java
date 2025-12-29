import java.util.ArrayList;

public class Main {

    // Класс Product (Товар)
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " — " + price + " руб.";
        }
    }

    // Класс Cart (Корзина)
    static class Cart {
        private ArrayList<Product> products;

        public Cart() {
            products = new ArrayList<>();
        }

        // Добавить товар
        public void addProduct(Product p) {
            products.add(p);
        }

        // Удалить товар по названию
        public void removeProduct(String name) {
            boolean removed = false;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equalsIgnoreCase(name)) {
                    products.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                System.out.println("Удаляем: " + name);
            } else {
                System.out.println("Товар '" + name + "' не найден в корзине.");
            }
        }

        // Общая сумма
        public double getTotal() {
            double sum = 0;
            for (Product p : products) {
                sum += p.getPrice();
            }
            return sum;
        }

        // Печать корзины
        public void printCart() {
            System.out.println("=== Корзина ===");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.println("Итого: " + getTotal() + " руб.\n");
        }
    }

    // Главный метод
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Создаём товары
        Product laptop = new Product("Ноутбук", 75000.0);
        Product mouse = new Product("Мышка", 1500.0);
        Product keyboard = new Product("Клавиатура", 3000.0);

        // Добавляем товары в корзину
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);

        // Печатаем корзину
        cart.printCart();

        // Удаляем товар
        cart.removeProduct("Мышка");

        // Печатаем корзину снова
        cart.printCart();
    }
}
