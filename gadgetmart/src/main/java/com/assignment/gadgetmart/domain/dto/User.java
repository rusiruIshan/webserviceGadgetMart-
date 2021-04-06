package com.assignment.gadgetmart.domain.dto;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private int isActive;
    private String email;
    private String password;

    
}
