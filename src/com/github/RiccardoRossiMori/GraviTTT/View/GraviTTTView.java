package com.github.RiccardoRossiMori.GraviTTT.View;

import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Gestisce una vista generica sul gioco.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GraviTTTView {

    /**
     * Visualizza un messaggio.
     * @param message
     */
    void printMessage(String message);

    /**
     * Prende un input esterno e lo restituisce sotto forma di stringa.
     * @return
     * @throws IOException
     */
    String getInput() throws IOException;

    /**
     * Prende un messaggio, lo visualizza e poi richiede in input
     * una stringa che ritornerà.
     * @param message
     * @return
     * @throws IOException
     */
    String getStringPlayer(String message) throws IOException;

    /**
     * Visualizza la scacchiera di gioco.
     * @param scacchiera
     */
    void printCheckerboard(String scacchiera);

}
