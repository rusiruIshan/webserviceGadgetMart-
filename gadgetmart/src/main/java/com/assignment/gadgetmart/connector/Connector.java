package com.assignment.gadgetmart.connector;

import com.assignment.gadgetmart.domain.dto.Product;

import java.util.List;

/**
 * @author Rusiru on 2/2/2021 8:51 PM
 */
public interface Connector {
    
    List<Product> getAbanceAllProduct();
    List<Product> getSoftLogicAllProduct();
    List<Product> getSingerAllProduct();
    
}
