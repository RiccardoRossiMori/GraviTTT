import java.io.IOException;
import java.util.List;

/**
 * 
 * <b>Responsabilit�: </b>Gestisce una partita tra due giocatori.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GameManagerInterface {

    MatrixCheckerboard getCheckerboard();

    void cambioTurno();
	//List<? extends Player> scegliGiocatori() throws IOException;
	
	
}
