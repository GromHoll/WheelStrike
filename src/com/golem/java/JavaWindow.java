package com.golem.java;

import com.golem.Screen;
import com.golem.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * @author GromHoll
 */
public class JavaWindow extends JFrame implements Window {

    private JavaScreen screen;
    private BufferStrategy strategy;

    public JavaWindow(int width, int height, String name) {
        super(name);
        this.screen = new JavaScreen(width, height, this);

        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.pack();
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // TODO set NOTHING_ON_CLOSE
        this.setVisible(true);

        this.strategy = getBufferStrategy();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public void render(JavaScreen screen) {
        strategy.getDrawGraphics().drawImage(screen.getImage(), 0, 0, null);
        strategy.show();
    }

    @Override
    public Screen getScreen() {
        return screen;
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        if (super.getBufferStrategy() == null) {
            createBufferStrategy(3);
        }
        return super.getBufferStrategy();
    }

    @Override
    public void paint(Graphics g) {
        // Stub for excluding redrawing by system
    }

    @Override
    public void update(Graphics g) {
        // Stub for excluding redrawing by system
    }
}
