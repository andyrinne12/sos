package com.ideaproj.sos;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();





        DeviceCameraControl cameraControl =  new AndroidDeviceCameraController(this);
        cameraControl.getCamera();
        initialize(new thecode(cameraControl), config);
    }

}