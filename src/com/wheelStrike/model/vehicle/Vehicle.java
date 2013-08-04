package com.wheelStrike.model.vehicle;

import com.golem.util.Updatable;
import com.golem.util.Vector2D;

/**
 * @author GromHoll
 */
public class Vehicle implements Updatable {

    private Vector2D position;
    private Direction direction;
    private Vector2D speed;

    private double speedMultiplier = 0;
    private double defaultSpeed;

    public Vehicle(double x, double y, double defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
        this.position = new Vector2D(x, y);
        this.direction = Direction.DIRECTION_N;
        this.updateSpeed();
    }

    @Override
    public void update(double delta) {
        move(delta);
    }

    public void move(double delta) {
        position.sum(Vector2D.multiply(speed, delta));
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        updateSpeed();
    }

    private void updateSpeed() {
        speed = direction.getVector().multiply(speedMultiplier*defaultSpeed);
    }

    public void stop() {
        setSpeedMultiplier(0);
    }

    public void rotateLeft() {
        direction = direction.getLeft();
        updateSpeed();
    }

    public void rotateRight() {
        direction = direction.getRight();
        updateSpeed();
    }

    public double getX() {
        return position.x;
    }
    public double getY() {
        return position.y;
    }

    public Direction getDirection() {
        return direction;
    }
}
