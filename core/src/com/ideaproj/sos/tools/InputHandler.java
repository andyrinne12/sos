package com.ideaproj.sos.tools;

import com.badlogic.gdx.InputProcessor;
import com.ideaproj.sos.screens.MainScreen;



public class InputHandler implements InputProcessor {

    private MainScreen screen;
    private boolean touched;


    public InputHandler(MainScreen screen) {
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {

        screen.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {


        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        this.touched = true;
        screen.touch(screenX, screenY, pointer, button);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.touched = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isTouched() {
        return touched;
    }

}