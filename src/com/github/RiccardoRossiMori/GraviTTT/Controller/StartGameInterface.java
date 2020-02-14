package com.github.RiccardoRossiMori.GraviTTT.Controller; /**
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> con una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>.
 */

import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.Player;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface StartGameInterface {

    default <T extends CheckerboardVariables> CheckerboardVariables setSize(int i, int j, boolean flag) {//TODO chiedi a qualcuno se può andare scritto così
        return new CheckerboardVariables(i, j, flag);//metodo marginale, mai utilizzato, ma comunque implementato per estensioni future
    }
    void init(GameManager gameManager) throws IOException;

    Player scegliGiocatori1(String giocatorenumerox) throws IOException;
}
