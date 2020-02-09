import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 
 * <b>Responsabilità: </b>Gestisce una view testuale basata 
 * su console per interagirvi in maniera testuale.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GraviTTTConsoleView implements GraviTTTView {

	BufferedReader buffer;
	PrintStream printer;
	

	private void print(String string) {
		// TODO Auto-generated method stub
		printer.println(string);
	}

	private String getInput() throws IOException {
		// TODO Auto-generated method stub this(new BufferedReader(new
		// InputStreamReader(System.in)),System.out,playerFactory1,playerFactory2);
		buffer = new BufferedReader(new InputStreamReader(System.in));
		return buffer.readLine();
	}

	@Override
	public String getPlayer(String message) throws IOException {
		this.print(message);
		return getInput();
		// TODO Auto-generated method stub
	}

}
