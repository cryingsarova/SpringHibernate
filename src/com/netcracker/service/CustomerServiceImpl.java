package com.netcracker.service;

import com.netcracker.dao.CustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    public void deleteCustomerById(int id) {
        customerDAO.deleteCustomerById(id);
    }
    public void getCustomersAreas(){ customerDAO.getCustomersAreas();}
    public List makeQuery(String expression){return customerDAO.makeQuery(expression);}
}
