package com.Investment_system.service.impl;

import com.Investment_system.model.Shareholder;
import com.Investment_system.repository.ShareHolderRepository;
import com.Investment_system.service.ShareHolderService;

public class ShareHolderServiceImpl implements ShareHolderService {
    ShareHolderRepository shareHolderRepository;

    public ShareHolderServiceImpl(ShareHolderRepository shareHolderRepository) {
        this.shareHolderRepository = shareHolderRepository;
    }

    @Override
    public void add(Shareholder shareholder) {
        if (isShareholderExist(shareholder.getNational_code())) {
            System.out.println("Error : shareholder nationalCode is NOT Available!");
        } else {
            shareHolderRepository.add(shareholder);
        }
    }

    @Override
    public void delete(int id) {
        shareHolderRepository.delete(id);
    }

    @Override
    public Shareholder load(int id) {
        return shareHolderRepository.load(id);
    }

    @Override
    public Shareholder[] loadAll() {
        return shareHolderRepository.loadAll();
    }

    @Override
    public int rowCounter() {
        return shareHolderRepository.rowCounter();
    }

    @Override
    public void update(Shareholder shareholder, int id) {
        shareHolderRepository.update(shareholder, id);
    }

    @Override
    public boolean isShareholderExist(String nationalCode) {
        return shareHolderRepository.isShareholderExist(nationalCode);
    }

    @Override
    public boolean isAnyShareholderExist() {
        return shareHolderRepository.isAnyShareholderExist();
    }
}
