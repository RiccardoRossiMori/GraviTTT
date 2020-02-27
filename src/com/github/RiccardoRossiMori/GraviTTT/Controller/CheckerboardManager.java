package com.github.RiccardoRossiMori.GraviTTT.Controller;


import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Pawn;

/**
 * <b> Responsabilit�: </b> Gestire la scacchiera (posizionare una pedina, )
 *
 * @author Riccardo Rossi Mori
 */

public class CheckerboardManager {
    private final Checkerboard checkerboard;

    public CheckerboardManager(final Checkerboard checkerboard) {
        this.checkerboard = checkerboard;
    }

    /**
     * Ritorna la tabella di gioco.
     *
     * @return the checkerboard
     */
    public Checkerboard getCheckerboard() {
        return checkerboard;
    }

    /**
     * Restituisce una stringa che verrà poi data come parametro alla view per essere stampata.
     *
     * @return
     */
    public String toPrint() {
        return checkerboard.stampa();
    }

    /**
     * <code>action</code> consente di posizionare un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
     * <code>checkerboard</code>.
     *
     * @param p
     * @param turno
     * @return
     */
    public boolean action(final int p, final boolean turno) throws IllegalPawnPlacementException {
        return turno ? this.checkerboard.putPawn(p, Pawn.Red) : this.checkerboard.putPawn(p, Pawn.Green);
    }

}
