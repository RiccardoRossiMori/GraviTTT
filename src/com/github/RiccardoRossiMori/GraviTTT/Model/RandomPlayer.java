package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b>Responsabilità: </b>Gestisce la strategia di gioco di un bot.
 */

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;

import java.util.Random;

/**
 * @author Riccardo Rossi Mori
 */
public class RandomPlayer implements Player {
    private final Random random;
    private CheckerboardManager checkerboardManager;

    /**
     * Costruttore con un intero seed come parametro per poter avere un determinato
     * set di numeri casuali fissi e poter fare dei test più puntuali.
     *
     * @param checkerboardManager
     * @param seed
     */
    public RandomPlayer(final CheckerboardManager checkerboardManager, final int seed) {
        setCheckerboardManager(checkerboardManager);
        this.random = new Random(seed);
    }

    public RandomPlayer(final CheckerboardManager checkerboardManager) {
        setCheckerboardManager(checkerboardManager);
        this.random = new Random();
    }

    /**
     * Memorizza al suo interno un CheckerboardManager per poter interagire
     * con la tabella di gioco.
     *
     * @param checkerboardManager
     */
    public void setCheckerboardManager(final CheckerboardManager checkerboardManager) {
        this.checkerboardManager = checkerboardManager;
    }

    /**
     * Implementa la strategia di gioco di un bot che posiziona <code>com.github.RiccardoRossiMori.GraviTTT.Model.Pawn</code> a caso
     * nella <code>Checkerbox</code> in uso.
     *
     * @return
     */
    @Override
    public int strategy() {
        final int x = this.random.nextInt(checkerboardManager.getCheckerboard().getDimensions().getColumn());
        return x == 0 ? x : x - 1;
    }
}
