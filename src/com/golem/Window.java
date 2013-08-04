package com.golem;

/**
 * @author GromHoll
 */
public interface Window {

    public Screen getScreen();

    public void setName(String name);

    public void addKeyEventListener(KeyEventListener listener);

    public void dispose();
}
