package com.github.RiccardoRossiMori.GraviTTT.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b>Responsabilit�: </b> Gestisce la strategia di un giocatore interattivo.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class InteractivePlayer implements Player {
    /**
     *
     * Implementa la strategia di gioco di un giocatore interattivo, per tanto
     * chieder� in input un valore intero corrispondente alla colonna nella quale
     * verr� posizionata la pedina.
     * @return
     * @throws IOException
     * @throws NumberFormatException
     *
     */
    @Override
    //TODO cambia implementazione in modo che l'input non dipendi da questa classe
    public int strategy() throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int colonna = Integer.parseInt(read.readLine())-1;
        return colonna;
    }

    /*@Override
    public String stampa() {
        return "com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer";
    }*/

}
