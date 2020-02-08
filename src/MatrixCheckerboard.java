import java.util.List;

/**
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class MatrixCheckerboard implements Checkerboard {

	public Pawn[][] gameboard;

	public MatrixCheckerboard(CheckerboardSize s) {
		this.gameboard = new Pawn[s.getColumn()][s.getRow()];
	}

	@Override
	public void putPawn(int p, Pawn disco) {
		// x=metodo che mi da la riga nella colonna
		gameboard[0][p] = disco;
	}

	@Override
	public int freeRow(int column) {
		int i=0;
		while(true) {
			if(gameboard[i][column]==Pawn.None) {
				return i;
			}
			else i++;
		}
	}

	/**
	 * 
	 * Prendendo una pedina come riferimento (sapendo che essa sia di un colore)
	 * si vuole andare a trovare le pedine circostanti dello stesso colore
	 * ricorsivamente per verificare che ve ne siano 4 consecutive e dichiarare 
	 * quel giocatore come vincitore della partita.
	 * 
	 * @param Pawn p
	 */
	@Override
	public List<Pawn> pawnNeighbor(Pawn p) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
