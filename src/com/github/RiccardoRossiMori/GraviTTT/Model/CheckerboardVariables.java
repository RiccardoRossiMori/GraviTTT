package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b> Responsabilità: </b> Gestisce le variabili della scacchiera, ovvero le dimensioni della stessa e,tramite
 * <code>limited</code>, si definisce se la scacchiera in questione sia limitata esteriormente o meno,
 * in caso sia limitata (e quindi <code>limited == true</code>) non si può vincere sfruttando l'adiacenza
 * del bordo sinistro con quello destro. Viceversa quando <code>limited == false</code>.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class CheckerboardVariables {
    public static final CheckerboardVariables DEFAULT_SIZE = new CheckerboardVariables(6, 7, true);
    private final int row;
    private final int column;
    private final boolean limited;

    /**
     * Costruttore delle dimensioni base di una scacchiera di gioco.
     *
     * @param row
     * @param column
     */
    public CheckerboardVariables(int row, int column, boolean limitation) {
        this.column = column;
        this.row = row;
        this.limited = limitation;
    }

    /**
     * Ritorna il numero di righe presenti all'interno della tabella di gioco.
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * Ritorna il numero di colonne presenti all'interno della tabella di gioco.
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Ritorna se la tabella è limitata o meno affinché si possano fare i dovuti controlli
     * per verificare la vincita di un giocatore.
     *
     * @return the limited
     */
    public boolean isLimited() {
        return limited;
    }

}
