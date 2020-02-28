package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTView;

import java.io.IOException;


/**
 * <b>Responsabilità: </b>Gestisce la partita di due giocatori, dunque:
 * -permette di inserire pedine
 * -cambio turni
 * -conclude il gioco in caso di vincita di un giocatore.
 *
 * @author Riccardo Rossi Mori
 */
public class GameManager implements GameManagerInterface {
    private GraviTTTView view;
    private Player player1, player2;
    private final StartGameInterface startGameInterface;
    private final CheckerboardManager checkerboardManager;
    private boolean winner, turn;

    /*
     * TODO Scrivi test per le eccezioni
     * TODO Scrivi test per partite vinte da giocatore uno o due.
     * TODO verifica di rispettare i principi "L" ed "I" dei principi SOLID
     * TODO refactoring variabili e metodi in modo che sia tutto in una lingua unica (inglese o italiano)
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
    public void swapTurn() {
        this.turn = !turn;
    }

    /**
     * Ritorna il valore del turno.
     *
     * @return turno value.
     */
    public boolean isTurn() {
        return this.turn;
    }

    /**
     * Restituisce, a seconda del turno, il giocatore uno oppure il giocatore 2.
     *
     * @return giocatore1|giocatore2
     */
    private Player getActualPlayer() {
        return this.turn ? this.player1 : this.player2;
    }

    /**
     * Gestisce una o più partite consecutive tra due giocatori.
     *
     * @throws IOException
     */
    @Override
    public void play() throws IOException {
        this.start();
        this.match();
        this.conclusion();
    }


    /**
     * Richiede ed instanzia i due giocatori per la partita.
     *
     * @throws IOException
     */
    private void start() throws IOException {
        startGameInterface.init(this);
        this.player1 = startGameInterface.getPlayer("Primo");
        this.player2 = startGameInterface.getPlayer("Secondo");
    }

    /**
     * Gestisce la singola partita cedendo il turno ad un giocatore o all'altro.
     *
     * @throws IOException
     */
    private void match() throws IOException {
        this.turn = true;
        this.status();
        while (!this.winner) {
            this.sendMessage("Ora è il turno del " + (this.turn ? "giocatore uno " : "giocatore due") + "\n");
            this.winner = this.move();
            this.status();
            if (!this.winner)
                this.swapTurn();
        }
    }

    /**
     * Gestisce la singola mossa, ritornando true solo se l'ultima mossa è stata vincente.
     *
     * @return winner
     * @throws IOException
     */
    private boolean move() throws IOException {
        try {
            return this.winner = this.checkerboardManager.action(this.getActualPlayer().strategy(), this.turn);
        } catch (final IllegalPawnPlacementException i) {
            this.sendMessage("Errore, colonna non valida!");
            this.turn =!this.turn;
        } catch (final NumberFormatException n) {
            this.sendMessage("Errore: inserire un numero!");
            this.turn =!this.turn;
        }
        return this.winner;
    }

    /**
     * Stampa a video il vincitore della partita.
     */
    private void conclusion() {
        this.sendMessage("La vittoria è del " + (this.turn ? "giocatore uno " : "giocatore due") + "\n");
    }

    /**
     * Presa una stringa in ingresso, la invia alla view per stamparla a video.
     *
     * @param string
     */
    @Override
    public void sendMessage(final String string) {
        view.printMessage(string);
    }

    /**
     * Ha il compito di chiedere alla view una stampa aggiornata della tabella di gioco.
     */
    private void status() {
        view.printCheckerboard(
                checkerboardManager.getCheckerboard().checkerboardToString());
    }

    @Override
    public GraviTTTView getView() {
        return this.view;
    }

    public void setView(GraviTTTView view) {
        this.view = view;
    }

    /**
     * Chiede alla view un input intero e lo ritorna.
     *
     * @return l'input preso dalla view.
     * @throws IOException
     */
    @Override
    public int getterIntegerInput() throws IOException {
        return this.view.getIntInput();
    }
}
