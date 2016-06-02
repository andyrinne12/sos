package com.ideaproj.sos.com.ideaproj.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.DeviceCameraControl;
import com.ideaproj.sos.InputHandler;
import com.ideaproj.sos.thecode;

public class MainScreen implements Screen{

    private GameRenderer gameRenderer;
    float screenWidth,screenHeight,gameHeight,gameWidth;
    private InputHandler input;
    public DeviceCameraControl cameraControl;
    private TextureRegion background,aboutBackground;
    private Texture backgrounT,aboutBackgroundT;
    public KeyScreen keyMenu;

    public MainScreen(DeviceCameraControl cameraControl) {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameHeight = 640;
        gameWidth = 360;
     //   gameWidth = gameHeight*(screenWidth/screenHeight);
        gameRenderer = new GameRenderer(gameWidth,gameHeight,this);
        texturesInitialize();
        input = new InputHandler(this);
        Gdx.input.setInputProcessor(input);
        Gdx.input.setCatchBackKey(true);
        this.cameraControl = cameraControl;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameRenderer.render();

        if(thecode.gameStatus== thecode.stats.KeyScreen)
            keyMenu.updateStop(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void touch(int screenX, int screenY, int pointer, int button) {

        float ratioX=screenWidth/(gameWidth*2);
        float ratioY=screenHeight/(gameHeight*2);


        //if(cameraControl.getFlash())cameraControl.turnOffFlash();
        //else cameraControl.turnOnFlash();
        //Gdx.input.vibrate(200);

        if(screenX>=60*ratioX && screenX<=330*ratioX && screenY>=330*ratioY && screenY<=450*ratioY)
        {
            thecode.gameStatus= thecode.stats.KeyScreen;
            keyMenu = new KeyScreen(gameWidth,gameHeight,this);
        }
        if(screenX>=420 && screenX<=690 && screenY>=330 && screenY<=450)
        {
 //           thecode.gameStatus= thecode.stats.TextScreen;

        }
        if(screenX>=60*ratioX && screenX<=330*ratioX && screenY>=530*ratioY && screenY<=650*ratioY)
        {
            thecode.gameStatus= thecode.stats.Info;

        }
        if(screenX>=420 && screenX<=690 && screenY>=530 && screenY<=650)
        {
   //         thecode.gameStatus= thecode.stats.Settings;

        }
        if(screenX>=420 && screenX<=690 && screenY>=730 && screenY<=850)
        {
    //        thecode.gameStatus= thecode.stats.Credits;

        }


    }

    private void texturesInitialize(){

        backgrounT = new Texture(Gdx.files.internal("main2.jpg"));
        aboutBackgroundT = new Texture(Gdx.files.internal("about.jpg"));
        background = new TextureRegion(backgrounT);
        aboutBackground = new TextureRegion(aboutBackgroundT);
        background.flip(false,true);
        aboutBackground.flip(false,true);
    }

    public void mainRender(GameRenderer renderer)
    {
        BitmapFont felix=renderer.felix;
        SpriteBatch batcher = renderer.batcher;
        ShapeRenderer shaper = renderer.shapeRenderer;

        if(thecode.gameStatus== thecode.stats.Menu)
        batcher.draw(background,0,0,gameWidth*2,gameHeight*2);
        else if(thecode.gameStatus== thecode.stats.Info)
            batcher.draw(aboutBackground,0,0,gameWidth*2,gameHeight*2);

        shaper.set(ShapeRenderer.ShapeType.Line);
        shaper.setColor(Color.RED);
     //   shaper.rect(60,330,270,120);
     //   shaper.rect(60+360,330,270,120);
    //    shaper.rect(60,330+200,270,120);
     //   shaper.rect(60+360,330+200,270,120);
     //   shaper.rect(60+360,330+400,270,120);




    }
}
