package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

public abstract class Ant {

    private char tile;
    private Position position;
    private boolean canMove;

    public Ant(AntTile antTile) {
        this.tile = antTile.getTile();
    }

    public boolean isCanMove() {
        return canMove;
    }

    public char getTile() {
        return tile;
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
