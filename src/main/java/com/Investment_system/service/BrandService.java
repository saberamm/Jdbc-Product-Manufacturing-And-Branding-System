package com.Investment_system.service;

import com.Investment_system.model.Brand;

public interface BrandService {
    void add(Brand brand);
    void delete(int id);
    Brand load(int id);
    Brand[] loadAll();
    int rowCounter();
    void update(Brand brand,int id);
    boolean isBrandExist();
    boolean isAnyBrandExist();
}
