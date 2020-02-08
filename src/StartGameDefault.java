/**
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class StartGameDefault implements StartGameInterface{
	
	public CheckerboardSize dimensioni;
	
	@Override
	public void setSize(int i, int j) {
		this.dimensioni=new CheckerboardSize(i, j);
	}

}
