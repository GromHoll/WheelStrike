package com.wheelStrike.model.map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author GromHoll
 * @see "tileColors.png" for color hex values
 */
public class ImageTileMapLoader implements TileMapLoader {

    public static final long FOREST_IMAGE   = 0xFF22B14C;
    public static final long ROAD_IMAGE     = 0xFF7F7F7F;
    public static final long CONCRETE_IMAGE = 0xFFC3C3C3;
    public static final long GRASS_IMAGE    = 0xFFB5E61D;
    public static final long SOLID_IMAGE    = 0xFFB97A57;
    public static final long SAND_IMAGE     = 0xFFFFF200;
    public static final long WATER_IMAGE    = 0xFF00A2E8;
    public static final long SEA_IMAGE      = 0xFF3F48CC;

    private HashMap<Long, Tile> map = new HashMap<Long, Tile>();

    public ImageTileMapLoader() {
        map.put(FOREST_IMAGE, Tile.FOREST);
        map.put(ROAD_IMAGE, Tile.ROAD);
        map.put(CONCRETE_IMAGE, Tile.CONCRETE);
        map.put(GRASS_IMAGE, Tile.GRASS);
        map.put(SOLID_IMAGE, Tile.SOLID);
        map.put(SAND_IMAGE, Tile.SAND);
        map.put(WATER_IMAGE, Tile.WATER);
        map.put(SEA_IMAGE, Tile.SEA);
    }

    @Override
    public TileMap load(String filename) throws MapLoadException{
        try {
            BufferedImage bi = ImageIO.read(new File(filename));
            TileMap tileMap = new TileMap(bi.getWidth(), bi.getHeight());

            for(int i = 0; i < bi.getWidth(); i++) {
                for(int j = 0; j < bi.getHeight(); j++) {
                    tileMap.setTile(i, j, map.get(Long.valueOf(bi.getRGB(i, j))));
                }
            }
            return tileMap;
        } catch(IOException e) {
            throw new MapLoadException("Can't load tiles map from " + filename);
        }
    }
}
