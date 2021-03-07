package com.codecool.ants.type;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codecool.ants.geometry.Direction.*;

public class Soldier extends Ant  {

    private final char tile = AntTile.SOLDIER.getTile();
    private Position position;
    private final boolean canMove = true;

    private static int pointer = 0;
    private final List<Direction> plan = generateRoot();
    private final static Direction[][] root = {
            {NORTH, EAST, SOUTH, WEST},
            {NORTH, WEST, SOUTH, EAST},
    };

    public Soldier() {
        super(AntTile.SOLDIER);
    }

    public Position move() {
        int newX = position.x + plan.get(pointer).getDeltaPosition().x;
        int newY = position.y + plan.get(pointer).getDeltaPosition().y;
        nextPointer();
        return new Position(newX, newY);
    }

    private List<Direction> generateRoot() {
        Random randomArrow = new Random();
        int arrow = randomArrow.nextInt(2);
        Random randomStart = new Random();
        int start = randomStart.nextInt(4);

        List<Direction> plan = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            plan.add(root[arrow][start++]);
            if (start > 3) start = 0;
        }
        return plan;
    }

    private void nextPointer() {
        ++pointer;
        if (pointer > 3) pointer = 0;
    }
}