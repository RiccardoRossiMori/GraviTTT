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
    private EnumSet<Assi> direzioni = EnumSet.allOf(Assi.class);

    public MatrixCheckerboard(@NotNull CheckerboardVariables s) {
        this.setCheckerboard(new Pawn[s.getColumn()][s.getRow()]);
        this.setVariabiliDiGioco(s);
    }

   /* public Pawn[][] getCheckerboard() {
        return checkerboard;
    }*/

    private void setCheckerboard(Pawn[][] checkerboard) {
        this.checkerboard = checkerboard;
        for (Pawn[] row : this.checkerboard) {
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
        return dimensioni;
    }



  /*  public boolean isItEmpty(int i, int j) {
        return this.checkerboard[i][j] == Pawn.None;    //TODO Deve essere qui o altrove? verifica
    }*/

    /**
     * Delta expression per dare una rappresentazione video della tabella di gioco.
     *
     * @return
     */
    @Override
    public String stampa() {
        return toPrint((j, i) -> (checkerboard[i][j] == com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.None ?
                com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.NONE :
                (this.checkerboard[i][j] == com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red ?
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.RED :
                        com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.GREEN)));
    }

    /**
     * Formatta la tabella di gioco in modo da poterla stampare a video sotto forma di stringa.
     *
     * @param smacco
     * @return
     */
    public String toPrint(BiFunction<Integer, Integer, String> smacco) {
        String brico = "    ";//TODO fai una spaziatura decente e non a caso con n spazi
        for (int i = 0; i < dimensioni.getColumn(); i++)
            brico += String.format("%3d ", (i + 1));
        brico += String.format("\n");
        for (int j = dimensioni.getRow() - 1; j >= 0; j--) {
            brico += String.format("%3d ", (j + 1));
            for (int i = 0; i < dimensioni.getColumn(); i++) {
                brico += String.format("| %s ", smacco.apply(j, i));
            }
            brico += String.format(" #\n");
        }
        return "";
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
    public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacementException {
        if (this.isOut(p)) {
            throw new IllegalPawnPlacementException();
        }
        int x = gravity(p);
        if (checkerboard[p][x] == Pawn.None)
            checkerboard[p][x] = disco;
        else throw new IllegalPawnPlacementException();
        lastRow = x;
        lastColumn = p;
        return vincitore(p, x);
    }

    /**
     * Verifica che la data colonna non sia al di fuori delle dimensioni della tabella di gioco.
     *
     * @param p
     * @return
     */
    private boolean isOut(int p) {
        return p > dimensioni.getColumn() || p < 0;
    }

    /**
     * Verifica le condizioni di vittoria di un giocatore.
     *
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean vincitore(int i, int j) {
        for (Assi asse : direzioni) {
            if ((this.pawnNeighbor(asse.dammiLaDirezione(true))
                    + (this.pawnNeighbor(asse.dammiLaDirezione(false)) - 1)) >= 4)
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
    public int gravity(int column) throws IllegalPawnPlacementException {
        int i = 0;
        while (i < this.dimensioni.getRow()) {
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
     * @param x
     * @return
     */

    private int vicini(int row, int column, Orientamento x) {
        if (row < 0 || row >= dimensioni.getRow() || column < 0 || column >= dimensioni.getColumn())
            return 0;
        if (checkerboard[lastColumn][lastRow] == checkerboard[column][row])
            return vicini(row + x.rowMove(), column + x.columnMove(), x) + 1;
        return 0;
    }

    /**
     * Metodo sovrascritto per ritornare il numero di pedine adiacenti all'ultima inserita.
     *
     * @param x
     * @return
     */
    @Override
    public int pawnNeighbor(Orientamento x) {
        return vicini(lastRow, lastColumn, x);
    }


    /**
     * @param checkerboardVariables the checkerboardVariables to set
     */
    private void setVariabiliDiGioco(CheckerboardVariables checkerboardVariables) {
        this.dimensioni = checkerboardVariables;
    }

}
