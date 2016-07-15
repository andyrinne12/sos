package com.ideaproj.sos.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.tools.GameRenderer;
import com.ideaproj.sos.thecode;
import com.ideaproj.sos.tools.ResourceLoader;

public class IntroReceiveScreen {

    private BitmapFont font;
    private MainScreen screen;
    private boolean mainScreen;
    private float gameWidth, gameHeight;
    private int posSign, posLetter;
    private Color lightGold, veryDarkGrey;
    private TextureRegion background;
    private Texture backgrounT;
    private int[][] morseCode;
    private int[] currentLetter;
    private char[] currentText;


    public IntroReceiveScreen(MainScreen screen) {
        this.screen = screen;
        this.gameHeight = screen.getGameHeight();
        this.gameWidth = screen.getGameWidth();
        posSign = 0;
        posLetter = 1;
        lightGold = new Color(161 / 255f, 128 / 255f, 77 / 255f, 1);
        veryDarkGrey = new Color(10 / 255f, 10 / 255f, 20 / 255f, 1);
        initializeCode();
        initializeTextures();
        mainScreen = true;
        font = screen.getGameRenderer().morse;
        currentLetter = new int[8];
        currentText = new char[999];
        posSign = 0;
        posLetter = 1;
    }

    private void initializeCode() {
        morseCode = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // -
                {5, 1, 3, 3, 3, 3},  // 1
                {5, 1, 1, 3, 3, 3},  // 2
                {5, 1, 1, 1, 3, 3},  // 3
                {5, 1, 1, 1, 1, 3},  // 4
                {5, 1, 1, 1, 1, 1},  // 5
                {5, 3, 1, 1, 1, 1},  // 6
                {5, 3, 3, 3, 3, 3},  // 7
                {5, 3, 3, 3, 1, 1},  // 8
                {5, 3, 3, 3, 3, 1},  // 5
                {5, 3, 3, 3, 3, 3},  // 0
                {4, 3, 3, 1, 3}, // Q
                {3, 1, 3, 3}, // W
                {1, 1}, // E
                {3, 1, 3, 1}, // R
                {1, 3}, // T
                {4, 3, 1, 3, 3}, // Y
                {3, 1, 1, 3}, // U
                {2, 1, 1}, //I
                {3, 3, 3, 3}, //O
                {4, 1, 3, 3, 1}, //P
                {2, 1, 3}, //A
                {3, 1, 1, 1}, //S
                {3, 3, 1, 1}, //D
                {4, 1, 1, 3, 1}, //F
                {3, 3, 3, 1}, // G
                {4, 1, 1, 1, 1}, // H
                {4, 1, 3, 3, 3}, // J
                {3, 3, 1, 3}, //K
                {4, 1, 3, 1, 1}, //L
                {4, 3, 3, 1, 1}, //Z
                {4, 3, 1, 1, 3}, //X
                {4, 3, 1, 3, 1}, //C
                {4, 1, 1, 1, 3}, //V
                {4, 3, 1, 1, 1}, //B
                {2, 3, 1}, //N
                {2, 3, 3}, //M
        };


    }

    private void initializeTextures() {
        ResourceLoader resources = screen.getResources();

        backgrounT = resources.receiverBackground;
        background = new TextureRegion(backgrounT);
        background.flip(false, true);
    }

    //update

    public void update(float delta) {

        System.out.println(posLetter);
        //     for (int i = 1; i <= posLetter; i++)
        //         System.out.print(currentText[i] + " ");
    }

    public void touch(float screenX, float screenY, int pointer, int button) {
        float touchX = screenX / screen.screenWidth * gameWidth * 2;
        float touchY = screenY / screen.screenHeight * gameHeight * 2;
        if (mainScreen) {
            if (touchX >= 50 && touchX <= 160 && touchY >= 990 && touchY <= 1100) {
                if (posSign <= 4)
                    currentLetter[++posSign] = 1;
            } else if (touchX >= 230 && touchX <= 340 && touchY >= 990 && touchY <= 1100) {
                if (posSign <= 4)
                    currentLetter[++posSign] = 3;
            } else if (touchX >= 370 && touchX <= 505 && touchY >= 990 && touchY <= 1100) {
                if (bindLetter(posLetter)) {
                    posLetter++;
                    currentLetter = new int[10];
                    posSign = 0;
                }
            } else if (touchX >= 530 && touchX <= 665 && touchY >= 990 && touchY <= 1100) {
                currentText[posLetter] = ' ';
                posLetter++;
            } else if (touchX >= 70 && touchX <= 235 && touchY >= 1140 && touchY <= 1250) {
                if (posSign >= 1)
                    currentLetter[posSign--] = 0;
            } else if (touchX >= 270 && touchX <= 430 && touchY >= 1140 && touchY <= 1250) {
                if (posLetter > 1) {
                    posLetter--;
                    currentText[posLetter] = ' ';
                }
            } else if (touchX >= 470 && touchX <= 630 && touchY >= 1140 && touchY <= 1250) {
                currentText = new char[999];
                currentLetter = new int[10];
            }
        }
    }

    public void keyBack() {

        //     if()
        screen.setIntroReceiveMenu(null);
        thecode.gameStatus = thecode.stats.Menu;

    }
    //render

    public void render(GameRenderer renderer) {
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.end();

        drawTextScreen(batcher, shaper);
        drawSignScreen(batcher, shaper);
        drawPointButton(batcher, shaper);
        drawLineButton(batcher, shaper);
        drawEndCharButton(batcher, shaper);
        drawSpaceButton(batcher, shaper);
        drawDeleteSignButton(batcher, shaper);
        drawDeleteCharButton(batcher, shaper);
        drawClearScreenButton(batcher, shaper);


    }

    private void drawTextScreen(SpriteBatch batcher, ShapeRenderer shaper) {
        //mini-screen for text
        shaper.begin();
        shaper.setColor(lightGold);
        shaper.set(ShapeRenderer.ShapeType.Filled);

        shaper.rect(30, 410, gameWidth * 2 - 2 * 30, 550);
        shaper.setColor(Color.BLACK);
        shaper.rect(30 + 10, 410 + 10, gameWidth * 2 - 2 * (30 + 10), 550 - 2 * 10);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(1f, 1f);
        for (int i = 1; i <= posLetter; i++)
            font.draw(batcher, String.valueOf(currentText[i]), 60 + (i % 13 != 0 ? i % 13 - 1 : 13 - 1) * 50, 435 + ((i / 13)) * 60);
        batcher.end();

    }

    private void drawSignScreen(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(30, 230, gameWidth * 2 - 2 * 30, 190);
        shaper.setColor(Color.BLACK);
        shaper.rect(30 + 10, 230 + 10, gameWidth * 2 - 2 * (30 + 10), 190 - 2 * 10);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.5f, 0.5f);
        font.draw(batcher, "Receiving Letter: ", 140, 260);
        batcher.end();

        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);

        for (int i = 1; i <= posSign; i++) {
            int s = currentLetter[i];
            if (s == 1) {
                shaper.circle(120 + 100 * (i - 1) + 35, 350, 20);
            } else if (s == 3) {
                shaper.rect(120 + 100 * (i - 1), 350 - 10 / 2, 70, 10);
                // aia e cea mai de cacat poveste pe care o stiu...imi place mai mult capra cu 3 iezi...aia e despre razbunare si chestii!!!!ce
            }
        }

        shaper.end();
    }

    private void drawPointButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(50, 990, 110, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(55, 995, 100, 100);
        shaper.setColor(lightGold);
        shaper.circle(105, 1025, 20);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.28f, 0.28f);
        font.draw(batcher, "1 unit", 65, 1060);
        batcher.end();

    }

    private void drawLineButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(210, 990, 110, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(215, 995, 100, 100);
        shaper.setColor(lightGold);
        shaper.rect(230, 1020, 70, 10);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.25f, 0.25f);
        font.draw(batcher, "3 units", 225, 1060);
        batcher.end();
    }

    private void drawEndCharButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(370, 990, 135, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(375, 995, 125, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.3f, 0.3f);
        font.draw(batcher, "Character" + '\n' + " Finish", 375, 1000);

        font.getData().setScale(0.25f, 0.25f);
        font.draw(batcher, "3 units" + '\n' + " pause", 390, 1055);
        batcher.end();
    }

    private void drawSpaceButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(530, 990, 135, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(535, 995, 125, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.3f, 0.3f);
        font.draw(batcher, "  White" + '\n' + "  Space", 535, 1000);

        font.getData().setScale(0.25f, 0.25f);
        font.draw(batcher, "7 units" + '\n' + " pause", 550, 1055);
        batcher.end();
    }

    private void drawDeleteSignButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(70, 1140, 165, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(75, 1145, 155, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.35f, 0.35f);
        font.draw(batcher, " Delete" + '\n' + "  last" + '\n' + "character", 80, 1160);
        batcher.end();

    }


    private void drawDeleteCharButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(270, 1140, 160, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(275, 1145, 150, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.35f, 0.35f);
        font.draw(batcher, " Delete" + '\n' + "  last" + '\n' + " letter", 280, 1160);
        batcher.end();

    }

    private void drawClearScreenButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(470, 1140, 160, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(475, 1145, 150, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.45f, 0.4f);
        font.draw(batcher, " Clear" + '\n' + " screen", 470, 1165);
        batcher.end();

    }

    //letter find

    private boolean bindLetter(int myPos) {
        boolean ok = false;
        System.out.println("BINDING BINDING BINDING BINDING");
        for (int i = 1; i <= 36; i++) {
            boolean letterFound = true;
            if (posSign == morseCode[i][0]) {
                for (int j = 1; j <= posSign; j++)
                    if (morseCode[i][j] != currentLetter[j])
                        letterFound = false;
            } else letterFound = false;

            if (letterFound) {
                currentText[myPos] = getChar(i);
                ok = true;
                break;
            }
        }
        return ok;
    }

    private char getChar(int i) {
        if (i <= 9)
            return (char) (i + '0');
        else if (i == 10) return '0';
        else if (i == 11) return 'Q';
        else if (i == 12) return 'W';
        else if (i == 13) return 'E';
        else if (i == 14) return 'R';
        else if (i == 15) return 'T';
        else if (i == 16) return 'Y';
        else if (i == 17) return 'U';
        else if (i == 18) return 'I';
        else if (i == 19) return 'O';
        else if (i == 20) return 'P';
        else if (i == 21) return 'A';
        else if (i == 22) return 'S';
        else if (i == 23) return 'D';
        else if (i == 24) return 'F';
        else if (i == 25) return 'G';
        else if (i == 26) return 'H';
        else if (i == 27) return 'J';
        else if (i == 28) return 'K';
        else if (i == 29) return 'L';
        else if (i == 30) return 'Z';
        else if (i == 31) return 'X';
        else if (i == 32) return 'C';
        else if (i == 33) return 'V';
        else if (i == 34) return 'B';
        else if (i == 35) return 'N';
        else if (i == 36) return 'M';
        else return ' ';
    }

}
