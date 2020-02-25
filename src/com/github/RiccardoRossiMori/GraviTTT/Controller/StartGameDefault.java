package com.github.RiccardoRossiMori.GraviTTT.Controller;

import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;
import com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer;
import com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> ed una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>
 * con variabili standard, ossia una scacchiera con 6 righe e 7 colonne limitata esteriormente.
 *
 * @author Riccardo Rossi Mori
 */

public class StartGameDefault implements StartGameInterface {

    //private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
    private GameManager gameManager;

    /**
     * getPlayerFactory, presa una stringa, instanzia un giocatore del tipo richiesto.
     *
     * @param string
     * @return
     */
    private static Player getPlayerFactory(String string, CheckerboardManager checkerboardManager) {
        if (string.equals("bot")) {
            return new RandomPlayer(checkerboardManager);
        }
        return new InteractivePlayer();
    }

    /**
     * Inizializza le variabili di gioco
     *
     * @throws IOException
     */
    @Override
    public void init(GameManager gameManager) {// TODO Sistema variabili in modo decente
        this.gameManager = gameManager;
        //gameManager = new GameManager(new MatrixCheckerboard(dimensioni));
        gameManager.setVista(new GraviTTTConsoleView());
    }

    /**
     * Instanzia un particolare com.github.RiccardoRossiMori.GraviTTT.Model.Player a seconda della stringa inserita.
     * Se si scrive 'bot' verrà instanziato un com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer, che eseguirà ogni
     * mossa casualmente, mentre se si scriverà una qualunque altra cosa verrà instanziato un
     * com.github.RiccardoRossiMori.GraviTTT.Model.Player di tipo com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer, ossia un giocatore Interattivo.
     * Potrebbe essere lanciata una IOException poiché richiede degli input esterni.
     *
     * @param giocatoreNumeroX
     * @return Player
     * @throws IOException
     */
    @Override
    public Player scegliGiocatori(String giocatoreNumeroX) throws IOException {
        //List<com.github.RiccardoRossiMori.GraviTTT.Model.Player> giocatori=null;
        String tipoDiGiocatoreScelto; //x= vista.getStringPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
        tipoDiGiocatoreScelto = gameManager.getVista().getStringPlayer(giocatoreNumeroX + " giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
        //getPlayerFactory(x.toLowerCase());
        return getPlayerFactory(tipoDiGiocatoreScelto.toLowerCase(), gameManager.getCheckerboardManager());
        //giocatori.add(getPlayerFactory(x)); //giocatori.add(y.toLowerCase()); //return giocatori;
    }

}
