package test.java.GraviTTT.Tests;

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

    CheckerboardVariables dimension = CheckerboardVariables.DEFAULT_SIZE;
    GameManager game;
    StartGameInterface startGameInterface;

    @BeforeEach
    void setUp() {
        game = new GameManager(new MatrixCheckerboard(this.dimension));
        startGameInterface = new StartGameDefault();
    }

    @Test
    void getCheckerboardManager() {
        Assertions.assertEquals(CheckerboardManager.class, this.game.getCheckerboardManager().getClass(), "tutto ok");
    }

    @Test
    void cambioTurno() {
        if (this.game.isTurn()) {
            this.game.swapTurn();
            Assertions.assertFalse(this.game.isTurn());
        } else {
            this.game.swapTurn();
            Assertions.assertTrue(this.game.isTurn());
        }
    }
}