package com.golem.common;

/**
 * @author GromHoll
 */
public class ImageLoadException extends Exception {

    public ImageLoadException(String filename) {
        super("Fail load image: " + filename);
    }
}
