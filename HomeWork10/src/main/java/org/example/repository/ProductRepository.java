package org.example.repository;

import org.example.agregator.Product;

import java.util.List;

/**
 * Интерфес OrderRepository определяет методы для работы с товарами.
 */

public interface ProductRepository {
    Product getById(int id);
    List<Product> getAll();
    void add(Product product);
    void update(Product product);
    void delete(int id);

    void createTable();
}