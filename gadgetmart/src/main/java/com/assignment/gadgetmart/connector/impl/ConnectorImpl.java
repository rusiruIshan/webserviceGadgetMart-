package com.assignment.gadgetmart.connector.impl;

import com.assignment.gadgetmart.connector.Connector;
import com.assignment.gadgetmart.domain.dto.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Rusiru
 */
@Component
public class ConnectorImpl implements Connector {
    
    
    private RestTemplate restTemplate;
    
    public ConnectorImpl() {
        this.restTemplate = new RestTemplate();
    }
    
    @Value("${application.api.getAllProductUrl}")
    private String getAllProductUrl;
    
    @Override
    public List<Product> getAllProduct() {
    
        URI uri = UriComponentsBuilder.fromUriString(getAllProductUrl)
                .buildAndExpand()
                .toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                }).getBody();
    }
    
   
}
