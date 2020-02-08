import java.util.List;

/**
 * 
 * <b> Responsabilità: </b> Memorizzare una scacchiera sotto forma di matrice.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class MatrixCheckerboard implements Checkerboard {

	public Pawn[][] gameboard;

	public MatrixCheckerboard(CheckerboardVariables s) {
		this.gameboard = new Pawn[s.getColumn()][s.getRow()];
	}

	@Override
	public void putPawn(int p, Pawn disco) {
		// x=metodo che mi da la riga nella colonna
		gameboard[0][p] = disco;
	}

	@Override
	public int gravity(int column) {
		int i = 0;
		while (true) {
			if (gameboard[i][column] == Pawn.None) {
				return i;
			} else
				i++;
		}
	}

	@Override
	public List<Pawn> pawnNeighbor(Pawn p) {

		// TODO Auto-generated method stub
		return null;
	}

}
