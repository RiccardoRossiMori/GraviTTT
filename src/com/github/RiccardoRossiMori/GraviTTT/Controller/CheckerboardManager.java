package com.github.RiccardoRossiMori.GraviTTT.Controller;


import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Pawn;

/**
 * <b> Responsabilità: </b> Gestire la scacchiera (posizionare una pedina, )
 *
 * @author Riccardo Rossi Mori
 */

public class CheckerboardManager implements CheckerboardManagerInterface {
    private final Checkerboard checkerboard;

    public CheckerboardManager(final Checkerboard checkerboard) {
        this.checkerboard = checkerboard;
    }

    /**
     * Ritorna la tabella di gioco.
     *
     * @return the checkerboard
     */
    @Override
    public Checkerboard getCheckerboard() {
        return checkerboard;
    }

    /**
     * <code>action</code> consente di posizionare un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
     * <code>checkerboard</code>.
     *
     * @param p
     * @param turn
     * @return
     */
    @Override
    public boolean action(final int p, final boolean turn) throws IllegalPawnPlacementException {
        return turn ? this.checkerboard.putPawn(p, Pawn.Red) : this.checkerboard.putPawn(p, Pawn.Green);
    }

}
