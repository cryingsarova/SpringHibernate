package com.netcracker.dao;

import com.netcracker.model.Shop;

import java.util.List;

public interface ShopDAO {

    void saveShop(Shop shop);
    List<Shop> findAllShops();
    Shop findShopById (int id);
    void deleteShopById (int id);
    void update(String expression);
    int getSizeOfTable();
    List makeQuery(String expression);

}
