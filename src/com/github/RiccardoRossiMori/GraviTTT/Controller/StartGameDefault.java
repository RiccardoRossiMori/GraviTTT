package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> ed una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>
 * con variabili standard, ossia una scacchiera con 6 righe e 7 colonne limitata esteriormente.
 *
 * @author Riccardo Rossi Mori
 */

public class StartGameDefault implements StartGameInterface {

    private GameManager gameManager;

    /**
     * getPlayerFactory, presa una stringa, instanzia un giocatore del tipo richiesto.
     *
     * @param string
     * @param gameManager
     * @return
     */
    private static Player getPlayerFactory(final String string, final CheckerboardManager checkerboardManager, final GameManager gameManager) {
        if (string.equals("bot")) {
            return new RandomPlayer(checkerboardManager);
        }
        return new InteractivePlayer(gameManager);
    }

    /**
     * Inizializza le variabili di gioco
     *
     * @throws IOException
     */
    @Override
    public void init(final GameManager gameManager) {
        this.gameManager = gameManager;
        gameManager.setView(new GraviTTTConsoleView());
    }

    /**
     * Instanzia un particolare com.github.RiccardoRossiMori.GraviTTT.Model.Player a seconda della stringa inserita.
     * Se si scrive 'bot' verrà instanziato un com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer, che eseguirà ogni
     * mossa casualmente, mentre se si scriverà una qualunque altra cosa verrà instanziato un
     * com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer, ossia un giocatore Interattivo.
     * Potrebbe essere lanciata una IOException poiché richiede degli input esterni.
     *
     * @param playerNumber
     * @return Player
     * @throws IOException
     */
    @Override
    public Player getPlayer(final String playerNumber) throws IOException {
        final String playerType;
        playerType = this.gameManager.getView().getStringPlayer(playerNumber +
                " giocatore, inserisci 'bot' per il giocatore random, " +
                "premi un qualunque altro tasto per il giocatore interattivo.");
        return StartGameDefault.getPlayerFactory(playerType.toLowerCase(),
                this.gameManager.getCheckerboardManager(), this.gameManager);
    }

}
