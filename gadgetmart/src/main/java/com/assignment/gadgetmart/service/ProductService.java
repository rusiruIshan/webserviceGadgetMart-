package com.assignment.gadgetmart.service;

import com.assignment.gadgetmart.domain.dto.Product;

import java.util.List;

/**
 * @author Rusiru
 */
public interface ProductService {
    
    List<Product> getProductList();
    List<Product> getProductsByCategory(String categoryId);
}
