package com.ideaproj.sos.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ideaproj.sos.thecode;


public class SplashScreen implements Screen {

    private final thecode main;
    private final BitmapFont font1;
    int screenWidth, screenHeight, gameHeight, gameWidth;
    private OrthographicCamera cam;
    private float watch;
    private SpriteBatch batcher;
    private ShapeRenderer shapeRenderer;
    private Texture splashScreenT;
    private TextureRegion splashScreen;


    public SplashScreen(thecode main){

        this.main = main;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        gameHeight = 640;
        gameWidth = 360;
        watch = -50;

        cam = new OrthographicCamera();//asta nush ce e cu ea
        cam.setToOrtho(true, gameWidth*2 , gameHeight*2);
        new FitViewport(gameWidth*2, gameHeight *2, cam);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        splashScreenT = new Texture(Gdx.files.internal("logo.png"));
        splashScreen = new TextureRegion(splashScreenT);
        splashScreen.flip(false,true);
        font1 = new BitmapFont(Gdx.files.internal("ort.fnt"),true);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        System.out.println(thecode.gameStatus);

        if(thecode.gameStatus == thecode.stats.SplashReady && Gdx.input.justTouched()){
            thecode.gameStatus = thecode.stats.Menu;
            main.setScreen(new MainScreen(main.getDeviceControl(),main.getResources(),main));
            this.dispose();
        }

        if(watch>=-1000)
            watch-=delta;

        if(thecode.gameStatus == thecode.stats.SplashReady && watch<= -0.5f)
            watch=0.5f;



        Gdx.gl.glClearColor( 1, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        batcher.begin();
        batcher.draw(splashScreen,0,0,gameWidth*2,gameHeight*2);
        font1.setColor(220/255f,20/255f,60/255f,1);
        font1.getData().setScale(0.5f,0.5f);

        if(thecode.gameStatus == thecode.stats.SplashReady && watch>=0)
            font1.draw(batcher,"Press anywhere to continue",70,920);


        batcher.end();

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
