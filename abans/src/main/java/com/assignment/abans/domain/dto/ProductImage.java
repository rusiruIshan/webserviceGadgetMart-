package com.assignment.abans.domain.dto;

import lombok.Data;

/**
 * @author Rusiru
 */
@Data
public class ProductImage {
    private long id;
    private String name;
    private String path;
    private String statusId;
    private String imageType;
}
