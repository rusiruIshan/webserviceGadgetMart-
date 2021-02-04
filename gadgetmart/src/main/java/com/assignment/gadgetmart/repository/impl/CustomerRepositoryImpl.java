package com.assignment.gadgetmart.repository.impl;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rusiru
 */

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public int registerCustomer(Customer customer) {
            Map<String, Object> param = new HashMap<>();
            param.put("customerId", customer.getCustomerId());
            param.put("name", customer.getName());
            param.put("address", customer.getAddress());
            param.put("email", customer.getEmail());
        
            String sql = "INSERT INTO `supervis_shopping_cart`.`customer_cart` (`product_id`, `customer_id`, `qty`, `status_id`) VALUES (:product_id, :customer_id, :qty, 1)";
            return namedParameterJdbcTemplate.update(sql, param);
    }
    
    @Override
    public int updatedCustomer(Customer customer) {
        Map<String, Object> param = new HashMap<>();
        param.put("customerId", customer.getCustomerId());
        param.put("name", customer.getName());
        param.put("address", customer.getAddress());
        param.put("email", customer.getEmail());
    
        String sql = "INSERT INTO `supervis_shopping_cart`.`customer_cart` (`product_id`, `customer_id`, `qty`, `status_id`) VALUES (:product_id, :customer_id, :qty, 1)";
        return namedParameterJdbcTemplate.update(sql, param);
    }
    
    @Override
    public Customer getCustomer(String email) {
        String sql = "select * from customer where email = :email";
        return namedParameterJdbcTemplate.query(sql, Collections.singletonMap("email", email), (resultSet, rowNum) -> {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getString("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("create_user_id"));
            customer.setEmail(resultSet.getString("status_id"));
            return customer;
        }).get(0);
    }
}
