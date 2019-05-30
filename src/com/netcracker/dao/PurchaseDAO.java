package com.netcracker.dao;

import com.netcracker.model.Purchase;


import java.util.List;

public interface PurchaseDAO {

    void savePurchase(Purchase purchase);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    void deletePurchaseById(int id);
    void update(String expression);
    int getSizeOfTable();
    void getPurchasesDates();
    List makeQuery(String expression);
}
