package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b>Responsabilità: </b>Genera un costruttore di un bot <code>com.github.RiccardoRossiMori.GraviTTT.Model.RandomPlayer</code>.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class RandomPlayerFactory implements PlayerFactory {

    @Override
    public Player generatePlayer() {
        return new RandomPlayer();
    }

}
