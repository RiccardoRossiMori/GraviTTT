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
    public int rowMove(){
        if(this==Nord||this==Nord_Est||this==Nord_Ovest)return 1;
        if (this==Sud||this==Sud_Est||this==Sud_Ovest)return -1;
        return 0;
    }

    /**
     * Restituisce la direzione orizzontale sotto forma di addizione numerica da chi chiama
     * questa funzione.
     *
     * @return
     */
    public int columnMove(){
        if(this==Est||this==Nord_Est||this==Sud_Est)return 1;
        if (this==Ovest||this==Nord_Ovest||this==Sud_Ovest)return -1;
        return 0;
    }
}
