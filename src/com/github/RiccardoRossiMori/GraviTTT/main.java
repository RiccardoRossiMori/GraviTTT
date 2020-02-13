package com.github.RiccardoRossiMori.GraviTTT;

import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.IOException;

public class main {
    public static void main(String argv[]) throws IOException, IllegalPawnPlacement {
        CheckerboardVariables dimensioni= CheckerboardVariables.DEFAULT_SIZE;
        GameManager game =new GameManager(new MatrixCheckerboard(dimensioni));
        game.main();
    }
}
