package com.codecool.ants.type;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Worker extends Ant {

    private final char tile = AntTile.WORKER.getTile();
    private Position position;
    private final boolean canMove = true;

    public Worker() {
        super(AntTile.WORKER);
    }

    public Position move() {
        int randomPick = new Random().nextInt(4);
        Direction direction = Direction.values()[randomPick];
        return direction.getDeltaPosition();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        }
    }
}