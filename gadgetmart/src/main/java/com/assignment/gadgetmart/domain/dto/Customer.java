package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru on 2/3/2021 12:03 AM
 */
@Data
public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String email;
}
