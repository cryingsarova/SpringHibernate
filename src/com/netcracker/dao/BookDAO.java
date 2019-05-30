package com.netcracker.dao;

import com.netcracker.model.Book;

import java.util.List;

public interface BookDAO {

    void saveBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteBookById(int id);
    void update(Float price,String title);
    int getSizeOfTable();
    void getTitles();
    void getPrices();
    List makeQuery(String expression);

}
