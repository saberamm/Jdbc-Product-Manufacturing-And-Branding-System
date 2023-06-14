package com.Investment_system.service;

import com.Investment_system.model.Shareholder;

public interface ShareHolderService {
    void add(Shareholder shareholder);
    void delete(int id);
    Shareholder load(int id);
    Shareholder[] loadAll();
    int rowCounter();
    void update(Shareholder shareholder,int id);
    boolean isShareholderExist();
    boolean isAnyShareholderExist();
}
