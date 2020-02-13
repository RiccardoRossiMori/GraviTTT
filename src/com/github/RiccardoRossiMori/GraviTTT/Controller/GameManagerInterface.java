package com.github.RiccardoRossiMori.GraviTTT.Controller;

/**
 * 
 * <b>Responsabilità: </b>Gestisce una partita tra due giocatori.
 * 
 */

import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GameManagerInterface {

    MatrixCheckerboard getScacchiera();

    void cambioTurno();
	//List<? extends com.github.RiccardoRossiMori.GraviTTT.Model.Player> scegliGiocatori() throws IOException;
	
	
}
