package com.golem;

import com.golem.GolemFactory;
import com.golem.graphics.ImageLoader;
import com.golem.graphics.java.JavaImageLoader;
import com.golem.graphics.java.JavaWindow;
import com.golem.input.KeyInputHandler;
import com.golem.graphics.Window;
import com.golem.input.java.JavaKeyInputHandler;

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
