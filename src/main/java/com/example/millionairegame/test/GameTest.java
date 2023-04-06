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


    @Test
    public void gameClassCreationTest(){
        Game game = new Game();
    }

    @Test
    public void gameWithParamCreationTest(){
        Game game = new Game(questions);
    }
}