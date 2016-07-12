package com.ideaproj.sos.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ideaproj.sos.thecode;

/**
 * Created by Ioana on 12.07.2016.
 */
public class SplashScreen implements Screen {

    private final thecode main;
    int screenWidth, screenHeight, gameHeight, gameWidth;
    private OrthographicCamera cam;
    private SpriteBatch batcher;
    private ShapeRenderer shapeRenderer;


    public SplashScreen(thecode main){

        this.main = main;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameHeight = 640;
        gameWidth = 360;

        cam = new OrthographicCamera();//asta nush ce e cu ea
        cam.setToOrtho(true, gameWidth*2 , gameHeight*2);
        new FitViewport(gameWidth*2, gameHeight *2, cam);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

    }

    @Override
    public void show() {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.SALMON);
        shapeRenderer.rect(0,0,gameWidth*2,gameHeight*2);
        shapeRenderer.end();
    }

    @Override
    public void render(float delta) {

        if(thecode.gameStatus == thecode.stats.SplashReady && Gdx.input.justTouched()){
            thecode.gameStatus = thecode.stats.Menu;
            main.setScreen(new MainScreen(main.getDeviceControl()));
            this.dispose();
        }

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
}
