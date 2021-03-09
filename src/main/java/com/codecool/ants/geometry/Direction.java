package com.codecool.ants.geometry;

    public enum Direction {
        NORTH (new Position(0, 1)),
        EAST (new Position(1, 0)),
        SOUTH (new Position(0, -1)),
        WEST (new Position(-1, 0));

        private final Position deltaPosition;

        Direction(Position deltaPosition) {
            this.deltaPosition = deltaPosition;
        }

        public Position getDeltaPosition() {
            return deltaPosition;
        }
    }
