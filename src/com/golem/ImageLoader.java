package com.golem;

import com.golem.common.ImageLoadException;

/**
 * @author GromHoll
 */
public interface ImageLoader {

    public Image loadImage(String filename) throws ImageLoadException;

}
