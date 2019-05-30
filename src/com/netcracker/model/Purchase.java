package com.netcracker.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "purchases")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @JoinColumn(name="shop_id")
    @ManyToOne(targetEntity=Shop.class,fetch=FetchType.LAZY)
    private Shop shop;

    @JoinColumn(name="customer_id")
    @ManyToOne(targetEntity=Customer.class,fetch=FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name="book_id")
    @ManyToOne(targetEntity=Book.class,fetch=FetchType.LAZY)
    private Book book;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public Purchase() {
    }

    public Purchase(Date purchaseDate, Shop shop, Customer customer, Book book, int quantity) {
        this.purchaseDate = purchaseDate;
        this.shop = shop;
        this.customer = customer;
        this.book = book;
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
