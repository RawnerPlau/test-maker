package com.example.test_maker.user.service.impl;

import com.example.test_maker.exception.BadRequestException;
import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.entity.User;
import com.example.test_maker.user.mapper.UserMapper;
import com.example.test_maker.user.repository.UserRepository;
import com.example.test_maker.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserAccountResponse validateUser(UserAccountRequest userAccountRequest) {
        User user = userRepository.findByUsername(userAccountRequest.getUsername())
                .orElseThrow(() -> new BadRequestException("User not found"));
        if (!user.getPassword().equals(userAccountRequest.getPassword())){
            throw new BadRequestException("Wrong password");
        }
        return UserMapper.toUserAccountResponse(user);
    }
}
