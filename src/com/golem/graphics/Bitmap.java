package com.golem.graphics;

import java.util.Arrays;

/**
 * @author GromHoll
 */
public class Bitmap {

    // Если понадобиться дать доступ к w и h - можно вместо getter сделать их public final
    private int w;
    private int h;
    private int[] pixels;

    public Bitmap(int width, int height) {
        this.w = width;
        this.h = height;
        this.pixels = new int[width*height];
    }

    public void setPixelsBuffer(int[] buffer) {
        if(buffer.length == w*h) {
            pixels = buffer;
        }
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getPixel(int x, int y) {
        return pixels[w*y + x];
    }

    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }

    public void fill(int color) {
        Arrays.fill(pixels, color);
    }

    public void draw(Bitmap bitmap, int x, int y) {
        int x0 = x;
        int y0 = y;
        int x1 = x + bitmap.w;
        int y1 = y + bitmap.h;

        if (x0 < 0) x0 = 0;
        if (y0 < 0) y0 = 0;
        if (x1 > w) x1 = w;
        if (y1 > h) y1 = h;

        int ww = x1 - x0;
        for(int yy = y0; yy < y1; yy++) {
            int tp = yy* w + x0;
            int sp = (yy - y)*bitmap.w + (x0 - x);
            tp -= sp;
            for (int xx = sp; xx < sp + ww; xx++) {
                int col = bitmap.pixels[xx];
                if (col < 0) pixels[tp + xx] = col;
            }
        }
    }
}
