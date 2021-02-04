package com.assignment.gadgetmart.service;

import com.assignment.gadgetmart.domain.dto.Order;

import java.util.List;

/**
 * @author Rusiru
 */
public interface OrderServer {
    Order placeOrder(Order order);
    List<Order> getAllOrders(String email);
}
