package com.netcracker.dao;


import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerDAO {

    void saveCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById (int id);
    void deleteCustomerById (int id);
    void update(String expression);
    int getSizeOfTable();
    void getCustomersAreas();
    List makeQuery(String expression);

}
