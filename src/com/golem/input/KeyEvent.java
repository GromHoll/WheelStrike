package com.golem.input;

/**
 * @author GromHoll
 */
public class KeyEvent {
    public static enum State {KEY_DOWN, KEY_UP};

    private State keyState;
    private int keyCode;
    private char keyChar;

    public KeyEvent(char keyChar, int keyCode, State keyState) {
        this.keyChar = keyChar;
        this.keyCode = keyCode;
        this.keyState = (keyState != null) ? keyState : State.KEY_DOWN;
    }

    public KeyEvent(char keyChar, int keyCode, boolean isPressed) {
        this(keyChar, keyCode, isPressed ? State.KEY_DOWN : State.KEY_UP);
    }

    public char getChar() {
        return  keyChar;
    }
    public int getCode() {
        return keyCode;
    }
    public State getState() {
        return keyState;
    }

    public boolean isPressed() {
        return keyState == State.KEY_DOWN;
    }
    public boolean isReleased() {
        return keyState == State.KEY_UP;
    }

}
