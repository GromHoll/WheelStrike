package com.golem.util;

/**
 * @author GromHoll
 */
public class Vector2D {

    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D newInstance() {
        return new Vector2D(x, y);
    }

    public Vector2D multiply(double arg) {
        x *= arg;
        y *= arg;
        return this;
    }

    public Vector2D sum(Vector2D arg) {
        x += arg.x;
        y += arg.y;
        return this;
    }

    public static Vector2D multiply(Vector2D vector, double multiplier) {
        return vector.newInstance().multiply(multiplier);
    }

    public static Vector2D sum(Vector2D arg1, Vector2D arg2) {
        return arg1.newInstance().sum(arg2);
    }
}
