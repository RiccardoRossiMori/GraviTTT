package com.github.RiccardoRossiMori.GraviTTT.View;

import com.github.RiccardoRossiMori.GraviTTT.Controller.CheckerboardManager;
import com.github.RiccardoRossiMori.GraviTTT.Model.Checkerboard;
import com.github.RiccardoRossiMori.GraviTTT.Model.MatrixCheckerboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <b>Responsabilità: </b>Gestisce una view testuale basata
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

    @Override
    public void printCheckerboard(String scacchiera) {
        printer = Stream.of(scacchiera);
        printer.forEach(System.out::println);
    }

    @Override
    public void printMessage(String message){
        this.print(message);
    }


    private void print(String string) {
        printer = Stream.of(string);
        printer.forEach(System.out::println);
    }

    private String getInput() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
        return buffer.readLine();
    }

    @Override
    public String getStringPlayer(String message) throws IOException {
        this.print(message);
        return getInput();
    }
}
