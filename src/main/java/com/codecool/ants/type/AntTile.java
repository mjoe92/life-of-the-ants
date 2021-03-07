package com.codecool.ants.type;

public enum AntTile {
    QUEEN ('q'),
    DRONE ('d'),
    SOLDIER ('s'),
    WORKER ('w');

    private char tile;

    AntTile(char tile) {
        this.tile = tile;
    }

    public char getTile() {
        return tile;
    }
}
