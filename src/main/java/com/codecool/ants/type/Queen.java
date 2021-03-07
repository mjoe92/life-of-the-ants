package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant  {

    private final char tile = AntTile.QUEEN.getTile();
    private final Position position = new Position(0,0);
    private final boolean canMove = false;
    private int counter;

    public Queen() {
        super(AntTile.QUEEN);
    }

    public void restartCounter() {
        Random random = new Random();
        counter = random.nextInt(50) + 50;
    }

    public void reduceCounter() {
        if (counter > 0) counter--;
    }

    public int getCounter() {
        return counter;
    }
}