/**
 * 
 * <b>Responsabilità: </b>Inizializzare una partita tra due <code>Player</code> ed una <code>Checkerboard</code> 
 * con variabili standard, ossia una scacchiera con 6 righe e 7 colonne limitata esteriormente.
 * 
 */

import java.io.IOException;
import java.util.function.Function;

/**
 * @author Riccardo Rossi Mori
 *
 */
public class StartGameDefault implements StartGameInterface{
	
	public CheckerboardVariables dimensioni=CheckerboardVariables.DEFAULT_SIZE;
	public GameManager gameManager;




	@Override
	public void setSize(int i, int j, boolean flag) {
		this.dimensioni=new CheckerboardVariables(i, j, flag);
	}
	/**
	 *
	 * Inizializza le variabili di gioco
	 * @throws IOException
	 *
	 */
	@Override
	public void init() throws IOException {// TODO Sistema variabili in modo decente
		gameManager=new GameManager(new MatrixCheckerboard(dimensioni));
		gameManager.vista= new GraviTTTConsoleView();
	}
	/**
	 *
	 * Instanzia un particolare Player a seconda della stringa inserita.
	 * Se si scrive 'bot' verrà instanziato un Player di tipo RandomPlayer, che eseguirà ogni
	 * mossa casualmente, mentre se si scriverà una qualunque altra cosa verrà instanziato un
	 * Player di tipo InteractivePlayer, ossia un giocatore Interattivo.
	 *
	 * @param giocatorenumerox
	 * @return
	 * @throws IOException
	 */
	@Override
	public Player scegliGiocatori1(String giocatorenumerox) throws IOException {
		//List<Player> giocatori=null;
		String tipodigiocatorescelto; //x= vista.getStringPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		tipodigiocatorescelto= gameManager.vista.getStringPlayer(giocatorenumerox+" giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		//getPlayerFactory(x.toLowerCase());
		return getPlayerFactory(tipodigiocatorescelto.toLowerCase()).apply(tipodigiocatorescelto.toLowerCase());
		//giocatori.add(getPlayerFactory(x)); //giocatori.add(y.toLowerCase()); //return giocatori;
	}
	/**
	 *
	 * getPlayerFactory, presa una stringa, instanzia un giocatore del tipo richiesto.
	 *
	 * @param string
	 * @return
	 */

	private static Function<String,Player> getPlayerFactory(String string) {
		if (string.equals("bot")) {
			return p -> new RandomPlayer();
		}
		return (p -> new InteractivePlayer());
	}

}
