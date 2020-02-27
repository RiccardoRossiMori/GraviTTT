package com.github.RiccardoRossiMori.GraviTTT.Model;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.BiFunction;

/**
 * <b> Responsabilità: </b> Memorizzare una scacchiera sotto forma di matrice.
 */

/**
 * @author Riccardo Rossi Mori
 */
public class MatrixCheckerboard implements Checkerboard {

    private CheckerboardVariables dimensioni;
    private Pawn[][] checkerboard;
    private int lastRow, lastColumn;
    private final EnumSet<Assi> direzioni = EnumSet.allOf(Assi.class);

    public MatrixCheckerboard(@NotNull final CheckerboardVariables s) {//TODO eliminare il @notnull ??
        setCheckerboard(new Pawn[s.getColumn()][s.getRow()]);
        setVariabiliDiGioco(s);
    }

    private void setCheckerboard(final Pawn[][] checkerboard) {
        this.checkerboard = checkerboard;
        for (final Pawn[] row : this.checkerboard) {
            Arrays.fill(row, Pawn.None);
        }
    }


    /**
     * Restituisce le dimensioni della tabella di gioco.
     *
     * @return
     */
    @Override
    public CheckerboardVariables getDimensioni() {
        return this.dimensioni;
    }

    /**
     * Delta expression per dare una rappresentazione video della tabella di gioco.
     *
     * @return
     */
    @Override
    public String stampa() {
        return this.toPrint((j, i) -> (this.checkerboard[i][j] == com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.None ?
                com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.NONE :
                (checkerboard[i][j] == com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red ?
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.RED :
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.GREEN)));
    }

    /**
     * Formatta la tabella di gioco in modo da poterla stampare a video sotto forma di stringa.
     *
     * @param smacco
     * @return
     */
    public String toPrint(final BiFunction<Integer, Integer, String> smacco) {
        String brico = "    ";//TODO fai una spaziatura decente e non a caso con n spazi
        for (int i = 0; i < this.dimensioni.getColumn(); i++)
            brico += String.format("%3d ", (i + 1));
        brico += String.format("\n");
        for (int j = this.dimensioni.getRow() - 1; j >= 0; j--) {
            brico += String.format("%3d ", (j + 1));
            for (int i = 0; i < this.dimensioni.getColumn(); i++) {
                brico += String.format("| %s ", smacco.apply(j, i));
            }
            brico += String.format(" #\n");
        }
        return brico;
    }

    /**
     * Cerca di posizionare una nuova pedina in una data colonna.
     *
     * @param p
     * @param disco
     * @return
     * @throws IllegalPawnPlacementException
     */
    @Override
    public boolean putPawn(final int p, final Pawn disco) throws IllegalPawnPlacementException {
        if (isOut(p)) {
            throw new IllegalPawnPlacementException();
        }
        final int x = this.gravity(p);
        if (this.checkerboard[p][x] == Pawn.None)
            this.checkerboard[p][x] = disco;
        else throw new IllegalPawnPlacementException();
        this.lastRow = x;
        this.lastColumn = p;
        return this.vincitore(p, x);
    }

    /**
     * Verifica che la data colonna non sia al di fuori delle dimensioni della tabella di gioco.
     *
     * @param p
     * @return
     */
    private boolean isOut(final int p) {
        return p > this.dimensioni.getColumn() || p < 0;
    }

    /**
     * Verifica le condizioni di vittoria di un giocatore.
     *
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean vincitore(final int i, final int j) {
        for (final Assi asse : this.direzioni) {
            if ((pawnNeighbor(asse.dammiLaDirezione(true))
                    + (pawnNeighbor(asse.dammiLaDirezione(false)) - 1)) >= 4)
                return true;
        }
        return false;
    }

    /**
     * Presa una colonna, ritorna la prima riga disponibile. Se la colonna
     * è già satura, lancia un'eccezione.
     *
     * @param column
     * @return
     * @throws IllegalPawnPlacementException
     */
    @Override
    public int gravity(final int column) throws IllegalPawnPlacementException {
        int i = 0;
        while (i < dimensioni.getRow()) {
            if (this.checkerboard[column][i] == Pawn.None) {
                return i;
            } else
                i++;
        }
        throw new IllegalPawnPlacementException();
    }

    /**
     * Restituisce un intero che dice quante pedine ho di fila attorno a me.
     *
     * @param row
     * @param column
     * @param x
     * @return
     */

    private int vicini(final int row, final int column, final Orientamento x) {
        if (row < 0 || row >= this.dimensioni.getRow() || column < 0 || column >= this.dimensioni.getColumn())
            return 0;
        if (this.checkerboard[this.lastColumn][this.lastRow] == this.checkerboard[column][row])
            return this.vicini(row + x.rowMove(), column + x.columnMove(), x) + 1;
        return 0;
    }

    /**
     * Metodo sovrascritto per ritornare il numero di pedine adiacenti all'ultima inserita.
     *
     * @param x
     * @return
     */
    @Override
    public int pawnNeighbor(final Orientamento x) {
        return this.vicini(this.lastRow, this.lastColumn, x);
    }


    /**
     * @param checkerboardVariables the checkerboardVariables to set
     */
    private void setVariabiliDiGioco(final CheckerboardVariables checkerboardVariables) {
        dimensioni = checkerboardVariables;
    }

}
