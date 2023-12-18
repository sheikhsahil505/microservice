package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping()
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable long id) {
        return questionService.getById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getByQuizId(@PathVariable long id) {
        return questionService.getQuestionOfQuiz(id);
    }
}
