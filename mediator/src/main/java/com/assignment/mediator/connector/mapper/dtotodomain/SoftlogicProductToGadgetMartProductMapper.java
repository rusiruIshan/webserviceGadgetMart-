package com.assignment.mediator.connector.mapper.dtotodomain;

import com.assignment.mediator.dto.Product;
import com.assignment.mediator.dto.SoftlogicProduct;
import org.modelmapper.AbstractConverter;
import org.modelmapper.spi.MappingContext;

import java.util.List;

/**
 * @author Rusiru
 */
public class SoftlogicProductToGadgetMartProductMapper extends AbstractConverter<SoftlogicProduct, Product> {
    
    
    @Override
    public Product convert(MappingContext<SoftlogicProduct, Product> context) {
        SoftlogicProduct softlogicProduct = context.getSource();
        Product product = context.getDestination();
        product.setStatusId(softlogicProduct.getStatusId());
        product.setId(softlogicProduct.getId());
        product.setName(softlogicProduct.getName());
        product.setProduct_category(softlogicProduct.getProduct_category());
        product.setProductImageList(softlogicProduct.getProductImageList());
        product.setQtyOnHand(softlogicProduct.getQtyOnHand());
        product.setUnitPrice(softlogicProduct.getUnitPrice());
        product.setDescription(softlogicProduct.getDescription());
        return product;
    }
    
    @Override
    protected Product convert(SoftlogicProduct source) {
        return null;
    }
    
    
}
