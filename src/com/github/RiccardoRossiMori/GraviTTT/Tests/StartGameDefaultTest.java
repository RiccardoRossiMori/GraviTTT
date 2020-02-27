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
        game = new GameManager(new MatrixCheckerboard(this.dimensioni));
        startGameInterface = new StartGameDefault();
    }

    @Test
    void scegliGiocatori() throws IOException {
        this.startGameInterface.init(this.game);
        Player player;
        final InputStream sysInBackup = System.in; // backup System.in to restore it later
        giocatore(true);
        player = this.startGameInterface.scegliGiocatori("prova");
        assertEquals(player.getClass(), RandomPlayer.class);
        giocatore(false);
        player = this.startGameInterface.scegliGiocatori("prova2");
        assertEquals(player.getClass(), InteractivePlayer.class);
    }

    private void giocatore(final boolean uno) {
        if (uno) {
            final String input = "bot";
            final InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        } else {
            final String input = "\n";
            final InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
    }
}