package com.wheelStrike.model.map;

/**
 * @author GromHoll
 */
public enum Tile {
    FOREST(false, false, 0),
    ROAD(true, false, 1.5),
    CONCRETE(true, false, 1.5),
    GRASS(true, false, 1),
    SOLID(true, false, 1),
    SAND(true, false, 0.75),
    WATER(true, true, 0.75),
    SEA(false, true, 0);

    public static final double width  = 20;
    public static final double height = 20;

    private final boolean drivable;
    private final boolean swimmable;

    private final double driveSpeedMultiplier;

    Tile(boolean drivable, boolean swimmable, double driveSpeedMultiplier) {
        this.drivable = drivable;
        this.swimmable = swimmable;
        this.driveSpeedMultiplier = driveSpeedMultiplier;
    }

    public boolean isDrivable() {
        return drivable;
    }
    public boolean isSwimmable() {
        return swimmable;
    }

    public double getDriveSpeedMultiplier() {
        return driveSpeedMultiplier;
    }

}
