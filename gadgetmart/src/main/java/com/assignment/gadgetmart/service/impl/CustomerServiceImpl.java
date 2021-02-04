package com.assignment.gadgetmart.service.impl;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.repository.CustomerRepository;
import com.assignment.gadgetmart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rusiru
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public int registerCustomer(Customer customer) {
        return customerRepository.registerCustomer(customer);
    }
    
    @Override
    public int updatedCustomer(Customer customer) {
        return customerRepository.updatedCustomer(customer);
    }
    
    @Override
    public Customer getCustomer(String email) {
        return customerRepository.getCustomer(email);
    }
}
