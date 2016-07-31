package com.ideaproj.sos.tools;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ideaproj.sos.screens.MainScreen;


public class GameRenderer {

    public BitmapFont morse;
    float gameWidth,gameHeight;
    private OrthographicCamera cam;
    private SpriteBatch batcher;
    private ShapeRenderer shapeRenderer;
    private MainScreen screen;


    public GameRenderer(float gameWidth,float gameHeight,MainScreen screen) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.screen=screen;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth*2 , gameHeight*2);
        new FitViewport(gameWidth*2, gameHeight *2, cam);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        morse = new BitmapFont(Gdx.files.internal("ort.fnt"),true);

    }

    public void render(){

        //se curata ecranul inainte de fiecare frame
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setAutoShapeType(true);

        screen.mainRender(this);

    shapeRenderer.end();


    }

    public SpriteBatch getBatcher() {
        return batcher;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }
}

