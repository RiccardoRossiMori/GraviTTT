package com.github.RiccardoRossiMori.GraviTTT.Controller;

/**
 * <b>Responsabilit�: </b>Gestisce una partita tra due giocatori.
 */

//import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GameManagerInterface {
    //TODO inserisci pi� metodi qu� da cui dipendere per le estensioni

   // MatrixCheckerboard getScacchiera();

    void cambioTurno();

    void play() throws IOException, IllegalPawnPlacementException;
    //List<? extends com.github.RiccardoRossiMori.GraviTTT.Model.Player> scegliGiocatori() throws IOException;


}
