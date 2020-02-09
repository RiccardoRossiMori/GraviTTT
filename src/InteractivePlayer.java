import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * <b>Responsabilità: </b> Gestisce la strategia di un giocatore interattivo.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class InteractivePlayer implements Player {

	/**
	 * 
	 * Implementa la strategia di gioco di un giocatore interattivo, per tanto
	 * chiederà in input un valore intero corrispondente alla colonna nella quale
	 * verrà posizionata la pedina.
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	@Override
	public boolean strategy() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		int colonna = Integer.parseInt(read.readLine());
		return CheckerboardManager.action(colonna);
	}

}
