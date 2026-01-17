package com.sushant.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private List<AddressResponse> address;
}
