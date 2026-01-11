package com.example.test_maker.user.mapper;

import com.example.test_maker.user.dto.UserAccountRequest;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.entity.User;

public class UserMapper {
    public static UserAccountResponse toUserAccountResponse(User user){
        UserAccountResponse userAccountResponse = new UserAccountResponse();
        userAccountResponse.setId(user.getId());
        userAccountResponse.setUsername(user.getUsername());
        userAccountResponse.setEmail(user.getEmail());
        return userAccountResponse;
    }

    public static User toUser(UserAccountRequest userAccountRequest){
        User user = new User();
        user.setUsername(userAccountRequest.getUsername());
        user.setPassword(userAccountRequest.getPassword());
        user.setEmail(userAccountRequest.getEmail());
        return user;
    }

}
