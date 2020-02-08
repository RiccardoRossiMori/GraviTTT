/**
 * 
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>Player</code> ed una <code>Checkerboard</code> 
 * con variabili standard, ossia una scacchiera con 6 righe e 7 colonne limitata esteriormente.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class StartGameDefault implements StartGameInterface{
	
	public CheckerboardVariables dimensioni;
	
	
	@Override
	public void setSize(int i, int j, boolean flag) {
		this.dimensioni=new CheckerboardVariables(i, j, flag);
	}

}
