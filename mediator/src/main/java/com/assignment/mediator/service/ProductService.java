package com.assignment.mediator.service;


import com.assignment.mediator.dto.Product;

import java.util.List;

/**
 * @author Rusiru on 7/4/2020 10:55 PM
 */
public interface ProductService {
    
    List<Product> getProductList();
    List<Product> getProductsByCategory(String categoryId);
}
