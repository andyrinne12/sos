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
import com.ideaproj.sos.tools.GameRenderer;
import com.ideaproj.sos.tools.InputHandler;

public class MainScreen implements Screen {

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

    public MainScreen(com.ideaproj.sos.tools.DeviceControl deviceControl) {
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


        if (thecode.gameStatus == thecode.stats.KeyScreen)
            keyMenu.touch(screenX, screenY, pointer, button);
        else if (thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.touch(screenX, screenY, pointer, button);
        else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
            introReceiveMenu.touch(screenX, screenY, pointer, button);

        else {
            if (screenX >= 0 * ratioX && screenX <= 500 * ratioX && screenY >= 280 * ratioY && screenY <= 410 * ratioY) {
                thecode.gameStatus = thecode.stats.KeyScreen;
                keyMenu = new KeyScreen(this);
            }
            if (screenX >= 0 * ratioX && screenX <= 500 * ratioX && screenY >= 440 * ratioY && screenY <= 570 * ratioY) {
                thecode.gameStatus = thecode.stats.ReceiveScreen;
                receiveMenu = new ReceiverScreen(this);
            }
            if (screenX >= 0 * ratioX && screenX <= 500 * ratioX && screenY >= 600 * ratioY && screenY <= 730 * ratioY) {
                thecode.gameStatus = thecode.stats.IntroReceiveScreen;
                introReceiveMenu = new com.ideaproj.sos.screens.IntroReceiveScreen(this);
            }
        }


    }

    public void keyDown(int keycode) {

        if (keycode == Input.Keys.BACK) {
            if (thecode.gameStatus == thecode.stats.Menu)
                Gdx.app.exit();
            else if (thecode.gameStatus == thecode.stats.KeyScreen) {
                keyMenu = null;
                thecode.gameStatus = thecode.stats.Menu;
            } else if (thecode.gameStatus == thecode.stats.Info) {
                thecode.gameStatus = thecode.stats.Menu;
            } else if (thecode.gameStatus == thecode.stats.ReceiveScreen) {
                receiveMenu.keyBack();
            } else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
                introReceiveMenu.keyBack();
        }

    }

    private void texturesInitialize() {

        backgrounT = new Texture(Gdx.files.internal("main2.jpg"));
        aboutBackgroundT = new Texture(Gdx.files.internal("about.jpg"));
        background = new TextureRegion(backgrounT);
        aboutBackground = new TextureRegion(aboutBackgroundT);
        background.flip(false, true);
        aboutBackground.flip(false, true);
    }

    public void mainRender(com.ideaproj.sos.tools.GameRenderer renderer) {
        if (thecode.gameStatus == thecode.stats.Menu || thecode.gameStatus == thecode.stats.Info)
            render(renderer);
        else if (thecode.gameStatus == thecode.stats.KeyScreen)
            keyMenu.render(renderer);
        else if (thecode.gameStatus == thecode.stats.ReceiveScreen)
            receiveMenu.render(renderer);
        else if (thecode.gameStatus == thecode.stats.IntroReceiveScreen)
            introReceiveMenu.render(renderer);


    }

    private void render(com.ideaproj.sos.tools.GameRenderer renderer) {

        BitmapFont felix = renderer.morse;
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        if (thecode.gameStatus == thecode.stats.Menu)
            batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        else if (thecode.gameStatus == thecode.stats.Info)
            batcher.draw(aboutBackground, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.end();

        shaper.begin();
        shaper.set(ShapeRenderer.ShapeType.Line);
        shaper.setColor(Color.RED);

        //   shaper.rect(0, 600, 500, 130);// mai facem unul acum? ..e nevoie sa intrebi? da stai sa ma gandesc pot lua o foaie? dc?...
        //    shaper.rect(0,440,500,130);//te critic..dar nu ma iau as de tine...ziceam le las asa?da
        shaper.end();
    }

    public com.ideaproj.sos.tools.DeviceControl getDeviceControl() {
        return deviceControl;

    }

    public float getGameHeight() {
        return gameHeight;
    }

    public float getGameWidth() {
        return gameWidth;
    }

    public com.ideaproj.sos.tools.InputHandler getInput() {
        return input;
    }

    public com.ideaproj.sos.tools.GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    public void setReceiveMenu(ReceiverScreen receiveMenu) {
        this.receiveMenu = receiveMenu;
    }

    public void setIntroReceiveMenu(com.ideaproj.sos.screens.IntroReceiveScreen introReceiveMenu) {
        this.introReceiveMenu = introReceiveMenu;
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public float getScreenHeight() {
        return screenHeight;
    }
}

