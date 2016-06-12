package com.ideaproj.sos.com.ideaproj.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.DeviceControl;

public class ReceiverScreen {

    private double actualTime,averageLight,allLight,lastTime,actualTime0,lastTime0;
    private boolean lighted;
    private Texture backgrounT;
    private TextureRegion background;
    private float gameWidth,gameHeight,lux;
    private MainScreen screen;
    private DeviceControl deviceControl;

    public ReceiverScreen(MainScreen screen)
    {
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        this.screen = screen;
        this.deviceControl = screen.getDeviceControl();
        deviceControl.readySensor();
        initializeTextures();
        actualTime = 0;
        lastTime=0;
    }

    private void initializeTextures()
    {
        backgrounT = new Texture(Gdx.files.internal("receiverBackground.jpg"));
        background = new TextureRegion(backgrounT);
        background.flip(false, true);
    }

    public void update(float delta)
    {
        lux = deviceControl.getLight();

        if(!lighted)
        actualTime0+=delta;

        if(lighted)
            actualTime+=delta;

        if(!lighted)
        allLight+=lux*delta;

        if(!lighted) {
            if (actualTime0 != lastTime0)
                averageLight = allLight / (actualTime0 - lastTime0);

            System.out.println(lux + " " + delta + "   " + averageLight);
        }

        if(lux-averageLight>=3 && !lighted && actualTime0>5)
        {
            lighted=true;
            actualTime=0;
        }
        if(lighted && lux-averageLight<3)
        {
         //   lighted=false;
            System.out.println(actualTime);

        }



    }

    public void touch(float screenX,float screenY,int pointer,int button)
    {

        actualTime0=0;
        lastTime0=0;
        averageLight=0;
        allLight=0;
    }

    public  void render(GameRenderer renderer)
    {
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(background,0,0,gameWidth*2,gameHeight*2);
        batcher.end();


//        shaper.begin();




    }





}
