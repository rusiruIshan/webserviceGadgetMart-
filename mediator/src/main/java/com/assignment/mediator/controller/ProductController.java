package com.assignment.mediator.controller;



import com.assignment.mediator.dto.Product;
import com.assignment.mediator.service.ProductService;
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
