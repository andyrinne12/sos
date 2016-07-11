package com.ideaproj.sos.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.ideaproj.sos.tools.DeviceControl;
import com.ideaproj.sos.thecode;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new thecode(new DeviceControl() {
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
                });
                }
}