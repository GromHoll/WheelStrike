package com.wheelStrike.model.map;

/**
 * @author GromHoll
 */
public class TileMap {

    private Tile map[][];

    public TileMap(int width, int height) {
        width = (width > 0) ? width : 1;
        height = (height > 0) ? height : 1;
        this.map = new Tile[width][height];
        fillMap(Tile.GRASS);
    }

    public int getWidth() {
        return map.length;
    }
    public int getHeight() {
        return map[0].length;
    }

    public Tile getTile(int x, int y) {
        return isOnMap(x, y) ? map[x][y] : null;
    }
    public void setTile(int x, int y, Tile tile) {
        if(tile != null && isOnMap(x, y))
            map[x][y] = tile;
    }

    public void fillMap(Tile tile) {
        if(tile == null)
            return;
        for(int i = 0; i < getWidth(); i++) {
            for(int j = 0; j < getHeight(); j++) {
                map[i][j] = tile;
            }
        }
    }

    public boolean isOnMap(int x, int y) {
        return !(x < 0 || x >= getWidth() || y < 0 || y >= getHeight());
    }
}
