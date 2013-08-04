package com.golem.graphics.java;

import com.golem.graphics.Bitmap;
import com.golem.graphics.Image;

/**
 * @author GromHoll
 */
public class JavaImage extends Bitmap implements Image {

    public JavaImage(int width, int height) {
        super(width, height);
    }

    public Bitmap getAsBitmap() {
        return this;
    }
}
