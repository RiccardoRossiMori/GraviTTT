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
	 * TODO Implementa meglio il metodo scegliGiocatori1();
	 * TODO definisci un flusso di computazione (scrivi i metodi senza elaborare troppo)
	 * TODO ("getRigaBassa") implementa <code>gravity</code> per sapere dove mettere la pedina nella colonna x 
	 * TODO posizionamento di una pedina in una colonna 
	 * TODO implementa i factory method per i <code>PlayerFactory</code> 
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

	private static Function<String,Player> getPlayerFactory(String string) {//TODO implementa per bene il metodo
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
		vista= new GraviTTTConsoleView();

		this.setScacchiera(new MatrixCheckerboard(dimensioni));//TODO controlla che la responsabilità sia coerente con questo set
		checkerboardManager=new CheckerboardManager(scacchiera);
		//TODO controlla che la responsabilità sia coerente l'inizializzazione precedente
		//checkerboardManager=new CheckerboardManager(dimensioni.getRow(),dimensioni.getColumn(),dimensioni.isLimited());

		winner = false;
		turno = true;
		giocatore1 = scegliGiocatori1("Primo");
		giocatore2 = scegliGiocatori1("Secondo");
	}

	private Player getGiocatore() {
		return turno ? giocatore1 : giocatore2;
	}
	/*public static void main(String argv[]){
		GameManager.main();
	}*/

	public void main() throws IOException, IllegalPawnPlacement {
		this.init();
		int i=0;
		while (/*!winner*/i<4) {
			i++;
			winner = checkerboardManager.action(getGiocatore().strategy(),turno);
			if(!winner)cambioTurno();
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

	//verride
	public Player scegliGiocatori1(String x) throws IOException {
		// TODO Auto-generated method stub
		//List<Player> giocatori=null;
		String y;
		//x= vista.getStringPlayer("Primo giocatore, inserisci 'bot' per il primo giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		y= vista.getStringPlayer(x+" giocatore, inserisci 'bot' per il giocatore random, premi un qualunque altro tasto per il giocatore interattivo.");
		//getPlayerFactory(x.toLowerCase()); //TODO refactoring del codice, instanzio ma non ho il riferimento all'oggetto... pointless!
		return getPlayerFactory(y.toLowerCase()).apply(y.toLowerCase());
		//giocatori.add(getPlayerFactory(x));
		//giocatori.add(y.toLowerCase());	//TODO refactoring del codice, ho fatto un cut & paste!
		//return giocatori;
	}

}
