package com.golem.java;

import com.golem.common.Bitmap;
import com.golem.Image;

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
