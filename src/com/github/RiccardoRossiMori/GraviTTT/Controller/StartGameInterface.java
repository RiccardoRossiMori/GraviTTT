package com.github.RiccardoRossiMori.GraviTTT.Controller; /**
 * <b>Responsabilit�: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> con una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>.
 */

import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 */
public interface StartGameInterface {

    /**
     * Viene fornita una implementazione di base per settare le dimensioni della tabella
     * di gioco.
     *
     * @param i
     * @param j
     * @param flag
     * @param <T>
     * @return
     */
    default <T extends CheckerboardVariables> CheckerboardVariables setSize(final int i, final int j, final boolean flag) {//TODO chiedi a qualcuno se pu� andare scritto cos�
        return new CheckerboardVariables(i, j, flag);//metodo marginale, mai utilizzato, ma comunque implementato per estensioni future
    }

    /**
     * Metodo che far� un primo settaggio delle variabili di gioco o avvier� il procedimento per le stesse.
     *
     * @param gameManager
     * @throws IOException
     */
    void init(GameManager gameManager) throws IOException;

    /**
     * Restituisce un giocatore. La stringa passata come parametro � solo per poter
     * stampare a video se si tratti del primo o del secondo giocatore.
     *
     * @param giocatoreNumeroX
     * @return
     * @throws IOException
     */
    Player scegliGiocatori(String giocatoreNumeroX) throws IOException;
}
