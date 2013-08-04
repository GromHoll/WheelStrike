package com.golem.java;

import com.golem.GolemFactory;
import com.golem.ImageLoader;
import com.golem.KeyInputHandler;
import com.golem.Window;

/**
 * @author GromHoll
 */
public class JavaGolemFactory implements GolemFactory {

    @Override
    public Window getWindow(int width, int height, String name) {
        return new JavaWindow(width, height, name);
    }

    @Override
    public KeyInputHandler getKeyInputHandler(Window window) {
        return new JavaKeyInputHandler(window);
    }

    @Override
    public ImageLoader getImageLoader() {
        return new JavaImageLoader();
    }
}
