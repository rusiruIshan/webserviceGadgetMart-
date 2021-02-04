package com.assignment.gadgetmart.service.impl;

import com.assignment.gadgetmart.domain.dto.Order;
import com.assignment.gadgetmart.repository.OrderRepository;
import com.assignment.gadgetmart.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rusiru
 */
@Service
public class OrderServerImpl implements OrderServer {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public Order placeOrder(Order order) {
        return orderRepository.placeOrder(order);
    }
    
    @Override
    public List<Order> getAllOrders(String email) {
        return orderRepository.getAllOrders(email);
    }
}
