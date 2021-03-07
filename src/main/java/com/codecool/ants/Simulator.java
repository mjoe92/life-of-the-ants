package com.codecool.ants;

import com.codecool.ants.geometry.Colony;

import java.util.Scanner;

public class Simulator extends SimThread {

    public static void main(String[] args) {
        //System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Colony colony = new Colony(10);

        colony.generateAnts(1,1,1);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            colony.display();
            colony.update();
        }
    }
/*
    @Override
    public void run() {
        while (true) {
            Colony colony = new Colony(10);
            colony.generateAnts();
        }
    }
    */
}
