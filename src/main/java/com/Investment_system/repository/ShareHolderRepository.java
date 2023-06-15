package com.Investment_system.repository;

import com.Investment_system.model.Brand;
import com.Investment_system.model.Shareholder;

public interface ShareHolderRepository {

    void add(Shareholder shareholder);

    void delete(int id);

    Shareholder load(int id);

    Shareholder[] loadAll();

    int rowCounter();

    void update(Shareholder shareholder, int id);

    boolean isShareholderExist(String nationalCode);

    boolean isAnyShareholderExist();
}
