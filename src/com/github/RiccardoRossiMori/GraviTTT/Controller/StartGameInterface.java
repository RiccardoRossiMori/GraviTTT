package com.github.RiccardoRossiMori.GraviTTT.Controller; /**
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> con una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>.
 */

import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface StartGameInterface {

   // CheckerboardManager getCheckerboardManager();//TODO che vada eliminato il metodo?

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
    default <T extends CheckerboardVariables> CheckerboardVariables setSize(int i, int j, boolean flag) {//TODO chiedi a qualcuno se può andare scritto così
        return new CheckerboardVariables(i, j, flag);//metodo marginale, mai utilizzato, ma comunque implementato per estensioni future
    }

    /**
     * Metodo che farà un primo settaggio delle variabili di gioco o avvierà il procedimento per le stesse.
     *
     * @param gameManager
     * @throws IOException
     */
    void init(GameManager gameManager) throws IOException;

    /**
     * Restituisce un giocatore. La stringa passata come parametro è solo per poter
     * stampare a video se si tratti del primo o del secondo giocatore.
     *
     * @param giocatoreNumeroX
     * @return
     * @throws IOException
     */
    Player scegliGiocatori(String giocatoreNumeroX) throws IOException;
}
