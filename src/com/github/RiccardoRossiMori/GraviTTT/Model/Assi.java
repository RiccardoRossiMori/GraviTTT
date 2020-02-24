package com.github.RiccardoRossiMori.GraviTTT.Model;

/**
 * Responsabilità: deve indicare lungo quali assi controllare.
 */
public enum Assi {
    Verticale, Orizzontale, Diagonale_sx, Diagonale_dx;

    /**
     * Restituisce due direzioni a seconda del valore di deviatoio.
     *
     * @param deviatoio
     * @return
     */
    public Orientamento dammiLaDirezione(boolean deviatoio){
        switch (this){
            case Verticale:
                return deviatoio?Orientamento.Nord:Orientamento.Sud;
            case Orizzontale:
                return deviatoio?Orientamento.Est:Orientamento.Ovest;
            case Diagonale_dx:
                return deviatoio?Orientamento.Nord_Est:Orientamento.Sud_Ovest;
            case Diagonale_sx:
                return  deviatoio?Orientamento.Nord_Ovest:Orientamento.Sud_Est;
            default:
                return null;
        }
    }
}