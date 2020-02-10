import sun.net.www.http.ChunkedOutputStream;

import java.io.*;
import java.util.stream.Stream;

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
	Stream<String> printer;

	

	private void print(String string) {
		// TODO Auto-generated method stub
		printer=Stream.of(string);
		printer.forEach(p ->System.out.println(p));
	}

	private String getInput() throws IOException {
		// TODO Auto-generated method stub this(new BufferedReader(new
		// InputStreamReader(System.in)),System.out,playerFactory1,playerFactory2);
		buffer = new BufferedReader(new InputStreamReader(System.in));
		return buffer.readLine();
	}

	@Override
	public String getStringPlayer(String message) throws IOException {
		this.print(message);
		return getInput();
		// TODO Auto-generated method stub
	}

}
