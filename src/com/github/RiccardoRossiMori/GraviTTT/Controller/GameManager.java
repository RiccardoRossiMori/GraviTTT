package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
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
 */
public class GameManager implements GameManagerInterface {
    private GraviTTTView vista;
    private Player giocatore1, giocatore2;
    /*
     * TODO verifica di rispettare i principi "L" ed "I" dei principi SOLID
     * TODO implementa il codice in RandomPlayerFactory e InteractivePlayerFactory se necessario (controlla)
     * TODO refactoring del codice, sposta il main e tutto ciò che non è compito del GameManager
     * TODO lanciare e gestire le eccezioni dove necessario
     * TODO refactoring variabili e metodi in modo che sia tutto in una lingua unica (inglese o italiano)
     * TODO Creare Test per le diverse parti di codice
     * TODO gestire IllegalInputException (voglio int, mi danno char o String)
     * TODO implementa partite continue
     * TODO possibile implementazione del design pattern "strategy" per le strategie dei player... per ora rimane ipotesi
     */
    private StartGameInterface startGameInterface;// private CheckerboardVariables dimensioni //  private MatrixCheckerboard checkerboard;

    public CheckerboardManager getCheckerboardManager() {
        return checkerboardManager;
    }

    private CheckerboardManager checkerboardManager;
    private boolean winner;

    public boolean isTurno() {
        return turno;
    }

    private boolean turno;

    public GameManager(MatrixCheckerboard matrixCheckerboard) {
        this.startGameInterface = new StartGameDefault();
        //this.dimensioni = CheckerboardVariables.DEFAULT_SIZE;//TODO controlla se puoi eliminare le due righe commentate
        //this.setCheckerboard(matrixCheckerboard);
        this.checkerboardManager = new CheckerboardManager(matrixCheckerboard);
        this.winner = false;
    }


    /**
     * Gestisce il cambio turno durante una partita.
     */
    @Override
    public void cambioTurno() {
        this.turno = !turno;
    }


    /**
     * Restituisce, a seconda del turno, il giocatore uno oppure il giocatore 2.
     *
     * @return giocatore1|giocatore2
     */

    private Player getGiocatore() {
        return turno ? giocatore1 : giocatore2;
    }

    /**
     * Gestisce una o più partite consecutive tra due giocatori.
     *
     * @throws IOException
     * @throws IllegalPawnPlacementException
     */
    @Override
    public void play() throws IOException, IllegalPawnPlacementException {
        //inizializzazione partita
        this.start();
        //while (partita){
        //gestione partita
        this.partita();
        //stampa vincitore
        this.conclusione();
        //voglioGiocareAncora?partita=true:partita=false;}
        //TODO chiedi se si vuole giocare un'altra partita.
    }

    /**
     * Richiede ed instanzia i due giocatori per la partita.
     *
     * @throws IOException
     */
    private void start() throws IOException {
        startGameInterface.init(this);
        this.giocatore1 = startGameInterface.scegliGiocatori("Primo");
        this.giocatore2 = startGameInterface.scegliGiocatori("Secondo");
    }

    /**
     * Gestisce la singola partita cedendo il turno ad un giocatore o all'altro.
     *
     * @throws IOException
     */
    private void partita() throws IOException {
        this.turno = true;
        this.status();
        while (!winner) {
            this.sendMessage("Ora è il turno del " + (this.turno ? "giocatore uno " : "giocatore due") + "\n");
            try {
                winner = checkerboardManager.action(getGiocatore().strategy(this.checkerboardManager), turno);//TODO trova soluzione più semplice ed efficace (?)
            } catch (IllegalPawnPlacementException i) {
                this.sendMessage("Errore, colonna non valida!");
                continue;
            }
            this.status();
            if (!winner)
                cambioTurno();
        }
    }

    private void conclusione() {
        this.sendMessage("La vittoria è del " + (this.turno ? "giocatore uno " : "giocatore due") + "\n");
    }

    /**
     * Presa una stringa in ingresso, la invia alla view per stamparla a video.
     *
     * @param string
     */
    private void sendMessage(String string) {//TODO creare un metodo public in interface per ereditare il metodo obbligatoriamente
        vista.printMessage(string);
    }

    /**
     * Ha il compito di chiedere alla view una stampa aggiornata della tabella di gioco.
     */
    private void status() {
        vista.printCheckerboard(checkerboardManager.toPrint());
    }


    public void setVista(GraviTTTView vista) {
        this.vista = vista;
    }

    public GraviTTTView getVista() {
        return this.vista;
    }
}
