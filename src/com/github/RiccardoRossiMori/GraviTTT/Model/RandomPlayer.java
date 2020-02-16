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

    public RandomPlayer(int seed) {
        random = new Random(seed);
    }

    public RandomPlayer() {
        random = new Random();
    }

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
    public int strategy(CheckerboardManager checkerboardManager) {
        this.setCheckerboardManager(checkerboardManager);
        // TODO Auto-generated method stub
        int x= random.nextInt(checkerboardManager.getCheckerboard().getDimensioni().getColumn());
        return x==0?x:x-1;
    }

    @Override
    public String stampa() {
        return "RandomPlayer";
    }

}
