package com.example.millionairegame.test;

import com.example.millionairegame.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionTest {


    private List<String> answer = new ArrayList<>();
    private int[] hint501; //подсказка 50/50

    @Before
   public void setUp() throws Exception{
        answer.add("Москва");
        answer.add("Амстердам");
        answer.add("Питсбург");
        answer.add("Санкт-Петербург");
        hint501 = new int[]{1, 2}; //{} - то что скрыть
    }

    @Test
    public void questionCreationTest(){
        Question question = new Question();
    }

    @Test
    public void questionWithParamCreationTest(){
      Question question = new Question("Культурная столица России?", 1, answer, 3, hint501); //вопрос, индекс вопроса, варианты ответо, верный ответ, подсказка50/50
    }
}
