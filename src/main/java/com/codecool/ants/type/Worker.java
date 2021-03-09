package com.codecool.ants.type;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Worker implements Ant {

    private final char tile;
    private Position position;

    public Worker() {
        tile = AntTile.WORKER.getTile();
    }

    public Position onUpdate() {
        int randomPick = new Random().nextInt(4);
        Direction direction = Direction.values()[randomPick];
        int newX = position.x + direction.getDeltaPosition().x;
        int newY = position.y + direction.getDeltaPosition().y;
        return new Position(newX, newY);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        }
    }

    public char getTile() {
        return tile;
    }
}