package com.assignment.gadgetmart.connector;

import com.assignment.gadgetmart.domain.dto.Product;

import java.util.List;

/**
 * @author Rusiru
 */
public interface Connector {
    
    List<Product> getAbanceAllProduct();
    List<Product> getSoftLogicAllProduct();
    List<Product> getSingerAllProduct();
    
}
