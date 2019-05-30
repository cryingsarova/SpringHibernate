package com.netcracker.service;

import com.netcracker.dao.BookDAO;
import com.netcracker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDAO bookDAO;

    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    public List<Book> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    public Book findBookById(int id) {
        return bookDAO.findBookById(id);
    }

    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }

    public void update(Float price, String title){ bookDAO.update(price,title); }

    public void getTitles() { bookDAO.getTitles(); }

    public void getPrices() { bookDAO.getPrices();}

    public List makeQuery(String expression) {
        return bookDAO.makeQuery(expression);
    }
}
