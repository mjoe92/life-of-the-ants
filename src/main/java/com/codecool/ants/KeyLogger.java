package com.codecool.ants;

import java.io.Console;
import java.util.Scanner;

public class KeyLogger {

    private static boolean canContinue;
    private static Console console = System.console();

    public static void beginSim() {
        String message = "Ant colony project.\n" +
                "To begin simulation, press 'ENTER'.\n" +
                "You can stop the simulation by pressing 'ENTER' and 'q'.";
        System.out.println(message);
        console.readLine();
    }

    public static void stopSim() {
        String message = "The simulation has been stopped!";
        System.out.println(message);
        exit();
    }

    public static void exit() {
        System.exit(0);
    }

}
