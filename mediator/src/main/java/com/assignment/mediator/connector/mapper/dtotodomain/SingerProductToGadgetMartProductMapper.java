package com.assignment.mediator.connector.mapper.dtotodomain;

import com.assignment.mediator.dto.Product;
import com.assignment.mediator.dto.SingerProduct;
import org.modelmapper.AbstractConverter;
import org.modelmapper.spi.MappingContext;

import java.util.List;

/**
 * @author Rusiru
 */
public class SingerProductToGadgetMartProductMapper extends AbstractConverter<SingerProduct, Product> {
    
    
    @Override
    public Product convert(MappingContext<SingerProduct, Product> context) {
        SingerProduct singerProduct = context.getSource();
        Product product = context.getDestination();
        product.setStatusId(singerProduct.getStatusId());
        product.setId(singerProduct.getId());
        product.setName(singerProduct.getName());
        product.setProduct_category(singerProduct.getProduct_category());
        product.setProductImageList(singerProduct.getProductImageList());
        product.setQtyOnHand(singerProduct.getQtyOnHand());
        product.setUnitPrice(singerProduct.getUnitPrice());
        product.setDescription(singerProduct.getDescription());
        return product;
    }
    
    @Override
    protected Product convert(SingerProduct source) {
        return null;
    }
    
}
