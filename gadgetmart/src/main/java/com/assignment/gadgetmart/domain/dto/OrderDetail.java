package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru
 */
@Data
public class OrderDetail {
    private int orderDetailId;
    private Product product;
    private String qty;
    private double amount;
}
