package com.exam.services;

import java.util.Set;

import com.exam.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quiId);
	
	public void deleteQuiz(Long quizId);	

}
