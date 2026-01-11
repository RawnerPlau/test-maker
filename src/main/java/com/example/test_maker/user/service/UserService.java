package com.example.test_maker.user.service;

import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.repository.UserRepository;
import org.springframework.stereotype.Service;

public interface UserService {
    UserAccountResponse validateUser(UserAccountRequest userAccountRequest);

}
