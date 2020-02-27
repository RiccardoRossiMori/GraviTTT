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
    //TODO inserisci pi� metodi qu� da cui dipendere per le estensioni

    /**
     * Fa s� che il turno passi da un giocatore ad un altro.
     */
    void cambioTurno();

    /**
     * Gestisce una o pi� partite consecutive tra due giocatori.
     *
     * @throws IOException
     * @throws IllegalPawnPlacementException
     */
    void play() throws IOException, IllegalPawnPlacementException;

    GraviTTTView getVista();

    int getterIntegerInput() throws IOException;
    //List<? extends com.github.RiccardoRossiMori.GraviTTT.Model.Player> scegliGiocatori() throws IOException;
}
