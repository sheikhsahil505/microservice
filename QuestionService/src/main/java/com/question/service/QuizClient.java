package com.question.service;

import com.question.entity.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081",value="Quiz-Client")
@FeignClient(name = "QUIZ-SERVICE")
public interface QuizClient {

    @GetMapping("/quiz/question/{id}")
    Quiz findById(@PathVariable long id);

}