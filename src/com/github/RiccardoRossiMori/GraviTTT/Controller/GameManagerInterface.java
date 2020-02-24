package com.github.RiccardoRossiMori.GraviTTT.Controller;

/**
 * <b>Responsabilit�: </b>Gestisce una partita tra due giocatori.
 */

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
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
    //List<? extends com.github.RiccardoRossiMori.GraviTTT.Model.Player> scegliGiocatori() throws IOException;
}
