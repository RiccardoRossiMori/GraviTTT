/**
 * 
 * <b>Responsabilità: </b>Gestisce la partita di due giocatori.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GameManager implements GameManagerInterface {
	/*
	 * TODO definisci un flusso di computazione 
	 * TODO gestione turni 
	 * TODO sistemare la faccenda delle dimensioni (essenzialmente come fare a prendere il valore del numero di righe e colonne) 
	 * TODO "getRigaBassa" per sapere dove mettere la pedina nella colonna x 
	 * TODO posizionamento di una pedina in una colonna 
	 * TODO implementa i factory method per i <code>PlayerFactory</code> 
	 * TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie 
	 * TODO gestione eccezioni (creale attraverso i test)
	 */
	private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
	private MatrixCheckerboard checkerboard;

	/**
	 * Gestisce il cambio turno durante una partita.
	 */
	@Override
	public void cambioTurno() {

	}

	public void instanzioCose() {
		this.setCheckerboard(new MatrixCheckerboard(dimensioni));
	}

	/**
	 * @return the checkerboard
	 */
	public MatrixCheckerboard getCheckerboard() {
		return checkerboard;
	}

	/**
	 * @param checkerboard the checkerboard to set
	 */
	private void setCheckerboard(MatrixCheckerboard checkerboard) {
		this.checkerboard = checkerboard;
	}

}
