package com.Investment_system.service;

import com.Investment_system.model.Category;

public interface CategoryService {
    void add(Category category);
    void delete(int id);
    Category load(int id);
    Category[] loadAll();
    int rowCounter();
    void update(Category category,int id);
    boolean isCategoryExist(String name);
    boolean isAnyCategoryExist();
}
