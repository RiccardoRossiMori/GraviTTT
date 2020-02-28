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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    void illegalPawnPlacementExceptionTest() throws IOException {
        this.startGameInterface.init(this.game);
        final String input = "1\n1\n1\n1\n1\n1\n1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.game.play();
    }

    @Test
    void numberFormatExceptionTest() throws IOException {
        this.startGameInterface.init(this.game);
        final String input = "1\n1\ne\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.game.play();
    }

    @Test
    void playerOneWins() throws IOException {
        this.startGameInterface.init(this.game);
        final String input = "1\n1\n1\n2\n1\n2\n1\n2\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.game.play();
        Assertions.assertTrue(game.isTurn());
    }

    @Test
    void playerTwoWins() throws IOException {
        this.startGameInterface.init(this.game);
        final String input = "1\n1\n2\n1\n3\n1\n2\n1\n3\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        this.game.play();
        Assertions.assertFalse(game.isTurn());
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