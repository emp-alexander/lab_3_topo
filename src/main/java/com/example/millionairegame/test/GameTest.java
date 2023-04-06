package com.example.millionairegame.test;

import com.example.millionairegame.Game;

import com.example.millionairegame.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class GameTest {

    private Question q1, q2; //вопросы
    private ArrayList<Question> questions; //пул вопросов
    private List<String> answer1 = new ArrayList<>(); //вар-ты ответов к первому вопросу
    private List<String> answer2 = new ArrayList<>(); //вар-ты ответов к второму вопросу
    private int[] hint501, hint502; //подсказки 50/50 к 1 и 2 вопросу
    @Before
    public void setUp() throws Exception {
        hint501 = new int[]{3, 2};
        hint502 = new int[]{4, 2};
        Collections.addAll(answer1, "тесто", "золото", "сено", "каша");
        Collections.addAll(answer2, "Питсбург", "Москва", "Санкт-Петербург", "Киров");
        q1 = new Question("Из чего сделан колобок?", 0,  answer1, 0, hint501);
        q2 = new Question("Культурная столица России?", 1,  answer2, 3, hint502);
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
}