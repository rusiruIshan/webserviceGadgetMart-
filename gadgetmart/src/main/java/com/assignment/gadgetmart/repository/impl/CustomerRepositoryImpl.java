package com.assignment.gadgetmart.repository.impl;

import com.assignment.gadgetmart.domain.dto.Customer;
import com.assignment.gadgetmart.domain.dto.User;
import com.assignment.gadgetmart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        
            String sql = "INSERT INTO `web-service-assignment-db`.`customer_cart` (`product_id`, `customer_id`, `qty`, `status_id`) VALUES (:product_id, :customer_id, :qty, 1)";
            return namedParameterJdbcTemplate.update(sql, param);
    }
    
    @Override
    public int updatedCustomer(Customer customer) {
        Map<String, Object> param = new HashMap<>();
        param.put("customerId", customer.getCustomerId());
        param.put("name", customer.getName());
        param.put("address", customer.getAddress());
        param.put("email", customer.getEmail());
    
        String sql = "INSERT INTO `web-service-assignment-db`.`customer_cart` (`product_id`, `customer_id`, `qty`, `status_id`) VALUES (:product_id, :customer_id, :qty, 1)";
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

    @Override
    public User loginUser(User user) {
        String sql = "SELECT * FROM `web-service-assignment-db`.customer where email = :email and password=:password";

        Map<String, String> map = new HashMap<>();
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());

        List<User> query = namedParameterJdbcTemplate.query(sql, map, (rs, index) -> {
            User userResponse = new User();
            userResponse.setUserId(rs.getInt("customerId"));
            userResponse.setUsername(rs.getString("name"));
            userResponse.setEmail(rs.getString("email"));
            return userResponse;
        });
        if (query.size() > 0){
            return query.get(0);
        }else{
            return new User();
        }
    }


}
