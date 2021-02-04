package com.assignment.singer.controller;


import com.assignment.singer.dto.ProductCategory;
import com.assignment.singer.dto.SingerProduct;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rusiru
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    
    
    
    @GetMapping("/product-list")
    public List<SingerProduct> getProductList(){
        
        List<SingerProduct> abanceProducts = new ArrayList<>();
        SingerProduct abanceProduct = new SingerProduct();
        abanceProduct.setDescription("test");
        abanceProduct.setId(1234);
        abanceProduct.setName("test123");
        abanceProduct.setProduct_category(new ProductCategory(123,"test", null, "ok", "test"));
        abanceProduct.setProductImageList(new ArrayList<>());
        abanceProduct.setQtyOnHand(10);
        abanceProduct.setUnitPrice(25.00);
        abanceProducts.add(abanceProduct);
        
        return abanceProducts;
    
    }
    
    
    
}