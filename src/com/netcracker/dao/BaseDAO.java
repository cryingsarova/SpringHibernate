package com.netcracker.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository ("baseDAO")
public class BaseDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object object){
        getSession().persist(object);
    }

    protected void delete(Object object){
        getSession().delete(object);
    }


}
