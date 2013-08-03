package com.golem.java;

import com.golem.ImageLoader;
import com.golem.common.ImageLoadException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author GromHoll
 */
public class JavaImageLoader implements ImageLoader {

    @Override
    public JavaImage loadImage(String filename) throws ImageLoadException {
        try {
            BufferedImage bi = ImageIO.read(new File(filename));

            int w = bi.getWidth();
            int h = bi.getHeight();

            JavaImage image = new JavaImage(w, h);
            bi.getRGB(0, 0, w, h, image.getPixels(), 0, w);

            return image;
        } catch (IOException e) {
            throw new ImageLoadException(filename);
        }
    }
}
