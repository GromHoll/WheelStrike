package com.golem.graphics;

import com.golem.input.KeyEventListener;

/**
 * @author GromHoll
 */
public interface Window {

    public Screen getScreen();

    public void setName(String name);

    public void addKeyEventListener(KeyEventListener listener);

    public void dispose();
}
