package com.exam.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quiId) {
		return this.quizRepository.findById(quiId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		/*
		 * Quiz quiz = new Quiz(); quiz.setqId(quizId);
		 * this.quizRepository.delete(quiz);
		 */
		this.quizRepository.deleteById(quizId);
	}

}
