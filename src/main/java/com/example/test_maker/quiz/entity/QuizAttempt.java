package com.example.test_maker.quiz.entity;

import com.example.test_maker.user.entity.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_attempted")
    private Instant dateAttempted;

    public QuizAttempt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getDateAttempted() {
        return dateAttempted;
    }

    public void setDateAttempted(Instant dateAttempted) {
        this.dateAttempted = dateAttempted;
    }
}
