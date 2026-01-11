package com.example.test_maker.user.controller;

import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccountResponse> validateUser(@RequestBody UserAccountRequest userAccountRequest){
        return ResponseEntity.ok(userService.validateUser(userAccountRequest));
    }
}
