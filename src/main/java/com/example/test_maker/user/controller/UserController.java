package com.example.test_maker.user.controller;

import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.ValidateUserRequest;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccountResponse> validateUser(@RequestBody ValidateUserRequest validateUserRequest){
        return ResponseEntity.ok(userService.validateUser(validateUserRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserAccountResponse> createUser(@RequestBody UserAccountRequest userAccountRequest){
        return ResponseEntity.ok(userService.createUser(userAccountRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccountResponse> updateUser(@PathVariable Long id, @RequestBody UserAccountRequest userAccountRequest){
        return ResponseEntity.ok(userService.updateUser(id, userAccountRequest));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<UserAccountResponse> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
