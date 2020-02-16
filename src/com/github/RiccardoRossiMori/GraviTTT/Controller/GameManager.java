package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTView;

import java.io.IOException;


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
     * TODO gestione eccezioni (create attraverso i test)
     * TODO refactoring variabili e metodi in modo che sia tutto in una lingua unica (inglese o italiano)
     */
    private StartGameInterface startGameInterface ;// private CheckerboardVariables dimensioni //  private MatrixCheckerboard checkerboard;

   public CheckerboardManager getCheckerboardManager() {
        return checkerboardManager;
    }

    private CheckerboardManager checkerboardManager ;
    private boolean winner , turno;

    public GameManager(MatrixCheckerboard matrixCheckerboard) {
        this.startGameInterface = new StartGameDefault();
        //this.dimensioni = CheckerboardVariables.DEFAULT_SIZE;//TODO controlla se puoi eliminare le due righe commentate
        //this.setCheckerboard(matrixCheckerboard);
        this.checkerboardManager = new CheckerboardManager(matrixCheckerboard);
        this.winner = false;
        this.turno = true;
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
     * Restituisce, a seconda del turno, il giocatore uno oppure il giocatore 2.
     *
     * @return giocatore1|giocatore2
     */

    private Player getGiocatore() {
        return turno ? giocatore1 : giocatore2;
    }

    public void main() throws IOException, IllegalPawnPlacementException {//TODO spostare in un com.github.RiccardoRossiMori.GraviTTT.main o in startGameDefault
        startGameInterface.init(this);
        this.giocatore1 = startGameInterface.scegliGiocatori1("Primo");
        this.giocatore2 = startGameInterface.scegliGiocatori1("Secondo");
        System.out.println(this.giocatore1 + " giocatore1" + this.giocatore2 + " giocatore2");
        int i = 0;
        while (/*!winner*/i < 20) {
            vista.printCheckerboard(checkerboardManager.printCheckerboard());
            //TODO stampa di chi è il turno.
            i++;
            System.out.println( "Ora è il turno del " + (this.turno?"giocatore uno ":"giocatore due" )+"\n");
            winner = checkerboardManager.action(getGiocatore().strategy(this.checkerboardManager), turno);//TODO trova soluzione più semplice ed efficace (?)
          //  if(!winner)
                cambioTurno();
        }
        vista.printCheckerboard(checkerboardManager.printCheckerboard());//TODO refactoring codice, ho fatto copia incolla
        System.out.println(getGiocatore().stampa());// sarebbe essenzialmente la stampa del giocatore vincitore
    }

    /*
     * @return the checkerboard
     */
 /*   @Override
    public MatrixCheckerboard getCheckerboard() {
        return checkerboard;
    }//TODO sposta in com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard*/

    /*
     * @param checkerboard the checkerboard to set
     */
   /* private void setCheckerboard(MatrixCheckerboard checkerboard) {
        this.checkerboard = checkerboard;
    }*/


    public void setVista(GraviTTTView vista) {
        this.vista = vista;
    }

    public GraviTTTView getVista() {
        return this.vista;
    }
}
