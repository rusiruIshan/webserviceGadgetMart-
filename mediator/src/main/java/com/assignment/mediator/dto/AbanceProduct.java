package com.assignment.mediator.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Rusiru on 2/2/2021 9:26 PM
 */
@Data
public class AbanceProduct {
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
