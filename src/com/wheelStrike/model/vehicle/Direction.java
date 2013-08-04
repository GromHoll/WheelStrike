package com.wheelStrike.model.vehicle;

import com.golem.util.Vector2D;

/**
 * @author GromHoll
 */

public enum Direction {
    DIRECTION_N (new Vector2D(0, -1)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_NW;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_NE;
        }
    },
    DIRECTION_E(new Vector2D(1, 0)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_NE;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_SE;
        }
    },
    DIRECTION_S(new Vector2D(0, 1)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_SE;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_SW;
        }
    },
    DIRECTION_W(new Vector2D(-1, 0)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_SW;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_NW;
        }
    },
    DIRECTION_NE(new Vector2D(Math.sqrt(2)/2, -Math.sqrt(2)/2)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_N;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_E;
        }
    },
    DIRECTION_SE(new Vector2D(Math.sqrt(2)/2, Math.sqrt(2)/2)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_E;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_S;
        }
    },
    DIRECTION_SW(new Vector2D(-Math.sqrt(2)/2, Math.sqrt(2)/2)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_S;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_W;
        }
    },
    DIRECTION_NW (new Vector2D(-Math.sqrt(2)/2, -Math.sqrt(2)/2)) {
        @Override
        public Direction getLeft() {
            return DIRECTION_W;
        }
        @Override
        public Direction getRight() {
            return DIRECTION_N;
        }
    };

    private final Vector2D vector;

    Direction(Vector2D vector) {
        this.vector = vector;
    }

    public Vector2D getVector() {
        return vector.newInstance();
    }

    public abstract Direction getLeft();

    public abstract Direction getRight();
}
