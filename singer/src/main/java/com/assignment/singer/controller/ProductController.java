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
@RequestMapping("/singer/product")
public class ProductController {
    
    
    
    @GetMapping("/product-list")
    public List<SingerProduct> getProductList(){
        
        List<SingerProduct> abanceProducts = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            SingerProduct abanceProduct = new SingerProduct();
            abanceProduct.setDescription("test");
            abanceProduct.setId("si"+ i);
            abanceProduct.setName("Singer Item 0"+ (i+1));
            abanceProduct.setProduct_category(new ProductCategory("123", "test", null, "ok", "test"));
            abanceProduct.setProductImageList(new ArrayList<>());
            abanceProduct.setQtyOnHand(10);
            abanceProduct.setUnitPrice(125.00 * (i+1));
            abanceProducts.add(abanceProduct);
        }
        return abanceProducts;
    
    }
    
    
    
}
