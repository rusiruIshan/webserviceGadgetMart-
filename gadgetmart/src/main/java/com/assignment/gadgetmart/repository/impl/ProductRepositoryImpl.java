package com.assignment.gadgetmart.repository.impl;


import com.assignment.gadgetmart.domain.dto.Product;
import com.assignment.gadgetmart.domain.dto.ProductCategory;
import com.assignment.gadgetmart.domain.dto.ProductImage;
import com.assignment.gadgetmart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rusiru
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    
    
    
}
