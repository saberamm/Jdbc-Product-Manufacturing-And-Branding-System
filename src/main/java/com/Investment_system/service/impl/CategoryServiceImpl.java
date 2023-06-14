package com.Investment_system.service.impl;

import com.Investment_system.model.Category;
import com.Investment_system.repository.CategoryRepository;
import com.Investment_system.repository.impl.CategoryRepositoryImpl;
import com.Investment_system.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(Category category) {
        if (isCategoryExist(category.getName())) {
            System.out.println("Error : brand Name is NOT Available!");
        } else {
            categoryRepository.add(category);
        }
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category load(int id) {
        return categoryRepository.load(id);
    }

    @Override
    public Category[] loadAll() {
        return categoryRepository.loadAll();
    }

    @Override
    public int rowCounter() {
        return categoryRepository.rowCounter();
    }

    @Override
    public void update(Category category, int id) {
        categoryRepository.update(category, id);
    }

    @Override
    public boolean isCategoryExist(String name) {
        return categoryRepository.isCategoryExist(name);
    }

    @Override
    public boolean isAnyCategoryExist() {
        return categoryRepository.isAnyCategoryExist();
    }
}
