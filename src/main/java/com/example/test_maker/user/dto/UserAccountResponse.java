package com.example.test_maker.user.dto;


import com.example.test_maker.quiz.dto.QuizAttemptResponse;

import java.util.ArrayList;
import java.util.List;

public class UserAccountResponse {
    private Long id;
    private String username;
    private String email;
    private List<QuizAttemptResponse> quizAttempts = new ArrayList<>();

    public UserAccountResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<QuizAttemptResponse> getQuizAttempts() {
        return quizAttempts;
    }

    public void setQuizAttempts(List<QuizAttemptResponse> quizAttempts) {
        this.quizAttempts = quizAttempts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
