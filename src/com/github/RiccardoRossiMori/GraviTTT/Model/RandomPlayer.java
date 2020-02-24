package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un bot.
 */

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;

import java.util.Random;

/**
 * @author Riccardo Rossi Mori
 *
 */
public class RandomPlayer implements Player {
    private Random random;
    private CheckerboardManager checkerboardManager;

    public RandomPlayer(CheckerboardManager checkerboardManager, int seed) {
        this.setCheckerboardManager(checkerboardManager);
        random = new Random(seed);
    }

    public RandomPlayer(CheckerboardManager checkerboardManager) {
        this.setCheckerboardManager(checkerboardManager);
        random = new Random();
    }

    /**
     * Memorizza al suo interno un CheckerboardManager per poter interagire
     * con la tabella di gioco.
     *
     * @param checkerboardManager
     */
    public void setCheckerboardManager(CheckerboardManager checkerboardManager) {
        this.checkerboardManager = checkerboardManager;
    }

    /**
     *
     * Implementa la strategia di gioco di un bot che posiziona <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> a caso
     * nella <code>Checkerbox</code> in uso.
     * @return
     *
     */
    @Override
    public int strategy() {
        int x= random.nextInt(this.checkerboardManager.getCheckerboard().getDimensioni().getColumn());
        return x==0?x:x-1;
    }

  /*  @Override
    public String stampa() {
        return "RandomPlayer";
    }*/

}
