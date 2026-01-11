package com.example.test_maker.user.service;

import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.ValidateUserRequest;
import com.example.test_maker.user.dto.UserAccountResponse;

public interface UserService {
    UserAccountResponse validateUser(ValidateUserRequest userAccountRequest);

    UserAccountResponse createUser(UserAccountRequest userAccountRequest);
}
