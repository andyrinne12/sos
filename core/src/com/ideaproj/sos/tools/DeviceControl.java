package com.ideaproj.sos.tools;


public interface DeviceControl {

    //camera

    void turnOnFlash();

    void turnOffFlash();

    boolean getFlash();

    void getCamera();

    //sensor

    void readySensor();

    float getLight();

    boolean isCamera();

    void readyAltitudeSensor();

    int getHeight();

    void close();
}
