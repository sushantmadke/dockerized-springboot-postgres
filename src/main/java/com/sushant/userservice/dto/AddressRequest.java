package com.sushant.userservice.dto;

import com.sushant.userservice.models.AddressType;
import lombok.Data;

@Data
public class AddressRequest {

    private AddressType addressType;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
