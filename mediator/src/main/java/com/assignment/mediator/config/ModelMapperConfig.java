package com.assignment.mediator.config;

import com.assignment.mediator.connector.mapper.dtotodomain.AbanceProductToGadgetMartProductMapper;
import com.assignment.mediator.connector.mapper.dtotodomain.SingerProductToGadgetMartProductMapper;
import com.assignment.mediator.connector.mapper.dtotodomain.SoftlogicProductToGadgetMartProductMapper;
import com.assignment.mediator.dto.AbanceProduct;
import com.assignment.mediator.dto.Product;
import com.assignment.mediator.dto.SingerProduct;
import com.assignment.mediator.dto.SoftlogicProduct;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.InheritingConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Rusiru on 2/2/2021 11:20 PM
 */
@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        addAbanceProductToGadgetMartProductMapper(modelMapper);
        addSingerProductToGadgetMartProductMapper(modelMapper);
        addSoftlogicProductToGadgetMartProductMapper(modelMapper);
        return modelMapper;
    }
    
    private org.modelmapper.config.Configuration getStrictMatchingStrategy() {
        return new InheritingConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    
    private void addAbanceProductToGadgetMartProductMapper(final ModelMapper modelMapper) {
        modelMapper.createTypeMap(AbanceProduct.class, Product.class, getStrictMatchingStrategy())
                .setConverter(new AbanceProductToGadgetMartProductMapper());
    }
    private void addSingerProductToGadgetMartProductMapper(final ModelMapper modelMapper) {
        modelMapper.createTypeMap(SingerProduct.class, Product.class, getStrictMatchingStrategy())
                .setConverter(new SingerProductToGadgetMartProductMapper());
    }
    private void addSoftlogicProductToGadgetMartProductMapper(final ModelMapper modelMapper) {
        modelMapper.createTypeMap(SoftlogicProduct.class, Product.class, getStrictMatchingStrategy())
                .setConverter(new SoftlogicProductToGadgetMartProductMapper());
    }
}
