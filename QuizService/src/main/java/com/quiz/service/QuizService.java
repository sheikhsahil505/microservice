package com.quiz.service;

import com.quiz.entity.Quiz;

import java.util.List;
import java.util.Locale;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> getAll();
    Quiz getQuiz(Long id);

}
