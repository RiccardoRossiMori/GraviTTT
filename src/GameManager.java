import java.io.IOException;
//import java.util.List;
import java.util.function.Function;


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
	 * TODO Configura la condivisione della scacchiera
	 * TODO definisci un flusso di computazione (scrivi i metodi senza elaborare troppo)
	 * TOD gestione turni 
	 * TODO sistemare la faccenda delle dimensioni (essenzialmente come fare a prendere il valore del numero di righe e colonne)... serve? 
	 * TODO ("getRigaBassa") implementa <code>gravity</code> per sapere dove mettere la pedina nella colonna x 
	 * TODO posizionamento di una pedina in una colonna 
	 * TODO implementa i factory method per i <code>PlayerFactory</code> 
	 * TODO implementare i player in modo da poter immettere una pedina secondo le varie strategie 
	 * TODO gestione eccezioni (create attraverso i test)
	 */
	private CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;
	private CheckerboardManager checkerboardManager;
	private MatrixCheckerboard checkerboard;
	private GraviTTTView vista;
	private boolean winner, turno;
	private Player giocatore1;
	private Player giocatore2;

	private static Function<String,Player> getPlayerFactory(String string) {
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
	private void init() throws IOException {
		/* scegliGiocatori1(); */
		checkerboardManager=new CheckerboardManager(dimensioni.getRow(),dimensioni.getColumn(),dimensioni.isLimited());
		giocatore1 = new InteractivePlayer();
		giocatore2 = new InteractivePlayer();
		this.setCheckerboard(new MatrixCheckerboard(dimensioni));
		vista= new GraviTTTConsoleView();
		winner = false;
		turno = true;
	}

	private Player getGiocatore() {
		return turno ? giocatore1 : giocatore2;
	}

	public void provaMain() throws IOException, IllegalPawnPlacement {
		this.init();
		while (!winner) {

			winner = checkerboardManager.action(getGiocatore().strategy(),turno);
			if(!winner)cambioTurno();
		}
		getGiocatore().toString();// sarebbe essenzialmente la stampa del giocatore vincitore
	}

	/**
	 * @return the checkerboard
	 */
	@Override
	public MatrixCheckerboard getCheckerboard() {
		return checkerboard;
	}

	/**
	 * @param checkerboard the checkerboard to set
	 */
	private void setCheckerboard(MatrixCheckerboard checkerboard) {
		this.checkerboard = checkerboard;
	}

	//verride
	public void scegliGiocatori1() throws IOException {
		// TODO Auto-generated method stub
		//List<Player> giocatori=null;
		String x,y;
		x= vista.getPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		y= vista.getPlayer("Secondo giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		getPlayerFactory(x.toLowerCase()); //TODO refactoring del codice, instanzio ma non ho il riferimento all'oggetto... pointless!
		getPlayerFactory(y.toLowerCase());
		//giocatori.add(getPlayerFactory(x));
		//giocatori.add(y.toLowerCase());	//TODO refactoring del codice, ho fatto un cut & paste!
		//return giocatori;
	}

}
