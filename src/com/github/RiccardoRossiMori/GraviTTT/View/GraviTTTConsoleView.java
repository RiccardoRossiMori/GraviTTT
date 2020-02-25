package com.github.RiccardoRossiMori.GraviTTT.View;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <b>Responsabilità: </b>Gestisce una view basata
 * su console per interagirvi in maniera testuale.
 */

/**
 * @author Riccardo Rossi Mori
 *
 */
public class GraviTTTConsoleView implements GraviTTTView {
    public static final String RED = "R";
    public static final String GREEN = "G";
    public static final String NONE = " ";

    private MatrixCheckerboard matrixCheckerboard;
    private BufferedReader buffer;
    private Stream<String> printer;

    /**
     * Stampa a video la scacchiera presa come stringa
     *
     * @param scacchiera
     */
    @Override
    public void printCheckerboard(String scacchiera) {
        printer = Stream.of(scacchiera);
        printer.forEach(System.out::println);
    }

    /**
     * Manda in stampa a video un messaggio
     *
     * @param message
     */
    @Override
    public void printMessage(String message){
        this.print(message);
    }


    /**
     * Stampa un messaggio a video
     *
     * @param string
     */
    private void print(String string) {
        printer = Stream.of(string);
        printer.forEach(System.out::println);
    }

    /**
     * Prende in input una stringa e la restituisce.
     *
     * @return
     * @throws IOException
     */
    @Override
    public String getInput() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
        return buffer.readLine();
    }

    /**
     * Presa una stringa come parametro, la stampa e poi chiede un input che ritorna.
     *
     * @param message
     * @return
     * @throws IOException
     */
    @Override
    public String getStringPlayer(String message) throws IOException {
        this.print(message);
        return getInput();
    }
}
