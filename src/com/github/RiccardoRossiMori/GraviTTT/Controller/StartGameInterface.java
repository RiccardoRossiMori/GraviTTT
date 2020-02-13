package com.github.RiccardoRossiMori.GraviTTT.Controller; /**
 * 
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>com.github.RiccardoRossiMori.GraviTTT.Model.Player</code> con una <code>com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard</code>.
 * 
 */

import com.github.RiccardoRossiMori.GraviTTT.Model.Player;

import java.io.IOException;

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface StartGameInterface {
	
	void setSize(int i, int j, boolean flag);

    void init() throws IOException;

    Player scegliGiocatori1(String giocatorenumerox) throws IOException;
}
