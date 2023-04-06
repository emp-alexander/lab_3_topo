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

    public boolean checkAnswer(int answ, Question quest){
        if(answ == quest.getCorrectAnswerIndex()){
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

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }


    public void addScore(Question question){
        switch (question.getDifficulty()){
            case (1) :
                score += 500;
                break;
            case (2) :
                score += 1000;
                break;
            case (3) :
                score += 5000;
                break;
            case (6) :
                score += 10000;
                break;
            case (7) :
                score += 500000;
                break;
        }
    }

    public Question getRandomQuestion(ArrayList<Question> questions, int difficulty) {
        ArrayList<Question> questionsByDifficulty = new ArrayList<Question>();
        for (Question question : questions) {
            if (question.getDifficulty() == difficulty) {
                questionsByDifficulty.add(question);
            }
        }
        if (questionsByDifficulty.size() == 0) {
            return null; // Если в списке нет вопросов с заданной сложностью
        }
        int randomIndex = (int) (Math.random() * questionsByDifficulty.size());
        return questionsByDifficulty.get(randomIndex);
    }



}
