package com.quiz.controller;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable long id) {
        return quizService.getQuiz(id);
    }

    @GetMapping("/question/{id}")
    public Quiz getByQuizId(@PathVariable long id) {
        return quizService.getQuiz(id);
    }
}
