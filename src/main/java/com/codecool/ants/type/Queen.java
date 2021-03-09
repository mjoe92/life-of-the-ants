package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen implements Ant  {

    private final char tile;
    private final Position position = new Position(0,0);
    private int counter;

    public Queen() {
        tile = AntTile.QUEEN.getTile();
        restartCounter();
    }

    public void restartCounter() {
        Random random = new Random();
        int offset = 50;
        counter = random.nextInt(offset) + offset;
    }

    public void reduceCounter() {
        if (counter > 0) counter--;
    }

    public int getCounter() {
        return counter;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {

    }

    public char getTile() {
        return tile;
    }
}