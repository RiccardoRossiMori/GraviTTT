package com.github.RiccardoRossiMori.GraviTTT.Tests;

import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import com.github.RiccardoRossiMori.GraviTTT.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StartGameDefaultTest {
    CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
    GameManager game;
    StartGameInterface startGameInterface;

    @BeforeEach
    void setUp() {
        this.game = new GameManager(new MatrixCheckerboard(dimensioni));
        this.startGameInterface = new StartGameDefault();
    }

    @Test
    void scegliGiocatori() throws IOException {
        startGameInterface.init(game);
        Player player;
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        this.giocatore(true);
        player = startGameInterface.scegliGiocatori("prova");
        assertEquals(player.getClass(), RandomPlayer.class);
        this.giocatore(false);
        player = startGameInterface.scegliGiocatori("prova2");
        assertEquals(player.getClass(), InteractivePlayer.class);
    }

    private void giocatore(boolean uno) {
        if (uno) {
            String input = "bot";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        } else {
            String input = "\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }
}