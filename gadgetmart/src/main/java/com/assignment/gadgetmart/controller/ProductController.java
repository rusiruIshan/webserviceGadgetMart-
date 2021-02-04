package com.assignment.gadgetmart.controller;



import com.assignment.gadgetmart.domain.dto.Product;
import com.assignment.gadgetmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rusiru
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/product-list")
    public List<Product> getProductList(){
        return productService.getProductList();
    }
    
    @GetMapping("/products-by-category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable String categoryId){
        return productService.getProductsByCategory(categoryId);
    }
    
}
