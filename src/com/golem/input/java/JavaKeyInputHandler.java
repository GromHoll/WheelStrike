package com.golem.input.java;

import com.golem.input.KeyEventListener;
import com.golem.input.KeyInputHandler;
import com.golem.graphics.Window;
import com.golem.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GromHoll
 */
public class JavaKeyInputHandler implements KeyInputHandler, KeyEventListener {

    private List<KeyEvent> keysBuffer = new ArrayList<KeyEvent>();
    private List<KeyEvent> keysList = new ArrayList<KeyEvent>();

    public JavaKeyInputHandler(Window window) {
        window.addKeyEventListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keysBuffer.add(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysBuffer.add(e);
    }

    @Override
    public List<KeyEvent> getKeyEvents() {
        synchronized (this) {
            keysList.clear();
            keysList.addAll(keysBuffer);
            keysBuffer.clear();
            return keysList;
        }
    }
}
