package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTView;

import java.io.IOException;
//import java.util.List;


/**
 * <b>Responsabilità: </b>Gestisce la partita di due giocatori, dunque:
 * -inserire pedine
 * -cambio turni
 * -conclude il gioco in caso di vincita di un giocatore.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GameManager implements GameManagerInterface {
    private GraviTTTView vista;
    private Player giocatore1, giocatore2;
    /*
     * TODO Implementa le condizioni di vincita
     * TODO Implementa la stampa del campo di gioco
     * TODO Implementa il posizionamento delle pedine
     * TODO definisci un flusso di computazione (scrivi i metodi senza elaborare troppo)
     * TODO ("getRigaBassa") implementa <code>gravity</code> per sapere dove mettere la pedina nella colonna x
     * TODO posizionamento di una pedina in una colonna
     * TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie
     * TODO gestione eccezioni (create attraverso i test)
     */
    private StartGameInterface startGameInterface = new StartGameDefault();
    private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
    private MatrixCheckerboard scacchiera = new MatrixCheckerboard(dimensioni);
    private CheckerboardManager checkerboardManager = new CheckerboardManager(scacchiera);
    private boolean winner = false, turno = true;

    public GameManager(MatrixCheckerboard matrixCheckerboard) {
        this.setScacchiera(matrixCheckerboard);
    }


    /**
     * Gestisce il cambio turno durante una partita.
     */
    @Override
    public void cambioTurno() {
        this.turno = !turno;
    }


    /**
     *
     * Restituisce, sotto forma di booleano, il turno del giocatore 1 o del giocatore 2.
     *
     * @return
     */

    private Player getGiocatore() {
        return turno ? giocatore1 : giocatore2;
    }

    public void main() throws IOException, IllegalPawnPlacementException {//TODO spostare in un com.github.RiccardoRossiMori.GraviTTT.main o in startGameDefault
        startGameInterface.init();
        this.giocatore1 = startGameInterface.scegliGiocatori1("Primo");
        this.giocatore2 = startGameInterface.scegliGiocatori1("Secondo");
        System.out.println(this.giocatore1 + " giocatore1" + this.giocatore2 + " giocatore2");
        int i = 0;
        while (/*!winner*/i < 4) {
            //vista.printCheckerboard(scacchiera);
            //TODO stampa di chi è il turno.
            i++;
            System.out.println(this.getGiocatore() + " giocatore attuale");
            winner = checkerboardManager.action(getGiocatore().strategy(), turno);
            //if(!winner)	//TODO questo if è disabilitato poiché non è ancora stata implementata la vincita della partita
            cambioTurno();
        }
        System.out.println(getGiocatore().stampa());// sarebbe essenzialmente la stampa del giocatore vincitore
    }

    /**
     * @return the checkerboard
     */
    @Override
    public MatrixCheckerboard getScacchiera() {
        return scacchiera;
    }//TODO sposta in com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard

    /**
     * @param scacchiera the checkerboard to set
     */
    private void setScacchiera(MatrixCheckerboard scacchiera) {
        this.scacchiera = scacchiera;
    }


}
