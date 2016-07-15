package com.ideaproj.sos.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.*;
import com.ideaproj.sos.tools.DeviceControl;
import com.ideaproj.sos.tools.GameRenderer;
import com.ideaproj.sos.tools.InputHandler;
import com.ideaproj.sos.tools.ResourceLoader;

public class MainScreen implements Screen {

    private final thecode main;
    private InputMultiplexer multiplexer;
    private com.ideaproj.sos.tools.GameRenderer gameRenderer;
    float screenWidth, screenHeight, gameHeight, gameWidth;
    private com.ideaproj.sos.tools.InputHandler input;
    private com.ideaproj.sos.tools.DeviceControl deviceControl;
    private TextureRegion background, aboutBackground;
    private Texture backgrounT, aboutBackgroundT;
    private KeyScreen keyMenu;
    private ReceiverScreen receiveMenu;
    private com.ideaproj.sos.screens.IntroReceiveScreen introReceiveMenu;
    private ResourceLoader resources;
    private AboutScreen aboutScreen;
    private CreditsScreen creditsScreen;

    public MainScreen(DeviceControl deviceControl, ResourceLoader resources,thecode main) {
        this.resources = resources;
        this.main = main;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameHeight = 640;
        gameWidth = 360;

        gameRenderer = new GameRenderer(gameWidth, gameHeight, this);

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

        if (thecode.gameStatus == thecode.stats.KeyScreen)
            keyMenu.update(delta);

        else if (thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.update(delta);

        else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
            introReceiveMenu.update(delta);
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


        float ratioX = screenWidth / (gameWidth * 2);
        float ratioY = screenHeight / (gameHeight * 2);
        int touchX = (int)(screenX/ratioX);
        int touchY = (int)(screenY/ratioY);


        if (thecode.gameStatus == thecode.stats.KeyScreen)
            keyMenu.touch(screenX, screenY, pointer, button);
        else if (thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.touch(screenX, screenY, pointer, button);
        else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
            introReceiveMenu.touch(screenX, screenY, pointer, button);
        else if(thecode.gameStatus == thecode.stats.Info)
        {

        }
        else if(thecode.gameStatus == thecode.stats.Credits)
        {

        }
        else {
            if (touchX >= 0   && touchX <= 500   && touchY >= 280   && touchY <= 410  ) {
                thecode.gameStatus = thecode.stats.KeyScreen;
                keyMenu = new KeyScreen(this);
            }
            if (touchX >= 0   && touchX <= 500   && touchY >= 440   && touchY <= 570  ) {
                thecode.gameStatus = thecode.stats.ReceiveScreen;
                receiveMenu = new ReceiverScreen(this);
            }
            if (touchX >= 0   && touchX <= 500   && touchY >= 600   && touchY <= 730  ) {
                thecode.gameStatus = thecode.stats.IntroReceiveScreen;
                introReceiveMenu = new IntroReceiveScreen(this);
            }
            if(touchX >= gameWidth*2-500 && touchX <=gameWidth*2 && touchY >= 750 && touchY <=880  )
            {
                thecode.gameStatus = thecode.stats.Info;
                aboutScreen = new AboutScreen(this);
            }
            if(touchX >= gameWidth*2-500 && touchX <=gameWidth*2 && touchY >= 910 && touchY <=1040  )
            {
                thecode.gameStatus = thecode.stats.Credits;
                creditsScreen = new CreditsScreen(this);
            }
        }


    }

    public void touchUp(int screenX,int screenY,int pointer,int button)
    {
        if(thecode.gameStatus == thecode.stats.Info)
        aboutScreen.touchUp();

    }

    public void touchDragged(int screenX, int screenY, int pointer) {

        if(thecode.gameStatus == thecode.stats.Info)
            aboutScreen.touchDragged(screenX,screenY);
    }

    public void keyDown(int keycode) {

        if (keycode == Input.Keys.BACK) {
            if (thecode.gameStatus == thecode.stats.Menu) {
                deviceControl.close();
            }
            else if (thecode.gameStatus == thecode.stats.KeyScreen) {
                keyMenu = null;
                thecode.gameStatus = thecode.stats.Menu;
            } else if (thecode.gameStatus == thecode.stats.Info) {
                thecode.gameStatus = thecode.stats.Menu;
            } else if (thecode.gameStatus == thecode.stats.ReceiveScreen) {
                receiveMenu.keyBack();
            } else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
                introReceiveMenu.keyBack();
            else if(thecode.gameStatus == thecode.stats.Info)
                thecode.gameStatus = thecode.stats.Menu;
            else if(thecode.gameStatus == thecode.stats.Credits)
                thecode.gameStatus = thecode.stats.Menu;
        }

    }

    private void texturesInitialize() {

        backgrounT = resources.mainBackground;
        background = new TextureRegion(backgrounT);
        background.flip(false, true);
    }

    public void mainRender(GameRenderer renderer) {

        System.out.println(thecode.gameStatus);

        if (thecode.gameStatus == thecode.stats.Menu)
            render(renderer);
        else if (thecode.gameStatus == thecode.stats.KeyScreen)
            keyMenu.render(renderer);
        else if (thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.render(renderer);
        else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
            introReceiveMenu.render(renderer);
        else if (thecode.gameStatus == thecode.stats.Info)
            aboutScreen.render(renderer);
        else if(thecode.gameStatus == thecode.stats.Credits)
            creditsScreen.render(renderer);

    }

    private void render(GameRenderer renderer) {

        BitmapFont felix = renderer.morse;
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
            batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.end();

        shaper.begin();
        shaper.set(ShapeRenderer.ShapeType.Line);
        shaper.setColor(Color.RED);
      //  shaper.rect(gameWidth*2-500,910,500,130);
        //   shaper.rect(0, 600, 500, 130);// mai facem unul acum? ..e nevoie sa intrebi? da stai sa ma gandesc pot lua o foaie? dc?...
        //    shaper.rect(0,440,500,130);//te critic..dar nu ma iau as de tine...ziceam le las asa?da
        shaper.end();
    }

    public DeviceControl getDeviceControl() {
        return deviceControl;

    }

    public float getGameHeight() {
        return gameHeight;
    }

    public float getGameWidth() {
        return gameWidth;
    }

    public InputHandler getInput() {
        return input;
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    public void setReceiveMenu(ReceiverScreen receiveMenu) {
        this.receiveMenu = receiveMenu;
    }

    public void setIntroReceiveMenu(com.ideaproj.sos.screens.IntroReceiveScreen introReceiveMenu) {
        this.introReceiveMenu = introReceiveMenu;
    }

    public ResourceLoader getResources() {
        return resources;
    }

}

