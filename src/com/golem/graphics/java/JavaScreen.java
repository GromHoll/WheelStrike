package com.golem.graphics.java;

import com.golem.graphics.Bitmap;
import com.golem.graphics.Image;
import com.golem.graphics.Screen;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author GromHoll
 */
public class JavaScreen extends Bitmap implements Screen {

    private JavaWindow window;
    private BufferedImage image;

    public JavaScreen(int width, int height, JavaWindow window) {
        super(width, height);
        this.window = window;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.setPixelsBuffer(((DataBufferInt) image.getRaster().getDataBuffer()).getData());
    }

    @Override
    public void present() {
        window.render(this);
    }

    @Override
    public void dispose() {}

    @Override
    public void draw(Image image, int x, int y) {
        draw(image.getAsBitmap(), x, y);
    }

    @Override
    public void fill() {
        // TODO
    }

    @Override
    public void setMaxFps(long fps) {
        // TODO add fps sync
    }

    public BufferedImage getImage() {
        return image;
    }
}
