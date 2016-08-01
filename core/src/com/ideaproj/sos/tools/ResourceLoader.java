package com.ideaproj.sos.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class ResourceLoader {
    public Texture aboutBackground,mainBackground,keyScreenBackground,receiverBackground,textAbout111,textAbout112,textAbout121,textAbout122,textAbout211,textAbout212,textAbout221,textAbout222,creditsBackground;
    public BitmapFont font1;
    public Music beep;
    public void initializeResources(){

        aboutBackground = new Texture (Gdx.files.internal("about.jpg"));
        keyScreenBackground = new Texture (Gdx.files.internal("keyBackground.jpg"));
        mainBackground = new Texture(Gdx.files.internal("main.jpg"));
        receiverBackground = new Texture(Gdx.files.internal("receiverBackground.jpg"));
        textAbout111 = new Texture(Gdx.files.internal("textp1p1p1.png"));
        textAbout112 = new Texture(Gdx.files.internal("textp1p1p2.png"));
        textAbout121 = new Texture(Gdx.files.internal("textp1p2p1.png"));
        textAbout122 = new Texture(Gdx.files.internal("textp1p2p2.png"));
        textAbout211 = new Texture(Gdx.files.internal("textp2p1p1.png"));
        textAbout212 = new Texture(Gdx.files.internal("textp2p1p2.png"));
        textAbout221 = new Texture(Gdx.files.internal("textp2p2p1.png"));
        textAbout222 = new Texture(Gdx.files.internal("textp2p2p2.png"));

        font1 = new BitmapFont(Gdx.files.internal("ort.fnt"),true);
        beep = Gdx.audio.newMusic(Gdx.files.internal("beep.mp3"));
        creditsBackground = new Texture(Gdx.files.internal("credits.jpg"));
    }
}
