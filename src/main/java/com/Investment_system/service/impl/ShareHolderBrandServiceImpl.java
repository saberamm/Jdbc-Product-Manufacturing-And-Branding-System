package com.Investment_system.service.impl;

import com.Investment_system.repository.ShareHolderBrandRepository;
import com.Investment_system.service.ShareHolderBrandService;

public class ShareHolderBrandServiceImpl implements ShareHolderBrandService {
    ShareHolderBrandRepository shareHolderBrandRepository;

    public ShareHolderBrandServiceImpl(ShareHolderBrandRepository shareHolderBrandRepository) {
        this.shareHolderBrandRepository = shareHolderBrandRepository;
    }

    @Override
    public void add(int shareholderId, int brandId) {
        shareHolderBrandRepository.add(shareholderId, brandId);
    }

    @Override
    public void delete(int id) {
        shareHolderBrandRepository.delete(id);
    }
}
