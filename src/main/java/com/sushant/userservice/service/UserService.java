package com.sushant.userservice.service;

import com.sushant.userservice.dto.AddressResponse;
import com.sushant.userservice.dto.UserResponse;
import com.sushant.userservice.models.Address;
import com.sushant.userservice.dto.CreateUser;
import com.sushant.userservice.models.User;
import com.sushant.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUserById(String userId) {
        Optional<User> optionalUser = this.userRepository.findById(Long.parseLong(userId));
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            List<AddressResponse> addressResponses = getAddressResponses(user);

            return UserResponse.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .address(addressResponses)
                    .build();
        }
        return null;
    }

    private static List<AddressResponse> getAddressResponses(User user) {
        List<Address> address = user.getAddress();
        List<AddressResponse> addressResponses = new ArrayList<>();
        address.forEach(ad -> {

            addressResponses.add(AddressResponse.builder()
                    .addressType(ad.getAddressType())
                    .state(ad.getState())
                    .street(ad.getStreet())
                    .zipCode(ad.getZipCode())
                    .city(ad.getCity())
                    .houseNumber(ad.getHouseNumber())
                    .id(ad.getId())
                    .build());


        });
        return addressResponses;
    }

    public User createUser(CreateUser createUser) {

        User user = User.builder()
                .firstName(createUser.getFirstName())
                .lastName(createUser.getLastName())
                .build();

        List<Address> addresses = createUser.getAddressRequestList()
                .stream()
                .map(req -> Address.builder()
                        .street(req.getStreet())
                        .state(req.getState())
                        .city(req.getCity())
                        .addressType(req.getAddressType())
                        .houseNumber(req.getHouseNumber())
                        .zipCode(req.getZipCode())
                        .user(user)   // 🔥 VERY IMPORTANT
                        .build())
                .toList();

        user.setAddress(addresses);

        return userRepository.save(user);// cascades to Address

    }
}
