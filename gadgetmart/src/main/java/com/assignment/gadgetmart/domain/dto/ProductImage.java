package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

/**
 * @author Rusiru on 7/5/2020 1:14 AM
 */
@Data
public class ProductImage {
    private long id;
    private String name;
    private String path;
    private String statusId;
    private String imageType;
}
