package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;

	// add quiz
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}

	// update quiz
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}

	// get quizzes
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes() {
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}

	// get quiz
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}

	// delete quiz
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}

	@GetMapping("/category/{cId}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cId") Long cId) {
		Category category = new Category();
		category.setcId(cId);
		return this.quizService.getQuizzesOfCategory(category);
	}

	// get active quizzes
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes() {
		return this.quizService.getActiveQuizzes();
	}

	// get active quizzes of category
	@GetMapping("/category/active/{cId}")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable Long cId) {
		Category category = new Category();
		category.setcId(cId);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}

}
