package com.ideaproj.sos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.ideaproj.sos.screens.MainScreen;
import com.ideaproj.sos.screens.SplashScreen;
import com.ideaproj.sos.tools.DeviceControl;
import com.ideaproj.sos.tools.ResourceLoader;
import java.util.Random;

public class thecode extends Game {

    private DeviceControl deviceControl; // 1 variabila
    private ResourceLoader resources; // a 2-a variabila

    public enum stats {
        SplashReady,
        Menu,
        KeyScreen,
        ReceiveScreen,
        IntroReceiveScreen,
        Info
    };

    public static stats gameStatus = null;

    public thecode(com.ideaproj.sos.tools.DeviceControl deviceControl) {
        this.deviceControl = deviceControl;
    }

    @Override
    public void create() {
        setScreen(new SplashScreen(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                resources = new ResourceLoader();
                resources.initializeResources();
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        gameStatus = stats.SplashReady;
                    }
                });

            }


        });
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public DeviceControl getDeviceControl() {
        return deviceControl;
    }

    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int n = max - min + 1;
        int i = rand.nextInt() % n;
        return i + min;
    }
}