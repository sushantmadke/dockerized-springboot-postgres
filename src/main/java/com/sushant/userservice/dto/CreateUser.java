package com.sushant.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateUser {

    private String firstName;
    private String lastName;
    private List<AddressRequest> addressRequestList;

}
