package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru
 */
@Data
public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String email;
}
