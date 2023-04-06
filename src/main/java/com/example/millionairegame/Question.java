package com.example.millionairegame;

import java.util.List;

public class Question {
    private String quastionsText;
    private int id;
    private List<String> answerOptions;
    private int correctAnswerIndex;

    private int[] hint50;

    private int difficulty;

    public Question(String quastionsText, int id, List<String> answerOptions, int correctAnswerIndex, int[] hint50, int difficulty) {
        this.quastionsText = quastionsText;
        this.id = id;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
        this.hint50 = hint50;
        this.difficulty = difficulty;
    }
    public Question(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuastionsText() {
        return quastionsText;
    }

    public void setQuastionsText(String quastionsText) {
        this.quastionsText = quastionsText;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int[] getHint50() {
        return hint50;
    }

    public void setHint50(int[] hint50) {
        this.hint50 = hint50;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
