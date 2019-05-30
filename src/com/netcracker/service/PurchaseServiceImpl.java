package com.netcracker.service;

import com.netcracker.dao.PurchaseDAO;
import com.netcracker.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;

    public void savePurchase(Purchase purchase) {
        purchaseDAO.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseDAO.findAllPurchases();
    }

    public Purchase findPurchaseById(int id) {
        return purchaseDAO.findPurchaseById(id);
    }

    public void getPurchasesMonths() {purchaseDAO.getPurchasesDates();}

    public void deletePurchaseById(int id) {
        purchaseDAO.deletePurchaseById(id);
    }

    public List makeQuery(String expression){ return purchaseDAO.makeQuery(expression);}
}
