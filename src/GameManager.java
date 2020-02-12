import java.io.IOException;
//import java.util.List;
import java.util.function.Function;


/**
 * 
 * <b>Responsabilità: </b>Gestisce la partita di due giocatori, dunque:
 * 	-inserire pedine
 * 	-cambio turni
 * 	-conclude il gioco in caso di vincita di un giocatore.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GameManager implements GameManagerInterface {
	/*
	 * TODO Implementa le condizioni di vincita
	 * TODO Implementa la stampa del campo di gioco
	 * TODO Implementa il posizionamento delle pedine
	 * TODO definisci un flusso di computazione (scrivi i metodi senza elaborare troppo)
	 * TODO ("getRigaBassa") implementa <code>gravity</code> per sapere dove mettere la pedina nella colonna x 
	 * TODO posizionamento di una pedina in una colonna
	 * TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie 
	 * TODO gestione eccezioni (create attraverso i test)
	 */
	private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
	private CheckerboardManager checkerboardManager;
	private MatrixCheckerboard scacchiera;
	private GraviTTTView vista;
	private boolean winner, turno;
	private Player giocatore1;
	private Player giocatore2;

	/**
	 * 
	 * getPlayerFactory, presa una stringa, instanzia un giocatore del tipo richiesto.
	 * 
	 * @param string
	 * @return
	 */
	
	private static Function<String,Player> getPlayerFactory(String string) {// TODO spostare in StartGameDefault
		if (string.equals("bot")) {
			return p -> new RandomPlayer();
		}
		return (p -> new InteractivePlayer());
	}

	/**
	 * Gestisce il cambio turno durante una partita.
	 */
	@Override
	public void cambioTurno() {
		this.turno = !turno;
	}

	/**
	 *
	 * Inizializza le variabili di gioco
	 * @throws IOException
	 *
	 */
	private void init() throws IOException {// TODO spostare in StartGameDefault
		vista= new GraviTTTConsoleView();
		this.setScacchiera(new MatrixCheckerboard(dimensioni));
		checkerboardManager=new CheckerboardManager(scacchiera);
		winner = false;
		turno = true;
		giocatore1 = scegliGiocatori1("Primo");
		giocatore2 = scegliGiocatori1("Secondo");
	}

	/**
	 *
	 * Restituisce, sotto forma di booleano, il turno del giocatore 1 o del giocatore 2.
	 *
	 * @return
	 */

	private Player getGiocatore() {
		return turno ? giocatore1 : giocatore2;
	}

	public void main() throws IOException, IllegalPawnPlacement {//TODO forse da spostare in StartGameDefault
		this.init();
		int i=0;
		while (/*!winner*/i<4) {
			vista.printCheckerboard(scacchiera);
			i++;
			winner = checkerboardManager.action(getGiocatore().strategy(),turno);
			//if(!winner)	//TODO questo if è disabilitato poiché non è ancora stata implementata la vincita della partita
				cambioTurno();
		}
		System.out.println(getGiocatore().stampa());// sarebbe essenzialmente la stampa del giocatore vincitore
	}

	/**
	 * @return the checkerboard
	 */
	@Override
	public MatrixCheckerboard getScacchiera() {
		return scacchiera;
	}//TODO verifica se lasciare la scacchiera (e relativo metodo) in questa classe o in MatrixCheckerboard

	/**
	 * @param scacchiera the checkerboard to set
	 */
	private void setScacchiera(MatrixCheckerboard scacchiera) {
		this.scacchiera = scacchiera;
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
	//verride
	public Player scegliGiocatori1(String giocatorenumerox) throws IOException {	// TODO spostare in StartGameDefault
		//List<Player> giocatori=null;
		String tipodigiocatorescelto; //x= vista.getStringPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		tipodigiocatorescelto= vista.getStringPlayer(giocatorenumerox+" giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		//getPlayerFactory(x.toLowerCase()); //TODO refactoring del codice, instanzio ma non ho il riferimento all'oggetto... pointless!
		return getPlayerFactory(tipodigiocatorescelto.toLowerCase()).apply(tipodigiocatorescelto.toLowerCase());
		//giocatori.add(getPlayerFactory(x)); //giocatori.add(y.toLowerCase()); //return giocatori;	//TODO refactoring del codice, ho fatto un cut & paste!
	}
}
