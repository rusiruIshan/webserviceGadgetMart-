package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru
 */
@Data
public class ProductCategory {
    private long id;
    private String name;
    private String createUser;
    private String status;
    private String categoryImage;
}
