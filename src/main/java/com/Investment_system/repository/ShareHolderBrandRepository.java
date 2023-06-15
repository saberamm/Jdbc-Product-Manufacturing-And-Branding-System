package com.Investment_system.repository;

public interface ShareHolderBrandRepository {
    void add(int shareholderId, int brandId);

    void delete(int id);
}
