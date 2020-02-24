package com.github.RiccardoRossiMori.GraviTTT.Tests;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameManagerTest {

        CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
        GameManager game;
        StartGameInterface startGameInterface;

        @BeforeEach
        void setUp() {
            this.game = new GameManager(new MatrixCheckerboard(dimensioni));
            this.startGameInterface = new StartGameDefault();
        }

        @Test
        void getCheckerboardManager() {
            Assertions.assertEquals(CheckerboardManager.class, game.getCheckerboardManager().getClass(), "tutto ok");
        }

        @Test
        void cambioTurno() {
            if (game.isTurno()) {
                game.cambioTurno();
                Assertions.assertFalse(game.isTurno());
            } else {
                game.cambioTurno();
                Assertions.assertTrue(game.isTurno());
            }
        }
}