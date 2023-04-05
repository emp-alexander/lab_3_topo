package com.example.millionairegame.test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class GameTest {

    @Test
    void gameClassCreatedTest(){
        Game game = new Game();
        Assertions.assertNotNull(game);
    }


}
