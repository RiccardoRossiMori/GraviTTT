package com.github.RiccardoRossiMori.GraviTTT.Model;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * <b> Responsabilità: </b> Memorizzare una scacchiera sotto forma di matrice.
 */

/**
 * @author Riccardo Rossi Mori
 */
public class MatrixCheckerboard implements Checkerboard {

    public Pawn[][] getCheckerboard() {
        return checkerboard;
    }

    private void setCheckerboard(Pawn[][] checkerboard) {
        this.checkerboard = checkerboard;
        for (Pawn[] row : this.checkerboard) {
            Arrays.fill(row, Pawn.None);
        }
    }

    private Pawn[][] checkerboard;
    private int lastRow, lastColumn;
    private String brico;

    public CheckerboardVariables getDimensioni() {
        return dimensioni;
    }

    private CheckerboardVariables dimensioni;

    public MatrixCheckerboard(CheckerboardVariables s) {
        this.setCheckerboard(new Pawn[s.getColumn()][s.getRow()]);
        this.setVariabiliDiGioco(s);
    }

    public boolean isItEmpty(int i, int j) {
        return this.checkerboard[i][j] == Pawn.None;    //TODO Deve essere qui o altrove? verifica
    }

    public String stampa() {
        return toPrint((j, i) -> (checkerboard[i][j] == Pawn.None ?
                com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.NONE :
                (this.checkerboard[i][j] == com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red ?
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.RED :
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.GREEN)));
    }

    public String toPrint(BiFunction<Integer, Integer, String> smacco) {
        brico = "    ";//TODO fai una spaziatura decente e non a caso con n spazi
        for (int i = 0; i < dimensioni.getColumn(); i++)
            brico += String.format("%3d ", (i+1));
        brico += String.format("\n");
        for (int j = dimensioni.getRow()-1; j >= 0; j--) {
            brico += String.format("%3d ", (j+1));
            for (int i = 0; i < dimensioni.getColumn(); i++) {
                brico += String.format("| %s ", smacco.apply(j, i));
            }
            brico += String.format(" #\n");
        }
        return brico += "";
    }


    @Override
    public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacementException {
        if (p > dimensioni.getColumn() || p < 0) {
            throw new IllegalPawnPlacementException();
        }
        int x = gravity(p);
        // x=metodo che mi da la riga nella colonna
        if(checkerboard[p][x]==Pawn.None)
        checkerboard[p][x] = disco;
            else throw new IllegalPawnPlacementException();
        lastRow = x;
        lastColumn = p;

        //TODO controlla quì le condizioni di vincita con <code>pawnNeighbor</code>
        return vincitore(p, x);
    }

    @Override
    public boolean vincitore(int i, int j) {

        return true;
    }

    @Override
    public int gravity(int column) throws IllegalPawnPlacementException {
        int i = 0;
        while (i<this.dimensioni.getRow()) {
            //System.out.println(i + " questo è i " + column + " e questa la colonna" + checkerboard[column][i] + " e questo è il valore nella casella");
            if (checkerboard[column][i] == Pawn.None) {
                return i;
            } else
                i++;
        }
        throw new IllegalPawnPlacementException();
    }
/*	public static void com.github.RiccardoRossiMori.GraviTTT.main(String argv[]) throws com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacement {
		com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables dimensioni = com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables.DEFAULT_SIZE;
		com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard matrixCheckerboard = new com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard(dimensioni);
		matrixCheckerboard.putPawn(1,com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red);
		int x=matrixCheckerboard.gravity(1);
		assert x==0: "Perfetto!";
		System.out.println(x + " valore restituito");
	}*/

    /**
     * Restituisce un intero che dice quante pedine ho di fila attorno a me.
     *
     * @param row
     * @param column
     * @return
     */

    private int vicini(int row, int column) {
        //TODO Implementa il metodo, cambia il tipo di ritorno.

        return 0;
    }

    @Override
    public int pawnNeighbor() {
        return vicini(lastRow, lastColumn);
    }


    /**
     * @param checkerboardVariables the checkerboardVariables to set
     */
    private void setVariabiliDiGioco(CheckerboardVariables checkerboardVariables) {
        this.dimensioni = checkerboardVariables;
    }

}
