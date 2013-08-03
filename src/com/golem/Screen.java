package com.golem;

/**
 * @author GromHoll
 */
public interface Screen {

    public void present();
    public void dispose();

    public void draw(Image image, int x, int y);
    public void fill();

    public void setMaxFps(long fps);

}
