package com.Investment_system.repository;

import com.Investment_system.model.Brand;
import com.Investment_system.model.Category;

public interface CategoryRepository {
    void add(Category category);
    void delete(int id);
    Category load(int id);
    Category[] loadAll();
    int rowCounter();
    void update(Category category,int id);
    boolean isCategoryExist();
    boolean isAnyCategoryExist();
}
