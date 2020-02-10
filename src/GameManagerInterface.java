import java.io.IOException;
import java.util.List;

/**
 * 
 * <b>Responsabilità: </b>Gestisce una partita tra due giocatori.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface GameManagerInterface {

    MatrixCheckerboard getScacchiera();

    void cambioTurno();
	//List<? extends Player> scegliGiocatori() throws IOException;
	
	
}
