package com.ideaproj.sos.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Ioana on 12.07.2016.
 */
public class ResourceLoader {
    public Texture aboutBackground,mainBackground,keyScreenBackground,receiverBackground,textAbout,textAbout2,creditsBackground;
    public BitmapFont font1;
    public Music beep;
    public void initializeResources(){

        aboutBackground = new Texture (Gdx.files.internal("about.jpg"));
        keyScreenBackground = new Texture (Gdx.files.internal("keyBackground.jpg"));
        mainBackground = new Texture(Gdx.files.internal("main.jpg"));
        receiverBackground = new Texture(Gdx.files.internal("receiverBackground.jpg"));
        textAbout = new Texture(Gdx.files.internal("textp1.png"));
        textAbout2 = new Texture(Gdx.files.internal("textp2.png"));
        font1 = new BitmapFont(Gdx.files.internal("ort.fnt"),true);
        beep = Gdx.audio.newMusic(Gdx.files.internal("beep.mp3"));
        creditsBackground = new Texture(Gdx.files.internal("credits.jpg"));
    }
}
