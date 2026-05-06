package com.app.ecom.dto;


import lombok.Data;

@Data
public class UserRequest {
    private String id;

    private Long serialId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    private AddressDTO addressDTO;

//    public boolean getAddress() {
//    }
}
