package com.github.RiccardoRossiMori.GraviTTT.Model;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code>.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface Player {

    int strategy(CheckerboardManager checkerboardManager)throws NumberFormatException, IOException;

    String stampa();//TODO verifica se eliminare il metodo
}
