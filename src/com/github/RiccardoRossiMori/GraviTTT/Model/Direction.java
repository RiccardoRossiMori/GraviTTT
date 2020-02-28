package com.github.RiccardoRossiMori.GraviTTT.Model;

/**
 * Responsabilità: restituire una direzione per permettere la verifica
 * della vittoria di un giocatore.
 */
public enum Direction {
    North, North_East, East, South_East, South, South_West, West, North_West;

    /**
     * Restituisce la direzione verticale sotto forma di addizione numerica da chi chiama
     * questa funzione.
     *
     * @return
     */
    public int rowMove() {
        if (this == Direction.North || this == Direction.North_East || this == Direction.North_West) return 1;
        if (this == Direction.South || this == Direction.South_East || this == Direction.South_West) return -1;
        return 0;
    }

    /**
     * Restituisce la direzione orizzontale sotto forma di addizione numerica da chi chiama
     * questa funzione.
     *
     * @return
     */
    public int columnMove() {
        if (this == Direction.East || this == Direction.North_East || this == Direction.South_East) return 1;
        if (this == Direction.West || this == Direction.North_West || this == Direction.South_West) return -1;
        return 0;
    }
}
