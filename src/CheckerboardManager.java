/**
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class CheckerboardManager {
	//TODO definisci un flusso di computazione
	//TODO sistema le responsabilità
	//TODO gestione turni
	//TODO sistemare la faccenda delle dimensioni (essenzialmente come fare a prendere il valore del numero di righe e colonne)
	//TODO "getRigaBassa" per sapere dove mettere la pedina nella colonna x
	//TODO posizionamento di una pedina in una colonna
	//TODO implementa i factory method per i <code>PlayerFactory</code>
	//TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie
	//TODO gestione eccezioni (creale attraverso i test)

	private MatrixCheckerboard checkerboard;

	public CheckerboardManager(int i, int j) {
		this.checkerboard = new MatrixCheckerboard(new CheckerboardSize(i, j));
	}
	
	public void action (int p) {
		Pawn disco= Pawn.Green;
		checkerboard.putPawn(p, disco);
	}

}
