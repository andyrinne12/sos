package com.ideaproj.sos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ideaproj.sos.DeviceCameraControl;
import com.ideaproj.sos.thecode;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new thecode(new DeviceCameraControl() {
			@Override
			public void turnOnFlash() {

			}

			@Override
			public void turnOffFlash() {

			}

			@Override
			public boolean getFlash() {
				return false;
			}

			@Override
			public void getCamera() {

			}
		}), config);
	}
}
