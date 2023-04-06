package com.example.millionairegame;

import java.util.ArrayList;

public class Game {

    private int score;
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private boolean[] hint;

    public Game(){};

    public Game(ArrayList<Question> questions) {
        score = 0;
        this.questions = questions;
        currentQuestionIndex = 0;
        hint = new boolean[]{true, true, true};
    }

    public boolean checkAnswer(int answ, int quest){
        //todo реализовать метод checkAnswer позднее
        if(answ == quest){
            return true;
        }
        else
            return false;
    }

    public Question getNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        } else {
            return null;
        }
    }



}
