package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Shop;
import com.netcracker.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import java.text.DateFormatSymbols;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context =
                 new AnnotationConfigApplicationContext(SpringConfig.class);

        ShopService shopService = (ShopService) context.getBean("shopService");
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        BookService bookService = (BookService) context.getBean("bookService");
        PurchaseService purchaseService = (PurchaseService) context.getBean("purchaseService");

        System.out.println("------------Задание 1-------------");//примеры операций

        bookService.saveBook(new Book("Унесенные ветром",680.00f,"Сормовский",20));
        bookService.update(670.00f,"Унесенные вeтром");
        bookService.deleteBookById(bookService.findAllBooks().size());
        List<Shop> shopList = shopService.findAllShops();
        List<Customer> customerList = customerService.findAllCustomers();
        for(int i =0 ; i< shopList.size();i++){
            System.out.println(shopList.get(i));
        }
        for(int i =0 ; i< customerList.size();i++){
            System.out.println(customerList.get(i));
        }

        System.out.println("------------Задание 2-------------");
        bookService.getTitles();
        customerService.getCustomersAreas();
        purchaseService.getPurchasesMonths();

        System.out.println("------------Задание 3-------------");

        List results = customerService.makeQuery("SELECT name as name, sale as sale FROM Customer WHERE livingArea = 'Нижегородский'");
        for(int i = 0; i < results.size(); i++){
            Customer customer = (Customer)results.get(i);
            System.out.println(customer.getName()+" "+customer.getSale());
        }

        results = shopService.makeQuery("SELECT name as name FROM Shop WHERE (locationArea = 'Сормовский') OR (locationArea = 'Советский')");
        for(int i = 0; i < results.size(); i++){
            Shop shop = (Shop)results.get(i);
            System.out.println(shop.getName());
        }

        results = bookService.makeQuery("SELECT title as title, price as price FROM Book  WHERE (title LIKE '%Windows%') OR (price > 20000) " +
                "ORDER BY title ASC, price DESC");
        for(int i = 0; i < results.size(); i++){
            Book book = (Book)results.get(i);
            System.out.println(book.getTitle()+", price = "+book.getPrice());
        }

        results = purchaseService.makeQuery("SELECT P.customer as customer, P.shop as shop FROM Purchase P");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getCustomer().getName() +" "+ purchase.getShop().getLocationArea());
        }

        results = purchaseService.makeQuery("SELECT P.purchaseDate as purchaseDate, P.customer as customer," +
                " P.book as book, P.quantity as quantity FROM Purchase P");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getPurchaseDate() + " " + purchase.getCustomer().getName()+ " " + purchase.getCustomer().getSale() +
                   " " + purchase.getBook().getTitle() + " " + purchase.getQuantity());
        }

        results = purchaseService.makeQuery("SELECT P.orderNumber as orderNumber,P.purchaseDate as purchaseDate,P.customer as customer FROM Purchase P " +
                "WHERE (P.quantity * (SELECT b.price FROM Book b WHERE b = P.book))>600");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getOrderNumber()+" "+purchase.getPurchaseDate()+" "+purchase.getCustomer().getName());
        }

        results = purchaseService.makeQuery("select P.customer as customer, P.shop as shop, P.purchaseDate as purchaseDate from Purchase P, Shop as S, Customer as C" +
                " where S.locationArea = C.livingArea and P.customer.id = C.id and P.shop.id = S.id and P.purchaseDate<'20190301' order by P.purchaseDate");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getCustomer().getName()+" "+purchase.getShop().getLocationArea()+" "+purchase.getPurchaseDate());
        }

        results = purchaseService.makeQuery("select distinct P.shop as shop from Purchase P, Shop S, Customer C" +
                " where S.locationArea != 'Автозавсдский' and P.customer.sale > 0.1 and P.customer.sale < 0.15");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getShop().getName()+" "+purchase.getShop().getLocationArea());
        }

        results = purchaseService.makeQuery("select distinct P.shop as shop from Purchase P" +
                " where P.shop.locationArea = P.book.warehouse and P.book.quantity > 10");
        for(int i = 0; i < results.size(); i++){
            Purchase purchase = (Purchase)results.get(i);
            System.out.println(purchase.getShop().getName());
        }

    }
}
