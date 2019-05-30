package com.netcracker.service;

import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);
    List <Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
    void getCustomersAreas();
    List makeQuery(String expression);
}
