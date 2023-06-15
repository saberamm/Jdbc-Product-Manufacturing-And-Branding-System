package com.Investment_system.repository;

import com.Investment_system.model.Brand;

public interface BrandRepository {
    void add(Brand brand);

    void delete(int id);

    Brand load(int id);

    Brand[] loadAll();

    int rowCounter();

    void update(Brand brand, int id);

    boolean isBrandExist(String name);

    boolean isAnyBrandExist();
}
