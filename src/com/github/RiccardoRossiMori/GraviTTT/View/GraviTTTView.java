package com.github.RiccardoRossiMori.GraviTTT.View;

import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.IOException;

/**
 * <b>Responsabilità: </b>Gestisce una vista generica sul gioco.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GraviTTTView {

    void printMessage(String message);

    String getStringPlayer(String message) throws IOException;

    void printCheckerboard(String scacchiera);

}
