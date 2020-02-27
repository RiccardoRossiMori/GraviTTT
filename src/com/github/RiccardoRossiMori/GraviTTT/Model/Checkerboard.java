package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b> Responsabilità: </b> Memorizzare una scacchiera.
 */

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

/**
 * @author Riccardo Rossi Mori
 */
public interface Checkerboard {


    /**
     * Prova ad inserire un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> nella colonna <code>p</code>.
     *
     * @param p
     * @param disco
     * @return
     * @throws IllegalPawnPlacementException
     */
    boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacementException;

    /**
     * Restituisce vero o falso a seconda se l'ultima mossa sia stata o meno vincente.
     *
     * @param i
     * @param j
     * @return
     */
    boolean vincitore(int i, int j);

    /**
     * Data una <code>column</code> restituisce la riga disponibile per posizionare la pedina.
     *
     * @param column
     * @return
     */
    int gravity(int column) throws IllegalPawnPlacementException;

    /**
     * Si vuole andare a trovare le pedine circostanti dello stesso colore
     * ricorsivamente per verificare che ve ne siano 4 consecutive e dichiarare
     * quel giocatore come vincitore della partita.
     *
     * @return
     */
    int pawnNeighbor(Orientamento x);

    /**
     * Ritorna la tabella di gioco sotto forma di stringa per poter essere stampata.
     *
     * @return
     */
    String stampa();

    /**
     * Restituisce le dimensioni della tabella.
     *
     * @return
     */
    CheckerboardVariables getDimensioni();
}
