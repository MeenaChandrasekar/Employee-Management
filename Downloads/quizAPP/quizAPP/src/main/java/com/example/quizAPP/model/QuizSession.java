package com.example.quizAPP.model;

import java.util.ArrayList;
import java.util.List;

public class QuizSession {
    private int totalQuestionsAnswered;
    private int correctAnswers;
    private final List<String> questionHistory = new ArrayList<>();

    public void submitAnswer(boolean isCorrect, String question) {
        totalQuestionsAnswered++;
        if (isCorrect) {
            correctAnswers++;
        }
        questionHistory.add(question + (isCorrect ? " (Correct)" : " (Incorrect)"));
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getQuestionHistory() {
        return questionHistory;
    }
}