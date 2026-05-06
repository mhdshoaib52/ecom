package com.app.ecom.dto;

import com.app.ecom.model.UserRole;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
@Data
public class UserResponse {
    private String id;

    private Long serialId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    private UserRole role;

    private AddressDTO addressDTO;
}
