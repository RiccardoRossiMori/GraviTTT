package com.github.RiccardoRossiMori.GraviTTT.Controller;

/**
 * <b>Responsabilità: </b>Gestisce una partita tra due giocatori.
 */

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GameManagerInterface {
    //TODO inserisci più metodi quì da cui dipendere per le estensioni

    /**
     * Fa sì che il turno passi da un giocatore ad un altro.
     */
    void cambioTurno();

    /**
     * Gestisce una o più partite consecutive tra due giocatori.
     *
     * @throws IOException
     * @throws IllegalPawnPlacementException
     */
    void play() throws IOException, IllegalPawnPlacementException;
    //List<? extends com.github.RiccardoRossiMori.GraviTTT.Model.Player> scegliGiocatori() throws IOException;
}
