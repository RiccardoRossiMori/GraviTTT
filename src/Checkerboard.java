/**
 * 
 * <b> Responsabilità: </b> Memorizzare una scacchiera.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public interface Checkerboard {



	/**
	 * 
	 * Prova ad inserire un <code>Pawn</code> nella colonna <code>p</code>.
	 * 
	 * @param p
	 * @param disco
	 * @throws IllegalPawnPlacement
	 * @return
	 */
	public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacement;

	boolean vincitore(int i, int j);

	/**
	 * 
	 * Data una <code>column</code> restituisce la riga disponibile per posizionare la pedina.
	 * 
	 * @param column
	 * @return
	 */
	int gravity(int column);

	/**
	 *
	 * Si vuole andare a trovare le pedine circostanti dello stesso colore
	 * ricorsivamente per verificare che ve ne siano 4 consecutive e dichiarare
	 * quel giocatore come vincitore della partita.
	 *
	 * @return
	 */
	int pawnNeighbor();
}
