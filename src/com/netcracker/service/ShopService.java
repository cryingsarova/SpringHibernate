package com.netcracker.service;

import com.netcracker.model.Shop;

import java.util.List;

public interface ShopService {

    void saveShop(Shop shop);

    List<Shop> findAllShops();

    Shop findShopById(int id);

    void deleteShopById(int id);

    List makeQuery(String expression);


}
