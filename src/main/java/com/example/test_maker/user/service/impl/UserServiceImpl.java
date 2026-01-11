package com.example.test_maker.user.service.impl;

import com.example.test_maker.exception.BadRequestException;
import com.example.test_maker.exception.NotFoundException;
import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.ValidateUserRequest;
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
    public UserAccountResponse validateUser(ValidateUserRequest userAccountRequest) {
        User user = userRepository.findByUsername(userAccountRequest.getUsername())
                .orElseThrow(() -> new BadRequestException("User not found"));
        if (!user.getPassword().equals(userAccountRequest.getPassword())){
            throw new BadRequestException("Wrong password");
        }
        return UserMapper.toUserAccountResponse(user);
    }

    @Override
    public UserAccountResponse createUser(UserAccountRequest userAccountRequest) {
        User user = UserMapper.toUser(userAccountRequest);
        User newUser = userRepository.save(user);
        return UserMapper.toUserAccountResponse(newUser);
    }

    @Override
    public UserAccountResponse updateUser(Long id, UserAccountRequest userAccountRequest) {
        User user = getUserById(id);
        user.setUsername(userAccountRequest.getUsername());
        user.setEmail(userAccountRequest.getEmail());
        user.setPassword(userAccountRequest.getPassword());
        User updatedUser = userRepository.save(user);
        return UserMapper.toUserAccountResponse(updatedUser);
    }

    @Override
    public UserAccountResponse getUser(Long id) {
        User user = getUserById(id);
        return UserMapper.toUserAccountResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public User getUserById (Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
