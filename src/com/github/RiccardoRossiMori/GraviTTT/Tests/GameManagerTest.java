package com.github.RiccardoRossiMori.GraviTTT.Tests;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    CheckerboardVariables dimensioni= CheckerboardVariables.DEFAULT_SIZE;
    GameManager game;
    StartGameInterface startGameInterface;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
       this.game = new GameManager(new MatrixCheckerboard(dimensioni));
       this.startGameInterface = new StartGameDefault();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getCheckerboardManager() {
        Assertions.assertEquals(CheckerboardManager.class,game.getCheckerboardManager().getClass(),"tutto ok");
    }

    @org.junit.jupiter.api.Test
    void cambioTurno() {
        game.cambioTurno();
        //Assertions.assertFalse(); //TODO controlla che dopo cambio turno la variabile turno sia false
    }

    @org.junit.jupiter.api.Test
    void play() {
    }

    @org.junit.jupiter.api.Test
    void setVista() {
    }

    @org.junit.jupiter.api.Test
    void getVista() {
    }
}