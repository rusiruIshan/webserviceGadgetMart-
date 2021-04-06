package com.assignment.gadgetmart.service;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.domain.dto.User;

/**
 * @author Rusiru
 */
public interface CustomerService {
    int registerCustomer(Customer customer);
    int updatedCustomer(Customer customer);
    Customer getCustomer(String email);
    public User loginUser(User data);
    
}
