package com.example.test_maker.quiz.dto;

import java.time.Instant;
import java.time.LocalDate;

public class QuizAttemptResponse {
    private Long id;
    private Long userId;
    private Instant dateAttempted;

    public QuizAttemptResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getDateAttempted() {
        return dateAttempted;
    }

    public void setDateAttempted(Instant dateAttempted) {
        this.dateAttempted = dateAttempted;
    }
}
