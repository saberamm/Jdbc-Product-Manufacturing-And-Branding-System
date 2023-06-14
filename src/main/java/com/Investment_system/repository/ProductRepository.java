package com.Investment_system.repository;

import com.Investment_system.model.Product;
import com.Investment_system.model.Shareholder;

public interface ProductRepository {
    void add(Product product);
    void delete(int id);
    void update(Product product,int id);

}
