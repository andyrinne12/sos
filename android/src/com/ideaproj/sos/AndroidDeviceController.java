package com.ideaproj.sos;


import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import android.util.Log;

public class AndroidDeviceController implements DeviceControl{

    private Camera camera;
    private Camera.Parameters params;
    private AndroidLauncher activity;
    private boolean isFlashOn=false;
    private SensorManager myManager;
    private Sensor sensor;
    private float lightLevel;
    private SensorEventListener sensorEventListener;

    public AndroidDeviceController(AndroidLauncher activity)
    {
        this.activity=activity;
    }

    @Override
    public void turnOnFlash() {
        if(isFlashSupported()){
        if (!isFlashOn) {
            if (camera == null || params == null) {
                return;
            }
            System.out.println("wiajdlajjl");
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
        }
            else throw new RuntimeException();


    }
}

    @Override
    public void turnOffFlash() {
        if (isFlashSupported()) {
            if (isFlashOn) {
                if (camera == null || params == null) {
                    return;
                }
                for (int i = 1; i <= 100; i++)
                    System.out.println("wiajdlajjl");
                params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
                //       camera.stopPreview();
                isFlashOn = false;

            }
        } else throw new RuntimeException();
    }

    // Get the camera
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

    @Override
    public void readySensor(){

        myManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
        sensor = myManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorEventListener = new SensorEventListener(){

            @Override
            public void onSensorChanged(SensorEvent event) {
                lightLevel = event.values[0];
                System.out.println(event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        myManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public float getLight(){

        return lightLevel;

    }

    private boolean isFlashSupported() {
        PackageManager pm = activity.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }


    public boolean getFlash(){

        return isFlashOn;

    }
}
