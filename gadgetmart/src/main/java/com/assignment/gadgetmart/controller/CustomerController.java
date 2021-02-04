package com.assignment.gadgetmart.controller;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rusiru
 */
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/register-customer")
    public int registerCustomer(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }
    
    @PutMapping("/updated-customer")
    public int updatedCustomer(@RequestBody Customer customer){
        return customerService.updatedCustomer(customer);
    }
    
    @GetMapping("/get-customer")
    public Customer getCustomer(@PathVariable String email){
        return customerService.getCustomer(email);
    }
}
