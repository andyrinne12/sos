package com.ideaproj.sos;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ideaproj.sos.tools.DeviceControl;

public class AndroidLauncher extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        DeviceControl deviceControl =  new AndroidDeviceController(this);
        //    cameraControl.turnOnFlash();

        //porneste procesul din #core
        initialize(new thecode(deviceControl), config);

    }

}