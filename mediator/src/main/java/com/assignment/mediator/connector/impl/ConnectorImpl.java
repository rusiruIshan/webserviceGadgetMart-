package com.assignment.mediator.connector.impl;


import com.assignment.mediator.connector.Connector;
import com.assignment.mediator.connector.mapper.dtotodomain.AbanceProductToGadgetMartProductMapper;
import com.assignment.mediator.dto.AbanceProduct;
import com.assignment.mediator.dto.Product;
import com.assignment.mediator.dto.SingerProduct;
import com.assignment.mediator.dto.SoftlogicProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rusiru on 2/2/2021 8:51 PM
 */
@Component
public class ConnectorImpl implements Connector {
    
    private RestTemplate restTemplate;
    
    public ConnectorImpl() {
        this.restTemplate = new RestTemplate();
    }
    
    @Value("${application.api.getAbanceAllProductUrl}")
    private String getAbanceAllProductUrl;
    @Value("${application.api.getSoftLogicAllProductUrl}")
    private String getSoftLogicAllProductUrl;
    @Value("${application.api.getSingerAllProductUrl}")
    private String getSingerAllProductUrl;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<Product> getAbanceAllProduct() {
    
        URI uri = UriComponentsBuilder.fromUriString(getAbanceAllProductUrl)
                .buildAndExpand()
                .toUri();
    
        List<AbanceProduct> body = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AbanceProduct>>() {
                }).getBody();
        List<Product> productList = new ArrayList<>();
        for (AbanceProduct abanceProduct: body) {
            Product product = new Product();
            modelMapper.map(abanceProduct, product);
            productList.add(product);
        }
        return productList;
    }
    
    @Override
    public List<Product> getSoftLogicAllProduct() {
        URI uri = UriComponentsBuilder.fromUriString(getSoftLogicAllProductUrl)
                .buildAndExpand()
                .toUri();
    
        List<SoftlogicProduct> body = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SoftlogicProduct>>() {
                }).getBody();
    
        List<Product> productList = new ArrayList<>();
        for (SoftlogicProduct softlogicProduct: body) {
            Product product = new Product();
            modelMapper.map(softlogicProduct, product);
            productList.add(product);
        }
        return productList;
    }
    
    @Override
    public List<Product> getSingerAllProduct() {
        URI uri = UriComponentsBuilder.fromUriString(getSingerAllProductUrl)
                .buildAndExpand()
                .toUri();
    
        List<SingerProduct> body = restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SingerProduct>>() {
                }).getBody();
        List<Product> productList = new ArrayList<>();
        for (SingerProduct singerProduct: body) {
            Product product = new Product();
            modelMapper.map(singerProduct, product);
            productList.add(product);
        }
        return productList;
    }
}
