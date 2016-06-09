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

        if(keycode== Input.Keys.BACK) {
            if (thecode.gameStatus == thecode.stats.Menu)
                Gdx.app.exit();
            else  if(thecode.gameStatus == thecode.stats.KeyScreen)
            {
                thecode.gameStatus=thecode.stats.Menu;
       //         screen.cameraControl.turnOffFlash();
       //         screen.cameraControl.releaseCamera();
                screen.keyMenu=null;
            }
            else if(thecode.gameStatus == thecode.stats.Info)
                thecode.gameStatus= thecode.stats.Menu;

        }
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

        if(thecode.gameStatus== thecode.stats.Menu)
        screen.touch(screenX,screenY,pointer,button);
        else if(thecode.gameStatus== thecode.stats.KeyScreen)
            screen.keyMenu.touch(screenX,screenY,pointer,button);

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
