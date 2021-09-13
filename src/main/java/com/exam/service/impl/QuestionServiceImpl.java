package com.exam.service.impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuestionsRepository;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl  implements QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;


    @Override
    public Question addQuestion(Question question) {
        return this.questionsRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionsRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>( this.questionsRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionsRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsofQuiz(Quiz quiz) {

        return this.questionsRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
        this.questionsRepository.delete(question);
    }
}
