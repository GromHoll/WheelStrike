package com.wheelStrike.entry;

import com.golem.*;
import com.golem.input.KeyEvent;
import com.golem.graphics.Image;
import com.golem.graphics.ImageLoader;
import com.golem.graphics.Screen;
import com.golem.graphics.Window;
import com.golem.JavaGolemFactory;
import com.golem.input.KeyInputHandler;
import com.wheelStrike.model.map.ImageTileMapLoader;
import com.wheelStrike.model.map.Tile;
import com.wheelStrike.model.map.TileMap;
import com.wheelStrike.model.map.TileMapLoader;
import com.wheelStrike.model.vehicle.Direction;
import com.wheelStrike.model.vehicle.Jeep;

import java.util.HashMap;

/**
 * @author GromHoll
 */
public class TestMain {
    public static void main(String args[]) throws Exception {
        TileMapLoader tileMapLoader = new ImageTileMapLoader();
        TileMap tileMap = tileMapLoader.loadTileMap("./res/level/testLevel.png");

        GolemFactory factory = new JavaGolemFactory();
        Window window = factory.getWindow(tileMap.getWidth()* (int) Tile.width,
                                          tileMap.getWidth()* (int) Tile.width,
                                          "Map View");
        KeyInputHandler keyInputHandler = factory.getKeyInputHandler(window);
        ImageLoader imageLoader = factory.getImageLoader();
        Screen screen = window.getScreen();

        HashMap<Tile, Image> tileImageMap = new HashMap<Tile, Image>();
        tileImageMap.put(Tile.FOREST, imageLoader.loadImage("./res/tiles/forest.png"));
        tileImageMap.put(Tile.ROAD, imageLoader.loadImage("./res/tiles/road.png"));
        tileImageMap.put(Tile.CONCRETE, imageLoader.loadImage("./res/tiles/concrete.png"));
        tileImageMap.put(Tile.GRASS, imageLoader.loadImage("./res/tiles/grass.png"));
        tileImageMap.put(Tile.SOLID, imageLoader.loadImage("./res/tiles/solid.png"));
        tileImageMap.put(Tile.SAND, imageLoader.loadImage("./res/tiles/sand.png"));
        tileImageMap.put(Tile.WATER, imageLoader.loadImage("./res/tiles/water.png"));
        tileImageMap.put(Tile.SEA, imageLoader.loadImage("./res/tiles/sea.png"));

        HashMap<Direction, Image> jeepImageMap = new HashMap<Direction, Image>();
        jeepImageMap.put(Direction.DIRECTION_N, imageLoader.loadImage("./res/vehicles/jeep/jeep_N.png"));
        jeepImageMap.put(Direction.DIRECTION_NE, imageLoader.loadImage("./res/vehicles/jeep/jeep_NE.png"));
        jeepImageMap.put(Direction.DIRECTION_E, imageLoader.loadImage("./res/vehicles/jeep/jeep_E.png"));
        jeepImageMap.put(Direction.DIRECTION_SE, imageLoader.loadImage("./res/vehicles/jeep/jeep_SE.png"));
        jeepImageMap.put(Direction.DIRECTION_S, imageLoader.loadImage("./res/vehicles/jeep/jeep_S.png"));
        jeepImageMap.put(Direction.DIRECTION_SW, imageLoader.loadImage("./res/vehicles/jeep/jeep_SW.png"));
        jeepImageMap.put(Direction.DIRECTION_W, imageLoader.loadImage("./res/vehicles/jeep/jeep_W.png"));
        jeepImageMap.put(Direction.DIRECTION_NW, imageLoader.loadImage("./res/vehicles/jeep/jeep_NW.png"));

        System.out.println(Integer.toHexString(jeepImageMap.get(Direction.DIRECTION_NE).getAsBitmap().getPixel(0,0)));

        Jeep jeep = new Jeep((double)tileMap.getWidth()*Tile.width/2,
                             (double)tileMap.getHeight()*Tile.height/2);

        screen.present();
        while(true) {

            for(KeyEvent ke : keyInputHandler.getKeyEvents()) {
                if(ke.isPressed()) {
                    switch(ke.getChar()) {
                        case 'w':   jeep.setSpeedMultiplier(1);
                            break;
                        case 'a':   jeep.rotateLeft();
                            break;
                        case 's':   jeep.setSpeedMultiplier(-1);
                            break;
                        case 'd':   jeep.rotateRight();
                            break;
                    };
                } else {
                    switch(ke.getChar()) {
                        case 'w':   jeep.stop();
                            break;
                        case 's':   jeep.stop();
                            break;
                    };
                }
            }
            jeep.update(0.1);

            for(int i = 0; i < tileMap.getWidth(); i++) {
                for(int j = 0; j < tileMap.getHeight(); j++) {
                    screen.draw(tileImageMap.get(tileMap.getTile(i, j)),
                                                 i*(int) Tile.width,
                                                 j*(int) Tile.height);
                }
            }
            Image jeepImage = jeepImageMap.get(jeep.getDirection());
            screen.draw(jeepImage,
                        (int) jeep.getX() - jeepImage.getWidth()/2,
                        (int) jeep.getY() - jeepImage.getHeight()/2);

            screen.present();
            Thread.sleep(10);
        }
    }
}
