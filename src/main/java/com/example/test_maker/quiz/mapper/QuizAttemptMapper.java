package com.example.test_maker.quiz.mapper;

import com.example.test_maker.quiz.dto.QuizAttemptResponse;
import com.example.test_maker.quiz.entity.QuizAttempt;

import java.util.ArrayList;
import java.util.List;

public class QuizAttemptMapper {
    public static QuizAttemptResponse toQuizAttemptResponse(QuizAttempt quizAttempt){
        QuizAttemptResponse quizAttemptResponse = new QuizAttemptResponse();
        quizAttemptResponse.setId(quizAttempt.getId());
        quizAttemptResponse.setUserId(quizAttempt.getUser().getId());
        quizAttemptResponse.setDateAttempted(quizAttempt.getDateAttempted());
        return quizAttemptResponse;
    }

    public static List<QuizAttemptResponse> toQuizAttemptResponseList(List<QuizAttempt> quizAttempts){
        List<QuizAttemptResponse> quizAttemptsResponse = new ArrayList<>();
        for(QuizAttempt quizAttempt : quizAttempts){
            quizAttemptsResponse.add(toQuizAttemptResponse(quizAttempt));
        }
        return quizAttemptsResponse;
    }
}
