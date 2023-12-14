package com.question.service.impl;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
  @Autowired
  private QuestionRepository questionRepository;


    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(long id) {
       return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));

    }

    @Override
    public List<Question> getQuestionOfQuiz(long id) {
        return questionRepository.findByQuizId(id);
    }
}
