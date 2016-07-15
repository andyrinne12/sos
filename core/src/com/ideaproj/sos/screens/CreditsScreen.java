package com.ideaproj.sos.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.tools.GameRenderer;
import com.ideaproj.sos.tools.ResourceLoader;

/**
 * Created by Andy on 14.07.2016.
 */

public class CreditsScreen {

    private MainScreen screen;
    private float gameWidth,gameHeight;
    private Texture creditsBackgroundT;
    private TextureRegion creditsBackground;


    public CreditsScreen(MainScreen screen)
    {
        this.screen = screen;
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        initializeTextures();
    }

    private void initializeTextures()
    {
        ResourceLoader resources = screen.getResources();
        creditsBackgroundT = resources.creditsBackground;
        creditsBackground = new TextureRegion(creditsBackgroundT);
        creditsBackground.flip(false,true);
    }



    public void render(GameRenderer renderer)
    {
        SpriteBatch batcher = renderer.getBatcher();

        batcher.begin();
        batcher.draw(creditsBackground,0,0,gameWidth*2,gameHeight*2);
        batcher.end();

    }

}
