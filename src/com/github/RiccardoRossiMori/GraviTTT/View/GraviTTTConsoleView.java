package com.github.RiccardoRossiMori.GraviTTT.View;

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
 */
public class GraviTTTConsoleView implements GraviTTTView {
    public static final String RED = "R";
    public static final String GREEN = "G";
    public static final String NONE = " ";

    private BufferedReader buffer;
    private Stream<String> printer;

    /**
     * Stampa a video la checkerboard presa come stringa
     *
     * @param checkerboard
     */
    @Override
    public void printCheckerboard(final String checkerboard) {
        this.printer = Stream.of(checkerboard);
        this.printer.forEach(System.out::println);
    }

    /**
     * Manda in stampa a video un messaggio
     *
     * @param message
     */
    @Override
    public void printMessage(final String message) {
        print(message);
    }


    /**
     * Stampa un messaggio a video
     *
     * @param string
     */
    private void print(final String string) {
        this.printer = Stream.of(string);
        this.printer.forEach(System.out::println);
    }

    /**
     * Prende in input una stringa e la restituisce.
     *
     * @return
     * @throws IOException
     */
    @Override
    public String getInput() throws IOException {
        this.buffer = new BufferedReader(new InputStreamReader(System.in));
        return this.buffer.readLine();
    }

    /**
     * Prende specificatamente un numero dall'esterno e lo restituisce come intero.
     *
     * @return
     * @throws IOException
     */
    @Override
    public int getIntInput() throws IOException {
        this.buffer = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(this.buffer.readLine());
    }

    /**
     * Presa una stringa come parametro, la stampa e poi chiede un input che ritorna.
     *
     * @param message
     * @return
     * @throws IOException
     */
    @Override
    public String getStringPlayer(final String message) throws IOException {
        print(message);
        return this.getInput();
    }
}
