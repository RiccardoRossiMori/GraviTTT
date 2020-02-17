package com.github.RiccardoRossiMori.GraviTTT.Model;

public enum Assi {
    Verticale, Orizzontale, Diagonale_sx, Diagonale_dx;
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