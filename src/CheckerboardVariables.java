/**
 * 
 * <b> Responsabilità: </b> Gestisce le variabili della scacchiera, ovvero le dimensioni della stessa e,tramite
 * <code>limited</code>, si definisce se la scacchiera in questione sia limitata esteriormente o meno,
 * in caso sia limitata (e quindi <code>limited == true</code>) non si può vincere sfruttando l'adiacenza
 * del bordo sinistro con quello destro. Viceversa quando <code>limited == false</code>.
 * 
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class CheckerboardVariables {
	private final int row;
	private final int column;
	private final boolean limited;
	public static final CheckerboardVariables DEFAULT_SIZE = new CheckerboardVariables(6, 7, true);

	/**
	 * Costruttore delle dimensioni base di una scacchiera di gioco.
	 * 
	 * @param row
	 * @param column
	 */
	public CheckerboardVariables(int row, int column, boolean limitation) {
		this.column = column;
		this.row = row;
		this.limited= limitation;
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

	/**
	 * @return the limited
	 */
	public boolean isLimited() {
		return limited;
	}

}
