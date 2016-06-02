package com.ideaproj.sos.com.ideaproj.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ideaproj.sos.thecode;


public class GameRenderer {

    public BitmapFont felix;
    float gameWidth,gameHeight;
    private OrthographicCamera cam;
    public SpriteBatch batcher;
    public ShapeRenderer shapeRenderer;
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
        felix = new BitmapFont(Gdx.files.internal("felix.fnt"),true);

    }

    public void render(){

        Gdx.gl.glClearColor(10 / 255.0f, 15 / 255.0f, 230 / 255.0f, 1f);

    batcher.begin();
        batcher.enableBlending();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();

       if(thecode.gameStatus== thecode.stats.Menu || thecode.gameStatus== thecode.stats.Info)
            screen.mainRender(this);
        else if(thecode.gameStatus == thecode.stats.KeyScreen )
           screen.keyMenu.render(this);


    batcher.end();
    shapeRenderer.end();


    }

    }

