package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;

public interface CheckerboardManagerInterface {
    /**
     * Ritorna la tabella di gioco.
     *
     * @return the checkerboard
     */
    Checkerboard getCheckerboard();

    /**
     * <code>action</code> consente di posizionare un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
     * <code>checkerboard</code>.
     *
     * @param p
     * @param turn
     * @return
     */
    boolean action(int p, boolean turn) throws IllegalPawnPlacementException;
}
