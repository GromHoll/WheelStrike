package com.wheelStrike.entry;

import com.golem.Image;
import com.golem.ImageLoader;
import com.golem.Screen;
import com.golem.Window;
import com.golem.java.JavaImageLoader;
import com.golem.java.JavaWindow;
import com.wheelStrike.model.map.ImageTileMapLoader;
import com.wheelStrike.model.map.Tile;
import com.wheelStrike.model.map.TileMap;
import com.wheelStrike.model.map.TileMapLoader;

import java.util.HashMap;

/**
 * @author GromHoll
 */
public class TestMain {
    public static void main(String args[]) throws Exception {
        TileMapLoader tileMapLoader = new ImageTileMapLoader();
        TileMap tileMap = tileMapLoader.loadTileMap("./res/tiles/testLevel.png");

        Window window = new JavaWindow(tileMap.getWidth()* (int) Tile.width,
                                       tileMap.getWidth()* (int) Tile.width,
                                       "Map View");

        HashMap<Tile, Image> imageMap = new HashMap<Tile, Image>();
        ImageLoader imageLoader = new JavaImageLoader();
        imageMap.put(Tile.FOREST, imageLoader.loadImage("./res/tiles/forest.png"));
        imageMap.put(Tile.ROAD, imageLoader.loadImage("./res/tiles/road.png"));
        imageMap.put(Tile.CONCRETE, imageLoader.loadImage("./res/tiles/concrete.png"));
        imageMap.put(Tile.GRASS, imageLoader.loadImage("./res/tiles/grass.png"));
        imageMap.put(Tile.SOLID, imageLoader.loadImage("./res/tiles/solid.png"));
        imageMap.put(Tile.SAND, imageLoader.loadImage("./res/tiles/sand.png"));
        imageMap.put(Tile.WATER, imageLoader.loadImage("./res/tiles/water.png"));
        imageMap.put(Tile.SEA, imageLoader.loadImage("./res/tiles/sea.png"));

        Screen screen = window.getScreen();

        screen.present();
        while(true) {
            for(int i = 0; i < tileMap.getWidth(); i++) {
                for(int j = 0; j < tileMap.getHeight(); j++) {
                    screen.draw(imageMap.get(tileMap.getTile(i, j)), i*(int) Tile.width, j*(int) Tile.height);
                }
            }
            screen.present();
            Thread.sleep(100);
        }
    }
}
