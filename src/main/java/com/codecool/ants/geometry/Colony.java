package com.codecool.ants.geometry;

import com.codecool.ants.type.*;

import java.util.*;

public class Colony {

    private final int width;
    private final char freePlace = '.';
    private final char[][] map;
    private final Queen queen;
    private final List<Ant> antList = new ArrayList<>();
    private Integer nOfWorkers = 0;
    private Integer nOfSoldiers = 0;
    private Integer nOfDrones = 0;

    private static Random random = new Random();

    public Colony(int width) {
        this.width = width;
        this.map = new char[width][width];
            fillMapWithChar(freePlace);
        this.queen = new Queen();
            antList.add(new Queen());
    }

    public void generateAnts(Integer...nOfAnts) {
        this.nOfWorkers = nOfAnts[0];
        this.nOfDrones = nOfAnts[1];
        this.nOfSoldiers = nOfAnts[2];

        if (nOfWorkers != null) {
            for (int i = 0; i < nOfWorkers; i++) {
                antList.add(new Worker());
            }
        }
        if (nOfSoldiers != null) {
            for (int i = 0; i < nOfSoldiers; i++) {
                antList.add(new Soldier());
            }
        }
        if (nOfDrones != null) {
            for (int i = 0; i < nOfDrones; i++) {
                antList.add(new Drone());
            }
        }
        placeAntsAutomatic();
    }

    public void generateAnts() {
        int limit = (int) Math.sqrt(width);
        nOfWorkers = random.nextInt(limit);
        nOfDrones = random.nextInt(limit);
        nOfSoldiers = random.nextInt(limit);
        generateAnts(nOfWorkers, nOfDrones, nOfSoldiers);
    }

    private void placeAntsAutomatic() {
        for (Ant ant : antList) {
            Position freePos;
            do {
                int horizontalPos = random.nextInt(width - 1) + 1 - width / 2;
                int verticalPos = random.nextInt(width - 1) + 1 - width / 2;
                freePos = new Position(horizontalPos, verticalPos);
            } while (!isFreeInsideMap(freePos));
            ant.setPosition(freePos);
        }
    }

    public void emptyAntList() {
        antList.clear();
    }

    public List<Ant> getAnts(Ant ant) {
        return antList;
    }

    public void update() {
        for (Ant ant : antList) {
            Position nextPos = ant.getPosition();
            if (ant instanceof Queen) {
                ((Queen) ant).reduceCounter();
            } else if (ant instanceof Worker) {
                nextPos = ((Worker) ant).move();
            } else if (ant instanceof Soldier) {
                nextPos = ((Soldier) ant).move();
            } else if (ant instanceof Drone) {
                if (((Drone) ant).getCounter() == 0) {
                    nextPos = ((Drone) ant).move();
                    if (nextPos == queen.getPosition()) {
                        if (queen.getCounter() == 0) {
                            ((Drone) ant).restartCounter();
                        }
                        nextPos = ((Drone) ant).jumpToBorder(width);
                    }
                } else {
                    ((Drone) ant).reduceCounter();
                }
            }
            if (isFreeInsideMap(nextPos)) {
                ant.setPosition(nextPos);
            }
            refreshMap();
        }
    }

    private boolean isFreeInsideMap(Position actualPos) {
        if (actualPos == null) {
            return false;
        }
        if (Math.abs(actualPos.x) > width / 2 || Math.abs(actualPos.y) > width / 2) {
            return false;
        }
        return map[actualPos.y + width / 2][actualPos.x + width / 2] == freePlace;
    }

    private void refreshMap() {
        fillMapWithChar(freePlace);
        for (Ant ant : antList) {
            map[ant.getPosition().x + width / 2][ant.getPosition().y + width / 2] = ant.getTile();
        }
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            sb.append("|");
            for (char c : row) {
                sb.append(" ").append(c).append(" ");
            }
            sb.append("|").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private void fillMapWithChar(char thing) {
        for (char[] row : map) {
            Arrays.fill(row, thing);
        }
    }
}
