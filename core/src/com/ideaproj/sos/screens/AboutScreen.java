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
    private Texture aboutBackgroundT, aboutTextT, aboutTextT2;
    private TextureRegion aboutBackground, aboutText, aboutText2;
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

        aboutTextT = resources.textAbout;
        aboutTextT2 = resources.textAbout2;

        aboutText = new TextureRegion(aboutTextT);
        aboutText.flip(false, true);

        aboutText2 = new TextureRegion(aboutTextT2);
        aboutText2.flip(false, true);
    }

    public void render(GameRenderer renderer) {
        this.renderer = renderer;
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(aboutBackground, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.enableBlending();
        batcher.draw(aboutText, 0, textY + 240, 720, 5100);
        batcher.draw(aboutText2, 0, textY + 240 + 5100, 720, 5100);

        System.out.println(lastY + " " + touchY);
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
