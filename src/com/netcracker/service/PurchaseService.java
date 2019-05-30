package com.netcracker.service;

import com.netcracker.model.Purchase;

import java.util.List;

public interface PurchaseService {

    void savePurchase(Purchase purchase);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    void getPurchasesMonths();
    void deletePurchaseById(int id);
    List makeQuery(String expression);
}
