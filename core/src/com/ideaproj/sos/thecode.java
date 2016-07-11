package com.ideaproj.sos;

import com.badlogic.gdx.Game;
import com.ideaproj.sos.screens.MainScreen;

import java.util.Random;

public class thecode extends Game {

    private com.ideaproj.sos.tools.DeviceControl deviceControl;

    public enum stats {
        Splash,
        Menu,
        KeyScreen,
        ReceiveScreen,
        IntroReceiveScreen,
        Info
    }

    ;
    public static stats gameStatus = stats.Menu;

    public thecode(com.ideaproj.sos.tools.DeviceControl deviceControl) {
        this.deviceControl = deviceControl;
    }

    @Override
    public void create() {
        gameStatus = stats.Menu;
        setScreen(new MainScreen(deviceControl));
    }

    @Override
    public void dispose() {
        super.dispose();
    }


    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int n = max - min + 1;
        int i = rand.nextInt() % n;
        return i + min;
    }
}