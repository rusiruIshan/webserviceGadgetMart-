package com.assignment.gadgetmart.service;

import com.assignment.gadgetmart.domain.dto.Customer;

/**
 * @author Rusiru on 2/3/2021 12:27 PM
 */
public interface CustomerService {
    int registerCustomer(Customer customer);
    int updatedCustomer(Customer customer);
    Customer getCustomer(String email);
    
}
