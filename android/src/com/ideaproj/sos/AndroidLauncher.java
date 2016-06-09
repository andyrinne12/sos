package com.ideaproj.sos;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        DeviceControl deviceControl =  new AndroidDeviceController(this);
    //    cameraControl.turnOnFlash();

        initialize(new thecode(deviceControl), config);
    }

}