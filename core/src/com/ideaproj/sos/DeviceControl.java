package com.ideaproj.sos;


public interface DeviceControl {

    //camera

    void turnOnFlash();

    void turnOffFlash();

    boolean getFlash();

    void getCamera();

    //sensor

    void readySensor();

    float getLight();

}
