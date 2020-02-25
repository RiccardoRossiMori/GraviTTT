package com.github.RiccardoRossiMori.GraviTTT.Controller;


import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Pawn;

/**
 * <b> Responsabilit�: </b> Gestire la scacchiera (posizionare una pedina, )
 *
 * @author Riccardo Rossi Mori
 *
 */

public class CheckerboardManager {
    private Checkerboard checkerboard;

    public CheckerboardManager(Checkerboard checkerboard) {
        this.checkerboard = checkerboard;
    }

    /**
     * Ritorna la tabella di gioco.
     * @return the checkerboard
     */
    public Checkerboard getCheckerboard() {
        return this.checkerboard;
    }

    /**
     * Restituisce una stringa che verrà poi data come parametro alla view per essere stampata.
     *
     * @return
     */
    public String toPrint(){
        return this.checkerboard.stampa();
    }

    /**
     *
     * <code>action</code> consente di posizionare un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
     * <code>checkerboard</code>.
     *
     * @param p
     * @param turno
     * @return
     */
    public boolean action(int p, boolean turno) throws IllegalPawnPlacementException {
        //ODO implementare il metodo
        //com.github.RiccardoRossiMori.GraviTTT.GameManagerInterface.getCheckerboard().putPawn(p,com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red);
        //com.github.RiccardoRossiMori.GraviTTT.Model.Pawn disco= com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Green;
        //	checkerboard.putPawn(p, disco);
        return turno ? checkerboard.putPawn(p, Pawn.Red) : checkerboard.putPawn(p, Pawn.Green);
    }

}
