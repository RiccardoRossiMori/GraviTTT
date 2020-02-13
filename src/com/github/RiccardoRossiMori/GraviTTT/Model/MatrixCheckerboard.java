package com.github.RiccardoRossiMori.GraviTTT.Model;

import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;

import java.util.Arrays;

/**
 * <b> Responsabilit�: </b> Memorizzare una scacchiera sotto forma di matrice.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class MatrixCheckerboard implements Checkerboard {

    private Pawn[][] gameboard;
    private int lastrow, lastcolumn;
    //private  String brico;
    private CheckerboardVariables dimensioni;

    public MatrixCheckerboard(CheckerboardVariables s) {
        this.gameboard = new Pawn[s.getColumn()][s.getRow()];
        for (Pawn[] row : this.gameboard) {
            Arrays.fill(row, Pawn.None);
        }
        this.setVariabiliDiGioco(s);
    }

    public boolean isItEmpty(int i, int j) {
        return this.gameboard[i][j] == Pawn.None;    //TODO Deve essere qui o altrove? verifica
    }

	/*public void stampa(){
		toPrint((i,j) -> (com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager.isItEmpty(i,j)?com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.NONE:this.gameboard[i][j]==com.github.RiccardoRossiMori.GraviTTT.Model.Pawn.Red?com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.RED:com.github.RiccardoRossiMori.GraviTTT.View.GraviTTTConsoleView.GREEN));
	}

	public Character toPrint (BiFunction<Integer,Integer,Character> smacco){	//TODO Implementa la stampa della com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard come si deve
		for (int i=0;i<dimensioni.getRow();i++){
			brico = String.format("%3d ",(i+1));
			for (int j=0;j<dimensioni.getColumn();j++){
				brico += String.format("| %c ", smacco.apply(i, j));
			}
		}
		return "";
	}
*/

    @Override
    public boolean putPawn(int p, Pawn disco) throws IllegalPawnPlacementException {
        if (p > dimensioni.getColumn() || p < 0) {
            throw new IllegalPawnPlacementException();
        }
        int x = 0;
        // x=metodo che mi da la riga nella colonna
        gameboard[x][p] = disco;
        lastrow = x;
        lastcolumn = p;

        //TODO controlla qu� le condizioni di vincita con <code>pawnNeighbor</code>
        return vincitore(x, p);
    }

    @Override
    public boolean vincitore(int i, int j) {

        return true;
    }

    @Override
    public int gravity(int column) {
        int i = 0;
        while (true) {
            System.out.println(i + " questo � i " + column + " e questa la colonna" + gameboard[i][column] + " e questo � il valore nella casella");
            if (gameboard[i][column] == Pawn.None) {
                return i;
            } else
                i++;
        }
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
     *
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
        return vicini(lastrow, lastcolumn);
    }

	/*
	/**
	 * @return the variabiliDiGioco
	 *//*
	public com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables getVariabiliDiGioco() {
		return dimensioni;
	}*/

    /**
     * @param variabiliDiGioco the variabiliDiGioco to set
     */
    private void setVariabiliDiGioco(CheckerboardVariables variabiliDiGioco) {
        this.dimensioni = variabiliDiGioco;
    }

}