package com.ideaproj.sos;


import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.badlogic.gdx.Gdx;

public class AndroidDeviceController implements com.ideaproj.sos.tools.DeviceControl {

    private Camera camera;
    private Camera.Parameters params;
    private AndroidLauncher activity;
    private boolean isFlashOn = false, heightFound = false;
    private SensorManager myManager, myManager2;
    private Sensor sensor, presureSensor;
    private float lightLevel, pressure, height;
    private SensorEventListener sensorEventListener, presureSensorEventListener;

    public AndroidDeviceController(AndroidLauncher activity) {
        this.activity = activity;
    }

    @Override

    //porneste camera
    public void turnOnFlash() {
        if (isFlashSupported()) {
            if (!isFlashOn) {
                //verifica daca exista camera
                if (camera == null || params == null) {
                    throw new RuntimeException();
                }
                params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
                camera.startPreview();
                isFlashOn = true;
            }

        }
        //  else throw new RuntimeException();

    }

    //opreste camera
    @Override
    public void turnOffFlash() {
        if (isFlashSupported()) {
            if (isFlashOn) {
                if (camera == null || params == null) {
                    return;
                }
                params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
                //       camera.stopPreview();
                isFlashOn = false;

            }
        }// else throw new RuntimeException();
    }

    // porneste camera dispozitivului
    public void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
                camera.startPreview();
            } catch (RuntimeException e) {
                Log.e("Camera Error. Error: ", e.getMessage());
            }
        }
    }

    //porneste senzorul actualizeaza valoarea actuala a senzorului
    @Override
    public void readySensor() {

        myManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        sensor = myManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorEventListener = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event) {
                //valoarea senzorului
                lightLevel = event.values[0];
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        myManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public float getLight() {

        return lightLevel;

    }

    //verifica daca exista comera cu flash
    private boolean isFlashSupported() {
        PackageManager pm = activity.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public boolean getFlash() {

        return isFlashOn;

    }

    public boolean isCamera() {
        return camera != null;
    }

    //pregateste senzorul si preia valoarea altitudinii actuale
    @Override
    public void readyAltitudeSensor() {
        myManager2 = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        presureSensor = myManager2.getDefaultSensor(Sensor.TYPE_PRESSURE);
        presureSensorEventListener = new SensorEventListener() {


            @Override
            public void onSensorChanged(SensorEvent event) {
                pressure = event.values[0];
                height = SensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, pressure);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        myManager2.registerListener(presureSensorEventListener, presureSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public int getHeight() {
        return (int) height;
    }

    //opreste aplicatia
    @Override
    public void close() {
        Gdx.app.exit();
        activity.finish();
        System.exit(0);
    }
}
