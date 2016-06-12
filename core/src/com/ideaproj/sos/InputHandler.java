package com.ideaproj.sos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.ideaproj.sos.com.ideaproj.screens.MainScreen;



public class InputHandler implements InputProcessor {

    private MainScreen screen;


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

        screen.touch(screenX,screenY,pointer,button);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
}
