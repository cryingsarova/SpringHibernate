package com.netcracker.dao;

import com.netcracker.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BaseDAO implements ShopDAO {


    public void saveShop(Shop shop) {
        persist(shop);
    }

    public List<Shop> findAllShops() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        return criteria.list();
    }

    public Shop findShopById(int id) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("id", id));
        return (Shop) criteria.uniqueResult();
    }

    public void deleteShopById(int id) {

        Query query = getSession().createQuery("delete from Shops where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public void update(String expression) {
        Query query = getSession().createQuery("update shops set :expr");
        query.setString("expr",expression);
        query.executeUpdate();
    }

    public int getSizeOfTable() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        return criteria.list().size();
    }

    public List makeQuery(String expression) {
        Query query = getSession().createQuery(expression);
        query.setResultTransformer(new AliasToBeanResultTransformer(Shop.class));
        return query.list();
    }
}
