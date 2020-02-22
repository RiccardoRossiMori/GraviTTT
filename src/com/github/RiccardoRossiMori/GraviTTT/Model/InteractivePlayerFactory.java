package com.github.RiccardoRossiMori.GraviTTT.Model; /**
 * <b>Responsabilità: </b>Fornisce il costruttore di un <code>com.github.RiccardoRossiMori.GraviTTT.Model.InteractivePlayer</code>, ossia di un giocatore interattivo.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class InteractivePlayerFactory implements PlayerFactory {

    @Override
    public Player generatePlayer() {
        return new InteractivePlayer();
    }

}
