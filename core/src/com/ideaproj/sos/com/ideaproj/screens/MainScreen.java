package com.ideaproj.sos.com.ideaproj.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.DeviceControl;
import com.ideaproj.sos.InputHandler;
import com.ideaproj.sos.thecode;

public class MainScreen implements Screen{

    private GameRenderer gameRenderer;
    float screenWidth,screenHeight,gameHeight,gameWidth;
    private InputHandler input;
    private DeviceControl deviceControl;
    private TextureRegion background,aboutBackground;
    private Texture backgrounT,aboutBackgroundT;
    private KeyScreen keyMenu;
    private ReceiverScreen receiveMenu;

    public MainScreen(DeviceControl deviceControl) {
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
        this.deviceControl = deviceControl;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameRenderer.render();

        if(thecode.gameStatus== thecode.stats.KeyScreen)
            keyMenu.updateStop(delta);

        else if(thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.update(delta);
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


        if(thecode.gameStatus== thecode.stats.KeyScreen)
            keyMenu.touch(screenX,screenY,pointer,button);
        else if(thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.touch(screenX,screenY,pointer,button);

        else {


            if (screenX >= 60 * ratioX && screenX <= 330 * ratioX && screenY >= 330 * ratioY && screenY <= 450 * ratioY) {
                thecode.gameStatus = thecode.stats.KeyScreen;
                keyMenu = new KeyScreen(this);
            }
            if (screenX >= 385*ratioX && screenX <= 655*ratioX && screenY >= 330*ratioY && screenY <= 450* ratioY) {
                thecode.gameStatus = thecode.stats.ReceiveScreen;
                receiveMenu = new ReceiverScreen(this);
            }
            if (screenX >= 60 * ratioX && screenX <= 330 * ratioX && screenY >= 530 * ratioY && screenY <= 650 * ratioY) {
                thecode.gameStatus = thecode.stats.Info;

            }
            if (screenX >= 420 && screenX <= 690 && screenY >= 530 && screenY <= 650) {
                //         thecode.gameStatus= thecode.stats.Settings;

            }
            if (screenX >= 420 && screenX <= 690 && screenY >= 730 && screenY <= 850) {
                //        thecode.gameStatus= thecode.stats.Credits;

            }
        }


    }

    public void keyDown(int keycode)
    {

        if(keycode == Input.Keys.BACK)
        {
            if(thecode.gameStatus== thecode.stats.Menu)
                Gdx.app.exit();
            else if(thecode.gameStatus == thecode.stats.KeyScreen){
                keyMenu = null;
                thecode.gameStatus = thecode.stats.Menu;}
            else if(thecode.gameStatus == thecode.stats.Info){
                thecode.gameStatus = thecode.stats.Menu;}
            else if(thecode.gameStatus == thecode.stats.ReceiveScreen){
            receiveMenu = null;
            thecode.gameStatus = thecode.stats.Menu;}
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
       if(thecode.gameStatus == thecode.stats.Menu || thecode.gameStatus == thecode.stats.Info)
           render(renderer);
        else if(thecode.gameStatus == thecode.stats.KeyScreen)
           keyMenu.render(renderer);
        else  if(thecode.gameStatus == thecode.stats.ReceiveScreen)
           receiveMenu.render(renderer);


    }

    private  void render(GameRenderer renderer)
    {

        BitmapFont felix=renderer.felix;
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        if(thecode.gameStatus== thecode.stats.Menu)
            batcher.draw(background,0,0,gameWidth*2,gameHeight*2);
        else if(thecode.gameStatus== thecode.stats.Info)
            batcher.draw(aboutBackground,0,0,gameWidth*2,gameHeight*2);
        batcher.end();

        shaper.set(ShapeRenderer.ShapeType.Line);
        shaper.setColor(Color.RED);
        //   shaper.rect(60,330,270,120);
        shaper.rect(380,330,270,120);
        //    shaper.rect(60,330+200,270,120);
        //   shaper.rect(60+360,330+200,270,120);
        //   shaper.rect(60+360,330+400,270,120);

    }

    public DeviceControl getDeviceControl()
    {
        return deviceControl;

    }

    public float getGameHeight() {
        return gameHeight;
    }

    public float getGameWidth() {
        return gameWidth;
    }

}
