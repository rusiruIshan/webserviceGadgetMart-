package com.assignment.mediator.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Rusiru on 7/4/2020 9:46 PM
 */
@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private long qtyOnHand;
    private double unitPrice;
    private String create_user_id;
    private String statusId;
    private ProductCategory product_category;
    private List<ProductImage> productImageList;
   
}
