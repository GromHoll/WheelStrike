package com.wheelStrike.model.map;

/**
 * @author GromHoll
 */
public interface TileMapLoader {
    public TileMap load(String filename) throws MapLoadException;
}
