package com.assignment.gadgetmart.repository;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.domain.dto.User;

/**
 * @author Rusiru
 */
public interface CustomerRepository {
    
    int registerCustomer(Customer customer);
    int updatedCustomer(Customer customer);
    Customer getCustomer(String email);
    public User loginUser(User data);
}
