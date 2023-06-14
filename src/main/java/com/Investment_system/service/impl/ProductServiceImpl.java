package com.Investment_system.service.impl;

import com.Investment_system.model.Product;
import com.Investment_system.repository.ProductRepository;
import com.Investment_system.service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void update(Product product, int id) {
        productRepository.update(product, id);
    }
}
