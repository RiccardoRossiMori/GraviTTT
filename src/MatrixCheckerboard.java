import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

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
	//private  String brico;
	private CheckerboardVariables dimensioni;

	public MatrixCheckerboard(CheckerboardVariables s) {
		this.gameboard = new Pawn[s.getColumn()][s.getRow()];
		for(Pawn[] row: this.gameboard){
			Arrays.fill(row, Pawn.None);
		}
		this.setVariabiliDiGioco(s);
	}

	public boolean isItEmpty (int i, int j){
		return this.gameboard[i][j]==Pawn.None?true:false;	//TODO Deve essere qui o altrove? verifica
	}

	/*public void stampa(){
		toPrint((i,j) -> (CheckerboardManager.isItEmpty(i,j)?GraviTTTConsoleView.NONE:this.gameboard[i][j]==Pawn.Red?GraviTTTConsoleView.RED:GraviTTTConsoleView.GREEN));
	}

	public Character toPrint (BiFunction<Integer,Integer,Character> smacco){	//TODO Implementa la stampa della Checkerboard come si deve
		for (int i=0;i<dimensioni.getRow();i++){
			brico = String.format("%3d ",(i+1));
			for (int j=0;j<dimensioni.getColumn();j++){
				brico += String.format("| %c ", smacco.apply(i, j));
			}
		}
		return "";
	}
*/

	@Override
	public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacement {
		if (p > dimensioni.getColumn() || p<0) {
			 throw new IllegalPawnPlacement();
		}
		int x = 0;
		// x=metodo che mi da la riga nella colonna
		gameboard[x][p] = disco;
		//TODO controlla quì le condizioni di vincita con <code>pawnNeighbor</code>
		return true;
	}

	@Override
	public int gravity(int column) {
		int i =0;
		while (true) {
			System.out.println(i+" questo è i "+column+" e questa la colonna" +gameboard[i][column] +" e questo è il valore nella casella");
			if (gameboard[i][column] == Pawn.None) {
				return i;
			} else
				i++;
		}
	}
/*	public static void main(String argv[]) throws IllegalPawnPlacement {
		CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
		MatrixCheckerboard matrixCheckerboard = new MatrixCheckerboard(dimensioni);
		matrixCheckerboard.putPawn(1,Pawn.Red);
		int x=matrixCheckerboard.gravity(1);
		assert x==0: "Perfetto!";
		System.out.println(x + " valore restituito");
	}*/

	@Override
	public List<Pawn> pawnNeighbor(Pawn p) {//TODO Implementa il metodo, il tipo di ritorno deve essere una lista? verificalo.

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
