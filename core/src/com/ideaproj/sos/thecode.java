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
        Info,
        Credits
    }

    ;

    public static stats gameStatus = null;

    public thecode(com.ideaproj.sos.tools.DeviceControl deviceControl) {
        super();
        this.deviceControl = deviceControl;
    }

    @Override
    public void create() {
        setScreen(new SplashScreen(this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("stage 1");
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("stage 2");
                        resources = new ResourceLoader();
                        resources.initializeResources();
                        System.out.println("stage 3");
                        gameStatus = stats.SplashReady;
                    }
                });

            }
        }).start();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public DeviceControl getDeviceControl() {
        return deviceControl;
    }

    public ResourceLoader getResources() {
        return resources;
    }

    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int n = max - min + 1;
        int i = rand.nextInt() % n;
        return i + min;
    }
}