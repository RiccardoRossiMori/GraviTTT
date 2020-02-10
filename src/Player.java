import java.io.IOException;

/**
 * 
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un <code>Player</code>.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface Player {
	public int strategy() throws NumberFormatException, IOException;
	public String stampa();
}
