package com.ideaproj.sos;

import com.badlogic.gdx.Game;
import com.ideaproj.sos.com.ideaproj.screens.MainScreen;

public class thecode extends Game {

    private DeviceControl deviceControl;
    public enum stats{
        Splash,
        Menu,
        KeyScreen,
        TextScreen,
        Info,
        Credits,
        Settings
    };
    public static stats gameStatus=stats.Menu;

    public thecode(DeviceControl deviceControl) {
        this.deviceControl = deviceControl;
    }

    @Override
	public void create() {
        gameStatus=stats.Menu;
		setScreen(new MainScreen(deviceControl));
	}

    @Override
    public void dispose(){
        super.dispose();
    }
}
