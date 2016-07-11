package com.ideaproj.sos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ideaproj.sos.tools.DeviceControl;
import com.ideaproj.sos.thecode;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new thecode(new DeviceControl() {
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

			@Override
			public void readySensor() {

			}

			@Override
			public float getLight() {
				return 0;
			}

			@Override
			public boolean isCamera() {
				return false;
			}

			@Override
			public void readyAltitudeSensor() {

			}

			@Override
			public int getHeight() {
				return 0;
			}
		}), config);
	}
}
