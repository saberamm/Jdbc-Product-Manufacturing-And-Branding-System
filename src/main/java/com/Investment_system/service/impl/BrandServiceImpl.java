package com.Investment_system.service.impl;

import com.Investment_system.model.Brand;
import com.Investment_system.repository.BrandRepository;
import com.Investment_system.service.BrandService;

public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(Brand brand) {
        if (isBrandExist(brand.getName())) {
            System.out.println("Error : brand Name is NOT Available!");
        } else {
            brandRepository.add(brand);
        }
    }

    @Override
    public void delete(int id) {
        brandRepository.delete(id);
    }

    @Override
    public Brand load(int id) {
        return brandRepository.load(id);
    }

    @Override
    public Brand[] loadAll() {
        return brandRepository.loadAll();
    }

    @Override
    public int rowCounter() {
        return brandRepository.rowCounter();
    }

    @Override
    public void update(Brand brand, int id) {
        brandRepository.update(brand, id);
    }

    @Override
    public boolean isBrandExist(String name) {
        return brandRepository.isBrandExist(name);
    }

    @Override
    public boolean isAnyBrandExist() {
        return brandRepository.isAnyBrandExist();
    }
}
