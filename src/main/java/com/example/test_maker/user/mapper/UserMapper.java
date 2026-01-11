package com.example.test_maker.user.mapper;

import com.example.test_maker.quiz.mapper.QuizAttemptMapper;
import com.example.test_maker.user.dto.UserAccountResponse;
import com.example.test_maker.user.entity.User;

public class UserMapper {
    public static UserAccountResponse toUserAccountResponse(User user){
        UserAccountResponse userAccountResponse = new UserAccountResponse();
        userAccountResponse.setId(user.getId());
        userAccountResponse.setUsername(user.getUsername());
        userAccountResponse.setEmail(user.getEmail());
        userAccountResponse.setQuizAttempts(
                QuizAttemptMapper.toQuizAttemptResponseList(
                        user.getQuizAttempts()
                )
        );
        return userAccountResponse;
    }
}
