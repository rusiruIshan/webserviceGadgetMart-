package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru on 7/4/2020 8:59 PM
 */
@Data
public class ProductCategory {
    private long id;
    private String name;
    private String createUser;
    private String status;
    private String categoryImage;
}
