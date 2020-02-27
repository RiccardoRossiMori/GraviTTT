package com.github.RiccardoRossiMori.GraviTTT.View;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Gestisce una vista generica sul gioco.
 */

/**
 * @author Riccardo Rossi Mori
 */
public interface GraviTTTView {

    /**
     * Visualizza un messaggio.
     *
     * @param message
     */
    void printMessage(String message);

    /**
     * Prende un input esterno e lo restituisce sotto forma di stringa.
     *
     * @return
     * @throws IOException
     */
    String getInput() throws IOException;

    /**
     * Prende specificatamente un numero dall'esterno e lo restituisce come intero.
     *
     * @return
     * @throws IOException
     */
    int getIntInput() throws IOException;

    /**
     * Prende un messaggio, lo visualizza e poi richiede in input
     * una stringa che ritornerà.
     *
     * @param message
     * @return
     * @throws IOException
     */
    String getStringPlayer(String message) throws IOException;

    /**
     * Visualizza la scacchiera di gioco.
     *
     * @param scacchiera
     */
    void printCheckerboard(String scacchiera);

}
