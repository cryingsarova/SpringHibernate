package com.netcracker.dao;

import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.xml.transform.Result;
import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BaseDAO implements BookDAO {
    public void saveBook(Book book) {
        persist(book);
    }

    public List<Book> findAllBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list();
    }

    public Book findBookById(int id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        return (Book) criteria.uniqueResult();
    }

    public void deleteBookById(int id) {
        Query query = getSession().createQuery("delete from Book where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    public void update(Float price, String title) {
        Query query = getSession().createQuery("update Book set price = :price where title = :title ");
        query.setString("title",title);
        query.setFloat("price",price);
        query.executeUpdate();
    }

    public int getSizeOfTable() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list().size();
    }

    public List makeQuery(String expression) {

        Query query = getSession().createQuery(expression);
        query.setResultTransformer(new AliasToBeanResultTransformer(Book.class));
        return query.list();

    }

    public void getTitles(){

        List results = getSession().createCriteria(Book.class).setProjection( Projections.projectionList()
                        .add( Projections.distinct(Projections.property("title")) )
                )
                .list();
        for(Object result: results){
            System.out.println(result);
        }
    }

    public void getPrices(){
        List results = getSession().createCriteria(Book.class).setProjection( Projections.projectionList()
                .add( Projections.distinct(Projections.property("price")) )
        )
                .list();
        for(Object result: results){
            System.out.println(result);
        }
    }
}
