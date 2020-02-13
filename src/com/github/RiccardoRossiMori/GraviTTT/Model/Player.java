package com.github.RiccardoRossiMori.GraviTTT.Model;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code>.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface Player {
    public int strategy() throws NumberFormatException, IOException;

    public String stampa();
}
