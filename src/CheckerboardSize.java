/**
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class CheckerboardSize {
	private final int row;
	private final int column;
	private static final CheckerboardSize DEFAULT_SIZE = new CheckerboardSize(6, 7);

	/**
	 * Costruttore delle dimensioni base di una scacchiera di gioco.
	 * 
	 * @param row
	 * @param column
	 */
	public CheckerboardSize(int row, int column) {
		this.column = column;
		this.row = row;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

}
