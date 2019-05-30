package com.netcracker.service;

import com.netcracker.dao.ShopDAO;
import com.netcracker.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    public void saveShop(Shop shop) {
       shopDAO.saveShop(shop);
    }

    public List<Shop> findAllShops() {
       return shopDAO.findAllShops();
    }

    public Shop findShopById(int id) {
        return shopDAO.findShopById(id);
    }

    public void deleteShopById(int id) {
        shopDAO.deleteShopById(id);
    }

    public List makeQuery(String expression){ return shopDAO.makeQuery(expression);}
}
