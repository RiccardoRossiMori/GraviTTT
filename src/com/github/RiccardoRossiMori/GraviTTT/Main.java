package com.github.RiccardoRossiMori.GraviTTT;

import com.github.RiccardoRossiMori.GraviTTT.Controller.GameManager;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import com.github.RiccardoRossiMori.GraviTTT.Exceptions.IllegalPawnPlacementException;
import com.github.RiccardoRossiMori.GraviTTT.Model.CheckerboardVariables;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;
import com.sun.management.GarbageCollectionNotificationInfo;
import sun.management.GarbageCollectionNotifInfoCompositeData;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;

public class Main {
    public static void main(String argv[]) throws IOException, IllegalPawnPlacementException {
       // StartGameInterface starter= new StartGameDefault();   //TODO Le 3 righe di codice commentate sono operazioni inutili se si prende la CheckerboardVariables.DEFAULT_SIZE, ma se la si vuole modificare...
        CheckerboardVariables dimensioni = CheckerboardVariables.DEFAULT_SIZE;//TODO cerca di capire come instanziare una CheckerboardVariables tramite Factory Method
      //  dimensioni=starter.setSize(dimensioni.getRow(),dimensioni.getColumn(),dimensioni.isLimited());
        GameManager game = new GameManager(new MatrixCheckerboard(dimensioni));
       // starter=null;//TODO controlla se questa variabile crea problemi, gli viene assegnato null prima dell'avvio della partita per evitare riferimenti inaspettati e liberare memoria
        game.play();
        //while (game.main());
    }
}
