package com.github.RiccardoRossiMori.GraviTTT.View;

import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.IOException;

/**
 * 
 * <b>Responsabilit�: </b>Gestisce una vista generica sul gioco.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GraviTTTView {

	String getStringPlayer(String message) throws IOException;
	void printCheckerboard(MatrixCheckerboard scacchiera);

}
