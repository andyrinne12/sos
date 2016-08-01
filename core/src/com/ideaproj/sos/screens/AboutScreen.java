package com.ideaproj.sos.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.tools.GameRenderer;
import com.ideaproj.sos.tools.ResourceLoader;


public class AboutScreen {

    private MainScreen screen;
    private Color grey1, grey2;
    private float gameWidth, gameHeight, textY, lastY, touchX, touchY, watch;
    private Texture aboutBackgroundT,aboutTextT111,aboutTextT112,aboutTextT121,aboutTextT122,aboutTextT211,aboutTextT212,aboutTextT221,aboutTextT222;
    private TextureRegion aboutBackground, aboutText111,aboutText112,aboutText121,aboutText122,aboutText211,aboutText212,aboutText221,aboutText222;
    private GameRenderer renderer;

    public AboutScreen(MainScreen screen) {
        this.screen = screen;
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        initializeTextures();
        textY = 0;
        lastY = 0;
        watch = 0;

        grey1 = new Color(103 / 255f, 103 / 255f, 103 / 255f, 1);
        grey2 = new Color(64 / 255f, 64 / 255f, 64 / 255f, 1);
    }

    private void initializeTextures() {
        ResourceLoader resources = screen.getResources();

        aboutBackgroundT = resources.aboutBackground;
        aboutBackground = new TextureRegion(aboutBackgroundT);
        aboutBackground.flip(false, true);

        aboutTextT111 = resources.textAbout111;
        aboutTextT112 = resources.textAbout112;
        aboutTextT121 = resources.textAbout121;
        aboutTextT122 = resources.textAbout122;
        aboutTextT211 = resources.textAbout211;
        aboutTextT212 = resources.textAbout212;
        aboutTextT221 = resources.textAbout221;
        aboutTextT222 = resources.textAbout222;


        aboutText111 = new TextureRegion(aboutTextT111);
        aboutText111.flip(false, true);

        aboutText112 = new TextureRegion(aboutTextT112);
        aboutText112.flip(false, true);

        aboutText121 = new TextureRegion(aboutTextT121);
        aboutText121.flip(false, true);

        aboutText122 = new TextureRegion(aboutTextT122);
        aboutText122.flip(false, true);

        aboutText211 = new TextureRegion(aboutTextT211);
        aboutText211.flip(false, true);

        aboutText212 = new TextureRegion(aboutTextT212);
        aboutText212.flip(false, true);

        aboutText221 = new TextureRegion(aboutTextT221);
        aboutText221.flip(false, true);

        aboutText222 = new TextureRegion(aboutTextT222);
        aboutText222.flip(false, true);
    }

    public void render(GameRenderer renderer) {
        this.renderer = renderer;
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(aboutBackground, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.enableBlending();
        batcher.draw(aboutText111, 0, textY + 240, 720, 1275);
        batcher.draw(aboutText112, 0, textY + 240 + 1275*1, 720, 1275);
        batcher.draw(aboutText121, 0, textY + 240 + 1275*2, 720, 1275);
        batcher.draw(aboutText122, 0, textY + 240 + 1275*3, 720, 1275);
        batcher.draw(aboutText211, 0, textY + 240 + 1275*4, 720, 1275);
        batcher.draw(aboutText212, 0, textY + 240 + 1275*5, 720, 1275);
        batcher.draw(aboutText221, 0, textY + 240 + 1275*6, 720, 1275);
        batcher.draw(aboutText222, 0, textY + 240 + 1275*7, 720, 1275);


        //System.out.println(lastY + " " + touchY);
        batcher.end();

        int barLength = (int) ((gameHeight * 2 - 260) * (gameHeight * 2 - 240) / 10200);
        int barMaxLength = (int) (gameHeight * 2 - 260);
        int textLength = (int) (gameHeight * 2 - 240);
        int textMaxLength = 10200;
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(grey1);
        shaper.rect(695, 240, 20, gameHeight * 2 - 250);
        shaper.setColor(grey2);
        shaper.rect(700, 240 + 5 - (textY / (textMaxLength - textLength) * (barMaxLength - barLength)), 10, (gameHeight * 2 - 260) * (gameHeight * 2 - 240) / 10200);
    }


    //   textY / (textMaxLength-textLength) = barY / barMaxLength-barLength

    public void touchDragged(float screenX, float screenY) {
        touchX = screenX / Gdx.graphics.getWidth() * gameWidth * 2;
        touchY = screenY / Gdx.graphics.getHeight() * gameHeight * 2;

        if (lastY == -1)
            lastY = touchY;
        else {
            if (textY + touchY - lastY <= 0 && textY + touchY - lastY >= -(10200 - (gameHeight * 2 - 240)))
                textY += touchY - lastY;
            lastY = touchY;
        }

    }

    public void touchUp() {
        lastY = -1;
    }


}

//5205 linii
