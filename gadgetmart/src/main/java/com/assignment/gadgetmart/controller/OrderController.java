package com.assignment.gadgetmart.controller;

import com.assignment.gadgetmart.domain.dto.Order;
import com.assignment.gadgetmart.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rusiru
 */
@RestController
@CrossOrigin
@RequestMapping("/Order")
public class OrderController {
    
    @Autowired
    private OrderServer orderServer;
    
    @PostMapping("/place-order")
    public Order placeOrder(@RequestBody Order order){
        return orderServer.placeOrder(order);
    }
    
    @GetMapping("/get-all-orders")
    public List<Order> getAllOrders(String email){
        return orderServer.getAllOrders(email);
    }

    @GetMapping("/get-all-orders-by-email/email")
    public List<Order> getAllOrdersByEmail(@PathVariable String email){
        return orderServer.getAllOrders(email);
    }
}
