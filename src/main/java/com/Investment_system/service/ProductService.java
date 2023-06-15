package com.Investment_system.service;

import com.Investment_system.model.Product;

public interface ProductService {
    void add(Product product);

    void delete(int id);

    void update(Product product, int id);
}
