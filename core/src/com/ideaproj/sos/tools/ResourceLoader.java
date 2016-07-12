package com.ideaproj.sos.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Ioana on 12.07.2016.
 */
public class ResourceLoader {
    public Texture aboutBackground;
    public Texture keyScreenBackground;
    public Texture mainBackground;
    public Texture main2Background;
    public BitmapFont font1;


    public void initializeResources(){

        aboutBackground = new Texture (Gdx.files.internal("about.jpg"));
        keyScreenBackground = new Texture (Gdx.files.internal("keyBackground.jpg"));
        mainBackground = new Texture(Gdx.files.internal("main.jpg"));
        main2Background = new Texture(Gdx.files.internal("main2.jpg"));
        font1 = new BitmapFont(Gdx.files.internal("ort.fnt"),true);

    }
}
