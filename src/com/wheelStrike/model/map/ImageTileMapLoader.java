package com.wheelStrike.model.map;

import com.golem.graphics.ImageLoadException;
import com.golem.graphics.java.JavaImage;
import com.golem.graphics.java.JavaImageLoader;

import java.util.HashMap;

/**
 * @author GromHoll
 * @see "tileColors.png" for color hex values
 */

public class ImageTileMapLoader extends JavaImageLoader implements TileMapLoader {

    public static final long FOREST_COLOR   = 0xFF22B14C;
    public static final long ROAD_COLOR     = 0xFF7F7F7F;
    public static final long CONCRETE_COLOR = 0xFFC3C3C3;
    public static final long GRASS_COLOR    = 0xFFB5E61D;
    public static final long SOLID_COLOR    = 0xFFB97A57;
    public static final long SAND_COLOR     = 0xFFFFF200;
    public static final long WATER_COLOR    = 0xFF00A2E8;
    public static final long SEA_COLOR      = 0xFF3F48CC;

    private HashMap<Long, Tile> map = new HashMap<Long, Tile>();

    public ImageTileMapLoader() {
        map.put(FOREST_COLOR, Tile.FOREST);
        map.put(ROAD_COLOR, Tile.ROAD);
        map.put(CONCRETE_COLOR, Tile.CONCRETE);
        map.put(GRASS_COLOR, Tile.GRASS);
        map.put(SOLID_COLOR, Tile.SOLID);
        map.put(SAND_COLOR, Tile.SAND);
        map.put(WATER_COLOR, Tile.WATER);
        map.put(SEA_COLOR, Tile.SEA);
    }

    @Override
    public TileMap loadTileMap(String filename) throws MapLoadException{
        try {
            JavaImage image = loadImage(filename);
            TileMap tileMap = new TileMap(image.getWidth(), image.getHeight());

            for(int i = 0; i < image.getWidth(); i++) {
                for(int j = 0; j < image.getHeight(); j++) {
                    tileMap.setTile(i, j, map.get(Long.valueOf(image.getPixel(i, j))));
                }
            }

            return tileMap;
        } catch(ImageLoadException ex) {
            throw new MapLoadException("Can't loadImage tiles map from " + filename);
        }
    }
}
