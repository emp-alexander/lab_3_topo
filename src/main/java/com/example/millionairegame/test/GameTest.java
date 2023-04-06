package com.example.millionairegame.test;

import com.example.millionairegame.Game;

import com.example.millionairegame.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GameTest {

    private Question q1, q2, q3; //вопросы
    private ArrayList<Question> questions; //пул вопросов
    private List<String> answer1; //вар-ты ответов к первому вопросу
    private List<String> answer2; //вар-ты ответов к второму вопросу
    private List<String> answer3;
    private int[] hint501, hint502, hint503; //подсказки 50/50 к 1 и 2 вопросу
    @Before
    public void setUp() throws Exception {
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        hint501 = new int[]{3, 2};
        hint502 = new int[]{4, 2};
        Collections.addAll(answer1, "тесто", "золото", "сено", "каша");
        Collections.addAll(answer2, "Питсбург", "Москва", "Санкт-Петербург", "Киров");
        q1 = new Question("Из чего сделан колобок?", 0,  answer1, 0, hint501, 1);
        q2 = new Question("Культурная столица России?", 1,  answer2, 3, hint502, 2);
        questions = new ArrayList<>();
        Collections.addAll(questions, q1, q2);
    }

    @Test
    public void gameClassCreationTest(){
        Game game = new Game();
    }

    @Test
    public void gameWithParamCreationTest(){
        Game game = new Game(questions);
    }

    @Test
    public void checkAnswerTest(){
        Game game = new Game();
       // Assert.assertEquals(true, game.checkAnswer(0,0));
    }

    @Test
    public void getNextQuestionTest(){
        Game game = new Game(questions);
        Assert.assertEquals(1, game.getNextQuestion().getId());
        Assert.assertEquals(null, game.getNextQuestion());
    }

    @Test
    public void addScoreTest(){
        Game game = new Game(questions);
        Assert.assertEquals(0, game.getScore());
        game.addScore(game.getQuestions().get(0));
        Assert.assertEquals(500, game.getScore());
        game.addScore(game.getQuestions().get(1));
        Assert.assertEquals(1500, game.getScore());
    }

    @Test
    public void getRandomQuestionByDifficultyTest(){
        hint501 = new int[]{3, 2};
        hint502 = new int[]{4, 2};
        hint503 = new int[]{4, 2};
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer3 = new ArrayList<>();
        Collections.addAll(answer1, "тесто", "золото", "сено", "каша");
        Collections.addAll(answer2, "Питсбург", "Москва", "Санкт-Петербург", "Киров");
        Collections.addAll(answer3, "Пушкин", "Лермонтов", "Есенин", "Блок");
        q1 = new Question("Из чего сделан колобок?", 0,  answer1, 0, hint501, 1);
        q2 = new Question("Культурная столица России?", 1,  answer2, 3, hint502, 2);
        q3 = new Question("Поэт деревни?", 2,  answer3, 2, hint503, 2);
        questions = new ArrayList<>();
        Collections.addAll(questions, q1, q2, q3);
        Game game = new Game(questions);
        Assert.assertEquals(2, game.getRandomQuestion(game.getQuestions(), 2).getDifficulty());
    }


}