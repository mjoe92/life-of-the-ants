package com.codecool.ants;

import com.codecool.ants.geometry.Colony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {

        //System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Colony colony = new Colony(10);

        //generate: 1: workers, 2: drones, 3: soldiers
        colony.generateAnts(3,4,6);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("q")) System.exit(0);
            colony.display();
            colony.update();
        }
    }
}