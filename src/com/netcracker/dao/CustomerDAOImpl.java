package com.netcracker.dao;

import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public Customer findCustomerById(int id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        return (Customer) criteria.uniqueResult();
    }

    public void deleteCustomerById(int id) {
        Query query = getSession().createQuery("delete from customers where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public void update(String expression) {
        Query query = getSession().createQuery("update customers set :expr");
        query.setString("expr",expression);
        query.executeUpdate();
    }

    public int getSizeOfTable() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list().size();
    }

    public void getCustomersAreas(){
        List results = getSession().createCriteria(Customer.class).setProjection( Projections.projectionList()
                .add( Projections.distinct(Projections.property("livingArea")) )
        )
                .list();
        for(Object result: results){
            System.out.println(result);
        }
    }

    public List makeQuery(String expression) {
        Query query = getSession().createQuery(expression);
        query.setResultTransformer(new AliasToBeanResultTransformer(Customer.class));
        return query.list();
    }
}
