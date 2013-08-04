package com.golem;

import com.golem.graphics.ImageLoader;
import com.golem.graphics.Window;
import com.golem.input.KeyInputHandler;

/**
 * @author GromHoll
 */
public interface GolemFactory {

    public Window getWindow(int width, int height, String name);

    public KeyInputHandler getKeyInputHandler(Window window);

    public ImageLoader getImageLoader();

}
