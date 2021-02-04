package com.assignment.mediator.service.impl;


import com.assignment.mediator.connector.Connector;
import com.assignment.mediator.dto.Product;
import com.assignment.mediator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rusiru on 7/4/2020 10:55 PM
 */
@Service
public class ProductServiceImpl implements ProductService {

    
    
    @Autowired
    Connector connector;

    @Override
    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.addAll(connector.getAbanceAllProduct());
        products.addAll(connector.getSingerAllProduct());
        products.addAll(connector.getSoftLogicAllProduct());
        return products;
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
