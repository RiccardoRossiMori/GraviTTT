package com.github.RiccardoRossiMori.GraviTTT.Model;

/**
 * Responsabilità: deve indicare lungo quali assi controllare.
 */
public enum Orientations {
    Vertical, Horizontal, Diagonal_Left, Diagonal_Right;

    /**
     * Restituisce due direzioni a seconda del valore di swapper.
     *
     * @param swapper
     * @return
     */
    public Direction getDirection(final boolean swapper) {
        switch (this) {
            case Vertical:
                return swapper ? Direction.North : Direction.South;
            case Horizontal:
                return swapper ? Direction.East : Direction.West;
            case Diagonal_Right:
                return swapper ? Direction.North_East : Direction.South_West;
            case Diagonal_Left:
                return swapper ? Direction.North_West : Direction.South_East;
            default:
                return null;
        }
    }
}