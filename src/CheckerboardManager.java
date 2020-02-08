/**
 * 
 * <b> Responsabilità: </b> Gestire la scacchiera (posizionare una pedina, )
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */

public class CheckerboardManager {

	/*
	//TODO definisci un flusso di computazione
	//TODO gestione turni
	//TODO sistemare la faccenda delle dimensioni (essenzialmente come fare a prendere il valore del numero di righe e colonne)
	//TODO "getRigaBassa" per sapere dove mettere la pedina nella colonna x
	//TODO posizionamento di una pedina in una colonna
	//TODO implementa i factory method per i <code>PlayerFactory</code>
	//TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie
	//TODO gestione eccezioni (creale attraverso i test)
	 */

	private MatrixCheckerboard checkerboard;
	private CheckerboardVariables dimensioni= CheckerboardVariables.DEFAULT_SIZE;
	
	/**
	 * 
	 * Costruttore di default che permette di instanziare una <code>MatrixCheckerboard</code> con 6 righe e 7 colonne
	 * con il valore di <code>limitation</code> settato a true, ovvero la scacchiera ha i bordi esterni e non è
	 * possibile vincere sfruttando l'adiacenza tra bordo sinistro e bordo destro. 
	 * 
	 */
	public CheckerboardManager() {
		this.checkerboard = new MatrixCheckerboard(dimensioni);
	}
	
	/**
	 * 
	 * Costruttore che permette di instanziare una <code>MatrixCheckerboard</code> con <code>i</code> righe e <code>j</code> colonne
	 * con il valore di <code>limitation</code> settato a <code>flag</code>, dove con true si intende che la scacchiera ha dei bordi
	 * e con false si intende che la scacchiera non abbia i suddetti limiti esterni, per cui si può (o meno) vincere sfruttando
	 * l'adiacenza del bordo destro e bordo sinistro.
	 * 
	 * @param i
	 * @param j
	 * @param flag
	 */
	
	public CheckerboardManager(int i, int j, boolean flag) {
		this.checkerboard = new MatrixCheckerboard(new CheckerboardVariables(i, j, flag));
	}
	
	/**
	 * 
	 * <code>action</code> consente di posizionare un <code>Pawn</code> (pedina/disco) nella colonna <code>p</code> della scacchiera
	 * <code>checkerboard</code>.
	 * 
	 * @param p
	 */
	public void action (int p) {
		//TODO implementare il metodo
		Pawn disco= Pawn.Green;
		checkerboard.putPawn(p, disco);
	}

}
