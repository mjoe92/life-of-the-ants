package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

public interface Ant {
    Position getPosition();
    void setPosition(Position position);
    char getTile();
}
