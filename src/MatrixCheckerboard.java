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
	private CheckerboardVariables dimensioni;

	public MatrixCheckerboard(CheckerboardVariables s) {
		this.gameboard = new Pawn[s.getColumn()][s.getRow()];
		this.setVariabiliDiGioco(s);
	}

	@Override
	public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacement {
		if (p > dimensioni.getColumn() || p<0) {
			 throw new IllegalPawnPlacement();
		}
		int x = 0;
		// x=metodo che mi da la riga nella colonna
		gameboard[x][p] = disco;
		return true;
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

	/**
	 * @return the variabiliDiGioco
	 */
	public CheckerboardVariables getVariabiliDiGioco() {
		return dimensioni;
	}

	/**
	 * @param variabiliDiGioco the variabiliDiGioco to set
	 */
	private void setVariabiliDiGioco(CheckerboardVariables variabiliDiGioco) {
		this.dimensioni = variabiliDiGioco;
	}

}
