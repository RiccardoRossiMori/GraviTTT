package com.github.RiccardoRossiMori.GraviTTT.Tests;

import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameDefault;
import com.github.RiccardoRossiMori.GraviTTT.Controller.StartGameInterface;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class StartGameDefaultTest{

    @Test
    void init() {
    }

    @Test
    void scegliGiocatori() throws IOException {
        StartGameInterface pippo =new StartGameDefault();
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("bot".getBytes());
        System.setIn(in);

// do your thing

// optionally, reset System.in to its original
        System.setIn(sysInBackup);
        pippo.scegliGiocatori("prova ");
    }
}