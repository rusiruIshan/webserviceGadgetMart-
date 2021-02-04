package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @author Rusiru
 */
@Data
public class Order {
    private int orderId;
    private Date date;
    private double amount;
    private Customer customer;
    private String status;
    private List<OrderDetail> orderDetail;
}
