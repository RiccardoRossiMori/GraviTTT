package com.github.RiccardoRossiMori.GraviTTT.Model;

/**
 * Responsabilità: restituire una direzione per permettere la verifica
 * della vittoria di un giocatore.
 */
public enum Orientamento {
    Nord, Nord_Est, Est, Sud_Est, Sud, Sud_Ovest, Ovest, Nord_Ovest;

    /**
     * Restituisce la direzione verticale sotto forma di addizione numerica da chi chiama
     * questa funzione.
     *
     * @return
     */
    public int rowMove() {
        if (this == Orientamento.Nord || this == Orientamento.Nord_Est || this == Orientamento.Nord_Ovest) return 1;
        if (this == Orientamento.Sud || this == Orientamento.Sud_Est || this == Orientamento.Sud_Ovest) return -1;
        return 0;
    }

    /**
     * Restituisce la direzione orizzontale sotto forma di addizione numerica da chi chiama
     * questa funzione.
     *
     * @return
     */
    public int columnMove() {
        if (this == Orientamento.Est || this == Orientamento.Nord_Est || this == Orientamento.Sud_Est) return 1;
        if (this == Orientamento.Ovest || this == Orientamento.Nord_Ovest || this == Orientamento.Sud_Ovest) return -1;
        return 0;
    }
}
