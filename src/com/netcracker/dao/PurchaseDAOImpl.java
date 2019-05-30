package com.netcracker.dao;


import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.text.DateFormatSymbols;
import java.util.*;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BaseDAO implements PurchaseDAO {
    public void savePurchase(Purchase purchase) {
        persist(purchase);
    }

    public List<Purchase> findAllPurchases() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list();
    }

    public Purchase findPurchaseById(int id) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id",id));
        return (Purchase) criteria.uniqueResult();
    }

    public void deletePurchaseById(int id) {
        Query query = getSession().createQuery("delete from purchases where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public void update(String expression) {
        Query query = getSession().createQuery("update purchases set :expr");
        query.setString("expr",expression);
        query.executeUpdate();
    }

    public int getSizeOfTable() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list().size();
    }

    public void getPurchasesDates(){
        List results = getSession().createCriteria(Purchase.class).setProjection( Projections.projectionList()
                .add( Projections.distinct(Projections.property("purchaseDate")) )
        )
                .list();
        Set<String> months = new HashSet<String>();
        for(Object result: results){
            months.add(new DateFormatSymbols().getShortMonths()[Integer.parseInt(result.toString().split("-")[1])-1]);
        }
        for (String month: months){
            System.out.println(month);
        }
    }

    public List makeQuery(String expression) {
        Query query = getSession().createQuery(expression);
        query.setResultTransformer(new AliasToBeanResultTransformer(Purchase.class));
        return query.list();
    }
}
