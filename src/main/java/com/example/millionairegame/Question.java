package com.example.millionairegame;

import java.util.List;

public class Question {
    private String quastionsText;
    private int id;
    private List<String> answerOptions;
    private int correctAnswerIndex;

    private int[] hint50;

    public Question(String quastionsText, int id, List<String> answerOptions, int correctAnswerIndex, int[] hint50) {
        this.quastionsText = quastionsText;
        this.id = id;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
        this.hint50 = hint50;
    }
    public Question(){};
}
