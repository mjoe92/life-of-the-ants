package com.codecool.ants.type;

public enum AntTile {
    QUEEN ('Q'),
    DRONE ('D'),
    SOLDIER ('S'),
    WORKER ('W');

    private final char tile;

    AntTile(char tile) {
        this.tile = tile;
    }

    public char getTile() {
        return tile;
    }
}
