package com.github.RiccardoRossiMori.GraviTTT.Model;

import java.io.IOException;

/**
 * <b>Responsabilitą: </b>Gestisce la strategia di gioco di un
 * <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code>.
 */

/**
 * @author Riccardo Rossi Mori
 */
public interface Player {

    /**
     * Restituisce un intero che verrą poi preso come input
     * per mettere la pedina in una colonna.
     *
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    int strategy() throws NumberFormatException, IOException;
}
