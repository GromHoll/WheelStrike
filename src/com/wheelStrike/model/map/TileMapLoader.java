package com.wheelStrike.model.map;

/**
 * @author GromHoll
 */
public interface TileMapLoader {
    public TileMap loadTileMap(String filename) throws MapLoadException;
}
