package com.assignment.singer.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Rusiru
 */
@Data
public class SingerProduct {
    private long id;
    private String name;
    private String description;
    private long qtyOnHand;
    private double unitPrice;
    private String create_user_id;
    private ProductCategory product_category;
    private List<ProductImage> productImageList;
}
