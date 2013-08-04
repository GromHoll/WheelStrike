package com.golem.graphics;

/**
 * @author GromHoll
 */
public interface ImageLoader {

    public Image loadImage(String filename) throws ImageLoadException;

}
