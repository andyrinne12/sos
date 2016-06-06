package com.ideaproj.sos.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.ideaproj.sos.DeviceCameraControl;
import com.ideaproj.sos.thecode;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new thecode(new DeviceCameraControl() {
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
                });
                }
}