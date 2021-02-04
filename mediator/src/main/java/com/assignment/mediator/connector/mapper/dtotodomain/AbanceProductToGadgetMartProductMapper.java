package com.assignment.mediator.connector.mapper.dtotodomain;



import com.assignment.mediator.dto.AbanceProduct;
import com.assignment.mediator.dto.Product;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.List;

/**
 * @author Rusiru
 */
public class AbanceProductToGadgetMartProductMapper extends AbstractConverter<AbanceProduct, Product> {
    
    
    @Override
    public Product convert(MappingContext<AbanceProduct, Product> context) {
        AbanceProduct abanceProduct = context.getSource();
        Product product = context.getDestination();
        product.setStatusId(abanceProduct.getStatusId());
        product.setId(abanceProduct.getId());
        product.setName(abanceProduct.getName());
        product.setProduct_category(abanceProduct.getProduct_category());
        product.setProductImageList(abanceProduct.getProductImageList());
        product.setQtyOnHand(abanceProduct.getQtyOnHand());
        product.setUnitPrice(abanceProduct.getUnitPrice());
        product.setDescription(abanceProduct.getDescription());
        return product;
    }
    
    @Override
    protected Product convert(AbanceProduct source) {
        return null;
    }
    
 
}
