package com.github.RiccardoRossiMori.GraviTTT.Model;

public enum Assi {
    Verticale, Orizzontale, Diagonale_sx, Diagonale_dx;
    //TODO implementa in modo più decente tutta la classe
    public int getSteps(){
        switch (this){
            case Verticale:{
                getForwardHeight();
                getBackwardHeight();
            }
            case Orizzontale:{
                getForwardWidth();
                getBackwardWidth();
            }
            case Diagonale_dx:{
                {
                    getForwardWidth();
                    getForwardHeight();
                }
                {
                    getBackwardWidth();
                    getBackwardHeight();
                }
            }
            case Diagonale_sx:{
                {
                    getBackwardWidth();
                    getForwardHeight();
                }
                {
                    getBackwardHeight();
                    getForwardWidth();
                }

            }
            default:{

            }

        }
    return 0;}

    public int getForwardHeight(){
        return 0;
    }
    public int getBackwardHeight(){
        return 0;
    }
    public int getForwardWidth(){
        return 0;
    }
    public int getBackwardWidth(){
        return 0;
    }





}


