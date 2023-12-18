package com.question.service.impl;

import com.question.entity.Question;
import com.question.entity.Quiz;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import com.question.service.QuizClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizClient quizClient;


    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        List<Question> all = questionRepository.findAll();
        List<Question> updatedQuestions = new ArrayList<>();

        for (Question q : all) {
            Long quizId = q.getQuizId();
            Quiz byId = quizClient.findById(quizId);
            q.setQuizzes(byId);
            updatedQuestions.add(q);
        }

        return updatedQuestions;
    }

    @Override
    public Question getById(long id) {
        Question question_not_found = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        Long quizId = question_not_found.getQuizId();
        Quiz byId = quizClient.findById(quizId);
        question_not_found.setQuizzes(byId);
        return question_not_found;

    }

    @Override
    public List<Question> getQuestionOfQuiz(long id) {
        return questionRepository.findByQuizId(id);
    }
}

//
//    @Override
//    public List<Quiz> getAll() {
//        List<Quiz> quizzes = quizRepository.findAll();
//
//        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
//            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//            return quiz;
//        }).collect(Collectors.toList());
//
//        return newQuizList;
//    }
//
//    @Override
//    public Quiz getQuiz(Long id) {
//
//        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
//        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//        return quiz;
//    }