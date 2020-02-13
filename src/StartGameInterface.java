/**
 * 
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>Player</code> con una <code>Checkerboard</code>.
 * 
 */

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
