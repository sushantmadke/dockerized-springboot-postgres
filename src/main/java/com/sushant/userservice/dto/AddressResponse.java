package com.sushant.userservice.dto;

import com.sushant.userservice.models.AddressType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private Long id;
    private AddressType addressType;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
