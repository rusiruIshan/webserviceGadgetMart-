package com.assignment.gadgetmart.connector.impl;

import com.assignment.gadgetmart.connector.Connector;
import com.assignment.gadgetmart.domain.dto.AbanceProduct;
import com.assignment.gadgetmart.domain.dto.Product;
import com.assignment.gadgetmart.domain.dto.SingerProduct;
import com.assignment.gadgetmart.domain.dto.SoftlogicProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Rusiru on 2/2/2021 8:51 PM
 */
@Component
public class ConnectorImpl implements Connector {
    
    private RestTemplate restTemplate;
    
    @Value("${application.api.getAbanceAllProductUrl}")
    private String getAbanceAllProductUrl;
    @Value("${application.api.getSoftLogicAllProductUrl}")
    private String getSoftLogicAllProductUrl;
    @Value("${application.api.getSingerAllProductUrl}")
    private String getSingerAllProductUrl;
    
    @Override
    public List<Product> getAbanceAllProduct() {
    
        URI uri = UriComponentsBuilder.fromUriString(getAbanceAllProductUrl)
                .buildAndExpand()
                .toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();
    }
    
    @Override
    public List<Product> getSoftLogicAllProduct() {
        URI uri = UriComponentsBuilder.fromUriString(getSoftLogicAllProductUrl)
                .buildAndExpand()
                .toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();
    }
    
    @Override
    public List<Product> getSingerAllProduct() {
        URI uri = UriComponentsBuilder.fromUriString(getSingerAllProductUrl)
                .buildAndExpand()
                .toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();
    }
}
