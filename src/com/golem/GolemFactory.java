package com.golem;

/**
 * @author GromHoll
 */
public interface GolemFactory {

    public Window getWindow(int width, int height, String name);

    public KeyInputHandler getKeyInputHandler(Window window);

    public ImageLoader getImageLoader();

}
