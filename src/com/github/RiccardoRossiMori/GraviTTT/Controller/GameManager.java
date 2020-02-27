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
 *
 * @author Riccardo Rossi Mori
 */
public class GameManager implements GameManagerInterface {
    private GraviTTTView vista;
    private Player giocatore1, giocatore2;
    private final StartGameInterface startGameInterface;
    private final CheckerboardManager checkerboardManager;
    private boolean winner, turno;

    /*
     * TODO verifica di rispettare i principi "L" ed "I" dei principi SOLID
     * TODO refactoring variabili e metodi in modo che sia tutto in una lingua unica (inglese o italiano)
     * TODO Creare Test per le diverse parti di codice
     * TODO implementa partite continue
     * TODO possibile implementazione del design pattern "strategy" per le strategie dei player... per ora rimane ipotesi
     */
    public GameManager(MatrixCheckerboard matrixCheckerboard) {
        this.startGameInterface = new StartGameDefault();
        this.checkerboardManager = new CheckerboardManager(matrixCheckerboard);
        this.winner = false;
    }

    /**
     * Ritorna il manager della tabella di gioco.
     *
     * @return
     */
    @Override
    public CheckerboardManager getCheckerboardManager() {
        return checkerboardManager;
    }

    /**
     * Gestisce il cambio turno durante una partita.
     */
    @Override
    public void cambioTurno() {
        this.turno = !turno;
    }

    /**
     * Ritorna il valore del turno.
     *
     * @return turno value.
     */
    public boolean isTurno() {
        return this.turno;
    }

    /**
     * Restituisce, a seconda del turno, il giocatore uno oppure il giocatore 2.
     *
     * @return giocatore1|giocatore2
     */
    private Player getGiocatore() {
        return this.turno ? this.giocatore1 : this.giocatore2;
    }

    /**
     * Gestisce una o più partite consecutive tra due giocatori.
     *
     * @throws IOException
     */
    @Override
    public void play() throws IOException {
        this.start();
        this.partita();
        this.conclusione();
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
        while (!this.winner) {
            this.sendMessage("Ora è il turno del " + (this.turno ? "giocatore uno " : "giocatore due") + "\n");
            this.winner = this.mossa();
            this.status();
            if (!this.winner)
                this.cambioTurno();
        }
    }

    /**
     * Gestisce la singola mossa, ritornando true solo se l'ultima mossa è stata vincente.
     *
     * @return winner
     * @throws IOException
     */
    private boolean mossa() throws IOException {
        try {
            return this.winner = this.checkerboardManager.action(this.getGiocatore().strategy(), this.turno);//TODO trova soluzione più semplice ed efficace (?)
        } catch (final IllegalPawnPlacementException i) {
            this.sendMessage("Errore, colonna non valida!");
            this.turno =!this.turno;
        } catch (final NumberFormatException n) {
            this.sendMessage("Errore: inserire un numero!");
            this.turno =!this.turno;
        }
        return this.winner;
    }

    /**
     * Stampa a video il vincitore della partita.
     */
    private void conclusione() {
        this.sendMessage("La vittoria è del " + (this.turno ? "giocatore uno " : "giocatore due") + "\n");
    }

    /**
     * Presa una stringa in ingresso, la invia alla view per stamparla a video.
     *
     * @param string
     */
    @Override
    public void sendMessage(final String string) {
        vista.printMessage(string);
    }

    /**
     * Ha il compito di chiedere alla view una stampa aggiornata della tabella di gioco.
     */
    private void status() {
        vista.printCheckerboard(checkerboardManager.toPrint());
    }

    @Override
    public GraviTTTView getVista() {
        return this.vista;
    }

    public void setVista(GraviTTTView vista) {
        this.vista = vista;
    }

    /**
     * Chiede alla view un input intero e lo ritorna.
     *
     * @return l'input preso dalla view.
     * @throws IOException
     */
    @Override
    public int getterIntegerInput() throws IOException {
        return this.vista.getIntInput();
    }
}
