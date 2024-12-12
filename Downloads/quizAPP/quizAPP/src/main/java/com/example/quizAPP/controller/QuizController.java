package com.example.quizAPP.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizAPP.model.Question;
import com.example.quizAPP.model.QuizSession;
import com.example.quizAPP.service.QuizService;


@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;
    private QuizSession session;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
        this.session = new QuizSession(); // New session on server start
    }

    @PostMapping("/start")
    public String startNewQuiz() {
        session = new QuizSession(); // Reset the session
        return "New quiz session started!";
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        Question question = quizService.getRandomQuestion(); // Fetch question by ID if needed
        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);
        session.submitAnswer(isCorrect, question.getQuestion());
        return isCorrect ? "Correct!" : "Incorrect!";
    }

    @GetMapping("/results")
    public QuizSession getResults() {
        return session;
    }
}