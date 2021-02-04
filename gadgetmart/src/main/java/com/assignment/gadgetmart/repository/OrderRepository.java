package com.assignment.gadgetmart.repository;

import com.assignment.gadgetmart.domain.dto.Order;

import java.util.List;

/**
 * @author Rusiru
 */
public interface OrderRepository {
    
    Order placeOrder(Order order);
    List<Order> getAllOrders(String email);
}
