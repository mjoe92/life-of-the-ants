package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

import java.util.Random;

import static com.codecool.ants.geometry.Direction.*;

public class Drone extends Ant  {

    private final char tile = AntTile.DRONE.getTile();
    private Position position;
    private boolean canMove = true;
    private int counter;

    private static Random random = new Random();

    public Drone() {
        super(AntTile.DRONE);
    }

    public Position move() {

        int newX = position.x;
        int newY = position.y;
        float angle = (float) Math.toDegrees(Math.atan2(newY, newX));
        if (angle > 45) {
            newY += SOUTH.getDeltaPosition().y;
        } else if (angle > 135) {
            newX += EAST.getDeltaPosition().x;
        } else if (angle > 225) {
            newY += NORTH.getDeltaPosition().y;
        } else {
            newX += WEST.getDeltaPosition().x;
        }

        return new Position(newX, newY);
    }

    public void restartCounter() {
        counter = 10;
    }

    public void reduceCounter() {
        if (counter > 0) counter--;
    }

    public Position jumpToBorder(int colonySize) {
        int randomBorderPos = random.nextInt(colonySize) - colonySize / 2;
        int[][] border = {
                {colonySize / 2, randomBorderPos},
                {randomBorderPos, colonySize / 2},
                {-colonySize / 2, randomBorderPos},
                {randomBorderPos, -colonySize / 2}
        };
        int randomSide = random.nextInt(border.length - 1);
        int[] posInBorder = border[randomSide];
        return new Position(posInBorder[0], posInBorder[1]);
    }

    public int getCounter() {
        return counter;
    }
}
