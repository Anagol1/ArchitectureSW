package org.example.agregator;

import org.example.cashe.ProductCache;

import org.example.repository.ProductRepository;
import org.example.repository.SQLiteProductRepository;

import java.util.List;

import static org.example.cashe.ProductCache.createProductList;

public class Main {
    public static void main(String[] args) {
        // Создание и инициализация продукта.
        Product dress = new Product(1, "Dress", 25.0);

// Создание нового заказа.
        Order order = new Order();

// Добавление продукта в заказ.
        OrderItem orderItem = new OrderItem(dress, 2);
        order.addItem(orderItem);
        System.out.println(orderItem);
        System.out.println("Заказ " + order + " стоимостью " + order.getTotalPrice());


        String connectionString = "jdbc:sqlite:products.db";
        ProductRepository productRepository = new SQLiteProductRepository(connectionString);
        // Добавляем продукт в базу данных
        productRepository.add(dress);

        // Получаем продукт по ID
        Product retrievedProduct = productRepository.getById(1);
        if (retrievedProduct != null) {
            System.out.println("Получен продукт: " + retrievedProduct.getName());
        }

        // Получаем все продукты
        List<Product> allProducts = productRepository.getAll();
        for (Product product : allProducts) {
            System.out.println("Продукт: " + product.getName());
        }

        // Создание списка продуктов
        List<Product> productList = createProductList();

// Создание кэша для продуктов
        ProductCache productCache = new ProductCache();

// Запрос продукта по ID
        int productId = 1;
        Product product = productCache.getProduct(productId, productList);
        System.out.println("Product from cache or list: " + product);

// Обновление цены продукта
        product.setPrice(15.99);
        productCache.updateProduct(product, productList);

// Запрос обновленного продукта по тому же ID
        product = productCache.getProduct(productId, productList);
        System.out.println("Updated product from cache or list: " + product);


    }
}






