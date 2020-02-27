package com.github.RiccardoRossiMori.GraviTTT.Model;

import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManagerInterface;

import java.io.IOException;

/**
 * <b>Responsabilità: </b> Gestisce la strategia di un giocatore interattivo.
 */

/**
 * @author Riccardo Rossi Mori
 */
public class InteractivePlayer implements Player {
    GameManagerInterface gameManager;

    public InteractivePlayer(final GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Implementa la strategia di gioco di un giocatore interattivo, per tanto
     * chiederà in input un valore intero corrispondente alla colonna nella quale
     * verrà posizionata la pedina (in questa implementazione viene sottratto 1 a
     * tale numero poiché si ipotizza che nelle view le colonne partino da 1 e non
     * da 0 come nella tabella di gioco).
     *
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    @Override
    public int strategy() throws NumberFormatException, IOException {
        return this.gameManager.getterIntegerInput() - 1;
    }
}
