package com.codecool.ants.type;

import com.codecool.ants.geometry.Position;

import java.util.Random;

import static com.codecool.ants.geometry.Direction.*;

public class Drone implements Ant  {

    private final char tile;
    private Position position;
    private int counter;

    private static final Random random = new Random();

    public Drone() {
        tile = AntTile.DRONE.getTile();
    }

    public Position onUpdate() {

        int newX = position.x;
        int newY = position.y;
        float angle = Math.abs((float) Math.toDegrees(Math.atan2(newY, newX)));
        if (newY < 0) angle = 360 - angle;
        if (135 >= angle && angle > 45) {
            newY += SOUTH.getDeltaPosition().y;
        } else if (225 >= angle && angle > 135) {
            newX += EAST.getDeltaPosition().x;
        } else if (315 >= angle && angle > 225) {
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

    public Position kickedToBorder(int colonySize) {
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

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        if (position != null) {
            this.position = position;
        }
    }

    @Override
    public char getTile() {
        return tile;
    }
}
