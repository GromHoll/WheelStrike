package com.golem.graphics.java;

import com.golem.input.KeyEventListener;
import com.golem.graphics.Screen;
import com.golem.graphics.Window;
import com.golem.input.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
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
    public void addKeyEventListener(final KeyEventListener listener) {
        super.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {}

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                listener.keyPressed(new KeyEvent(e.getKeyChar(), e.getKeyCode(), true));
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                listener.keyReleased(new KeyEvent(e.getKeyChar(), e.getKeyCode(), false));
            }
        });
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
