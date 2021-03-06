package com.github.RiccardoRossiMori.GraviTTT.Controller;

/**
 * <b>Responsabilit�: </b>Gestisce una partita tra due giocatori.
 */

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTView;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 */
public interface GameManagerInterface {

    /**
     * Ritorna il manager della tabella di gioco.
     *
     * @return
     */
    CheckerboardManager getCheckerboardManager();

    /**
     * Fa s� che il turno passi da un giocatore ad un altro.
     */
    void swapTurn();

    /**
     * Gestisce una o pi� partite consecutive tra due giocatori.
     *
     * @throws IOException
     * @throws IllegalPawnPlacementException
     */
    void play() throws IOException, IllegalPawnPlacementException;

    /**
     * Presa una stringa in ingresso, la invia alla view per stamparla a video.
     *
     * @param string
     */
    void sendMessage(String string);

    GraviTTTView getView();

    /**
     * Chiede alla view un input intero e lo ritorna.
     *
     * @return l'input preso dalla view.
     * @throws IOException
     */
    int getterIntegerInput() throws IOException;
}
