package com.assignment.gadgetmart.service.impl;

import com.assignment.gadgetmart.connector.Connector;
import com.assignment.gadgetmart.domain.dto.Product;
import com.assignment.gadgetmart.repository.ProductRepository;
import com.assignment.gadgetmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rusiru
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    Connector connector;

    @Override
    public List<Product> getProductList() {
        return connector.getAllProduct();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        List<Product> productList = getProductList();
        List<Product> productListByCategory = getProductList();
        
        for (Product product: productList) {
            if(product.getProduct_category().getId() == Long.parseLong(categoryId)){
                productListByCategory.add(product);
            }
        }
        return productListByCategory;
    }
}
