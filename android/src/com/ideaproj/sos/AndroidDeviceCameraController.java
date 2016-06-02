package com.ideaproj.sos;


import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

public class AndroidDeviceCameraController implements DeviceCameraControl{

    private Camera camera;
    private Camera.Parameters params;
    private AndroidLauncher activity;
    private boolean isFlashOn=false;

    public AndroidDeviceCameraController(AndroidLauncher activity)
    {
        this.activity=activity;
    }

    @Override
    public void turnOnFlash() {
        if (!isFlashOn) {
            if (camera == null || params == null) {
                return;
            }

     //       params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
     //       camera.startPreview();
            isFlashOn = true;



    }
}

    @Override
    public void turnOffFlash() {
        if (isFlashOn) {
            if (camera == null || params == null) {
                return;
            }

    //            params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
    //           camera.stopPreview();
                isFlashOn = false;

            }
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

    private boolean isFlashSupported() {
        PackageManager pm = activity.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public boolean getFlash(){

        return isFlashOn;

    }
}
