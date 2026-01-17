package com.sushant.userservice.controllers;

import com.sushant.userservice.dto.CreateUser;
import com.sushant.userservice.dto.UserResponse;
import com.sushant.userservice.models.User;
import com.sushant.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RequestMapping("/api/v1")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user/{user-id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("user-id") String userId){
        UserResponse userResponse = this.userService.getUserById(userId);
        return ResponseEntity.of(Optional.of(userResponse));
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody CreateUser createUser) {
        User user = userService.createUser(createUser);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully with id " + user.getId());
    }

}
