package com.ideaproj.sos.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.*;

public class ReceiverScreen {

    private final Color lightGold, veryDarkGrey;
    private double actualTime, speed, ratioX, ratioY, touchX, touchY,actualTime2;
    private boolean lighted, defaultSet, receivingLight, receivingShadow, waitFor7, setUpScreen, setUpReady, mainScreen,firstSetUp;
    private int posSign, posLetter,nextLetter;
    private Texture backgrounT, setUpBackgroundT;
    private TextureRegion background, setUpBackground;
    private float gameWidth, gameHeight, lux, defaultLight;
    private com.ideaproj.sos.screens.MainScreen screen;
    private com.ideaproj.sos.tools.DeviceControl deviceControl;
    private int[] currentLetter;
    private char[] currentText;
    private int[][] morseCode;
    private BitmapFont font;
    private double radius;


    public ReceiverScreen(com.ideaproj.sos.screens.MainScreen screen) {
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        this.ratioX = screen.screenWidth / (gameWidth * 2);
        this.ratioY = screen.screenHeight / (gameHeight * 2);
        this.screen = screen;
        this.deviceControl = screen.getDeviceControl();
        deviceControl.readySensor();
        initializeTextures();
        actualTime = 0;
        defaultSet = false;
        posSign = 0;
        posLetter = 1;
        speed = 1;
        currentLetter = new int[15];
        currentText = new char[999];
        initializeCode();
        lightGold = new Color(161 / 255f, 128 / 255f, 77 / 255f, 1);
        veryDarkGrey = new Color(10 / 255f, 10 / 255f, 20 / 255f, 1);
        waitFor7 = false;
        setUpScreen = true;
        mainScreen = false;
        setUpReady = false;
        firstSetUp = false;
        actualTime = 0;

    }

    private void initializeCode() {
        morseCode = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // -
                {9, 1, -1, 3, -1, 3, -1, 3, -1, 3},  // 1
                {9, 1, -1, 1, -1, 3, -1, 3, -1, 3},  // 2
                {9, 1, -1, 1, -1, 1, -1, 3, -1, 3},  // 3
                {9, 1, -1, 1, -1, 1, -1, 1, -1, 3},  // 4
                {9, 1, -1, 1, -1, 1, -1, 1, -1, 1},  // 5
                {9, 3, -1, 1, -1, 1, -1, 1, -1, 1},  // 6
                {9, 3, -1, 3, -1, 3, -1, 3, -1, 3},  // 7
                {9, 3, -1, 3, -1, 3, -1, 1, -1, 1},  // 8
                {9, 3, -1, 3, -1, 3, -1, 3, -1, 1},  // 9
                {9, 3, -1, 3, -1, 3, -1, 3, -1, 3},  // 0
                {7, 3, -1, 3, -1, 1, -1, 3}, // Q
                {5, 1, -1, 3, -1, 3}, // W
                {1, 1}, // E
                {5, 1, -1, 3, -1, 1}, // R
                {1, 3}, // T
                {7, 3, -1, 1, -1, 3, -1, 3}, // Y
                {5, 1, -1, 1, -1, 3}, // U
                {3, 1, -1, 1}, //I
                {5, 3, -1, 3, -1, 3}, //O
                {7, 1, -1, 3, -1, 3, -1, 1}, //P
                {3, 1, -1, 3}, //A
                {5, 1, -1, 1, -1, 1}, //S
                {5, 3, -1, 1, -1, 1}, //D
                {7, 1, -1, 1, -1, 3, -1, 1}, //F
                {5, 3, -1, 3, -1, 1}, // G
                {7, 1, -1, 1, -1, 1, -1, 1}, // H
                {7, 1, -1, 3, -1, 3, -1, 3}, // J
                {5, 3, -1, 1, -1, 3}, //K
                {7, 1, -1, 3, -1, 1, -1, 1}, //L
                {7, 3, -1, 3, -1, 1, -1, 1}, //Z
                {7, 3, -1, 1, -1, 1, -1, 3}, //X
                {7, 3, -1, 1, -1, 3, -1, 1}, //C
                {7, 1, -1, 1, -1, 1, -1, 3}, //V
                {7, 3, -1, 1, -1, 1, -1, 1}, //B
                {3, 3, -1, 1}, //N
                {3, 3, -1, 3}, //M
        };


    }

    private void initializeTextures() {
        backgrounT = new Texture(Gdx.files.internal("receiverBackground.jpg"));
        background = new TextureRegion(backgrounT);
        background.flip(false, true);

    }

    //update

    public void update(float delta) {
        //   System.out.println("Default: " + actualTime);
        //          System.out.println("Light: "+ radius);
        //      System.out.println("Shadow: "+receivingShadow);
        System.out.println("Current number" + posSign);
               System.out.println("Current sign: " + currentLetter[posSign]);
              System.out.println("Letter: " + posLetter);


        //valoare senzorului
        lux = deviceControl.getLight();

        //cronometrul
        actualTime += delta;

        //number generating animatino
        if(receivingShadow || receivingLight) {
            actualTime2 += delta;

            if (actualTime2 >= 0.03) {
                actualTime2 = 0;
                currentText[posLetter] = getChar(thecode.getRandom(1, 36));
                System.out.println("CHANGED!");
            }
        }
        else {actualTime2=0;}

        if (setUpScreen) {
            if (!setUpReady) {
                int x = Gdx.input.getX();
                int y = Gdx.input.getY();
                radius = Math.sqrt(((x / ratioX - 220) * (x / ratioX - 220) + (y / ratioY - 620) * (y / ratioY - 620)));

                if (Gdx.input.isTouched() && radius < 75) {
                    defaultLight += lux * delta;

                    if (actualTime > 4) {
                        defaultLight /= actualTime;
                        setUpReady = true;
                    }
                } else actualTime = 0;
            }

        } else {


            //first light
            if (!receivingShadow && !receivingLight && lux - defaultLight >= 1) {
                receivingLight = true;
                actualTime = 0;
            }

            //lightStopped - handle
            else if (receivingLight && lux - defaultLight < 1) {

                //point
                if (actualTime + 0.2 >= 3 / speed) {
                    if (posSign <= 13)
                        currentLetter[++posSign] = 3;
                }
                //line
                else if (actualTime + 0.2 >= 1 / speed) {
                    if (posSign <= 13)
                        currentLetter[++posSign] = 1;
                }
                receivingLight = false;
                receivingShadow = true;
                actualTime = 0;
            } else if (receivingShadow) {

                //word space
                if (actualTime + 0.2 >= 3 / speed) {

                    if (!waitFor7) {
                        if (bindLetter(posLetter))
                            posLetter++;
                        waitFor7 = true;
                    }

                    if (waitFor7 && actualTime + 0.2 >= 7 / speed) {
                        currentText[posLetter] = ' ';
                        posLetter++;
                        waitFor7 = false;
                        receivingLight = false;
                        receivingShadow = false;
                        currentLetter = new int[15];
                        posSign = 0;
                    }

                    if (lux - defaultLight >= 1) {
                        actualTime = 0;
                        receivingLight = false;
                        receivingShadow = false;
                        currentLetter = new int[15];
                        posSign = 0;
                        waitFor7=false;
                    }


                } else if (actualTime + 0.2 >= 1 / speed && lux - defaultLight >= 1) {
                    if (posSign <= 13)
                        currentLetter[++posSign] = -1;
                    receivingShadow = false;
                    receivingLight = true;
                    actualTime = 0;
                }
            }
        }
    }

    //touch

    public void touch(float screenX, float screenY, int pointer, int button) {

        touchX = screenX / ratioX;
        touchY = screenY / ratioY;

        if (setUpReady && setUpScreen) {
            setUpScreen = false;
            mainScreen = true;
            firstSetUp = true;
        } else if (!setUpReady && setUpScreen)
            if (touchX >= 320 && touchX <= 660 && touchY >= 550 && touchY <= 690) {
                defaultLight = deviceControl.getLight();
                actualTime = 0;
                setUpReady = true;
                setUpScreen = false;
                mainScreen = true;
                firstSetUp= true;
            }
        if (mainScreen) {
            //clear screen button
            if (touchX > 460 && touchX < 670 && touchY > 920 && touchY < 1030) {
                currentText = new char[999];
                posLetter = 1;
            }
            //speed change buttons
            if (touchX > 330 && touchX < 410 && touchY > 1115 && touchY < 1195)
                if (speed >= 1)
                    speed -= 0.5;
            if (touchX > 620 && touchX < 700 && touchY > 1115 && touchY < 1195)
                if (speed <= 2.5)
                    speed += 0.5;
            if(touchX > 70 && touchX <280  && touchY >920 && touchY < 1030)
            {
                actualTime=0;
                mainScreen=false;
                setUpScreen=true;
                setUpReady=false;
            }
        }

    }

    public void keyBack()
    {
        if(mainScreen || (setUpScreen && !firstSetUp)) {
            screen.setReceiveMenu(null);
            thecode.gameStatus = thecode.stats.Menu;
        }
        if(setUpScreen && firstSetUp)
        {
            mainScreen=true;
            setUpScreen=false;
            setUpReady=true;
        }

    }

    //render

    public void render(com.ideaproj.sos.tools.GameRenderer renderer) {
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        font = screen.getGameRenderer().morse;

        batcher.begin();
        batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.end();

        if (mainScreen) {

            renderTextScreen(batcher,shaper);
            renderClearScreenButton(batcher, shaper);
            renderSpeedButton(batcher, shaper);
            renderReSetUpButton(batcher,shaper);
        }
        //SET-UP screen STUFF
        else if (setUpScreen)
            renderSetUpScreen(batcher,shaper);
    }

    //sub-render methods

    private void renderSetUpScreen(SpriteBatch batcher,ShapeRenderer shaper){

        Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        shaper.setAutoShapeType(false);
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(0, 0, 0, 0.7f);
        shaper.rect(0, 0, gameWidth * 2, gameHeight * 2);
        shaper.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
        shaper.setAutoShapeType(true);

        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(40, 320, 640, 450);
        shaper.setColor(veryDarkGrey);
        shaper.rect(50, 330, 620, 430);
        shaper.end();

        batcher.begin();
        font.setColor(Color.WHITE);
        font.getData().setScale(0.5f, 0.5f);
        font.draw(batcher, "Hold your finger", 170, 350);
        font.draw(batcher, "to set up the sensor!", 120, 390);
        batcher.end();

        //NOT READY
        if (!setUpReady) {
            shaper.begin();
            shaper.set(ShapeRenderer.ShapeType.Filled);
            shaper.setColor(Color.BLACK);
            shaper.circle(220, 620, 85);
            shaper.setColor(Color.DARK_GRAY);
            shaper.circle(220, 620, 75);

            shaper.rect(140, 470, 450, 50);
            shaper.setColor(lightGold);
            shaper.rect(145, 475, (float) (440 * actualTime / 4), 40);
            shaper.end();

            batcher.begin();
            //   font.getData().setScale(0.45f,0.45f);
            font.draw(batcher, String.valueOf((int) (actualTime / 4 * 100)) + "%", 350, 480);
            batcher.end();

            batcher.begin();
            font.draw(batcher, "Skip", 440, 570);
            font.getData().setScale(0.4f, 0.4f);
            font.draw(batcher, "(Not Recommended!)", 330, 620);
            batcher.end();

            shaper.begin(ShapeRenderer.ShapeType.Line);
            shaper.rect(320, 550, 340, 140);
            shaper.end();
        }
        //READY
        else if (setUpReady) {
            batcher.begin();
            //   font.getData().setScale(0.45f,0.45f);
            font.draw(batcher, "READY!", 310, 480);
            batcher.end();
        }

    }

    private void renderSpeedButton(SpriteBatch batcher, ShapeRenderer shaper) {

        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(410, 1100, 210, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(415, 1105, 200, 100);

        if (speed < 0.5)
            shaper.setColor(Color.LIGHT_GRAY);
        else shaper.setColor(lightGold);
        shaper.rect(330, 1115, 80, 80);
        shaper.setColor(Color.BLACK);
        shaper.rect(335, 1120, 70, 70);

        if (speed > 3)
            shaper.setColor(Color.LIGHT_GRAY);
        else shaper.setColor(lightGold);
        shaper.rect(620, 1115, 80, 80);
        shaper.setColor(Color.BLACK);
        shaper.rect(625, 1120, 70, 70);
        shaper.end();

        batcher.begin();
        font.getData().setScale(1f, 1f);
        if (speed == 0.5)
            font.setColor(Color.LIGHT_GRAY);
        else font.setColor(lightGold);
        font.draw(batcher, "-", 345, 1130);
        if (speed == 3)
            font.setColor(Color.LIGHT_GRAY);
        else font.setColor(lightGold);
        font.draw(batcher, "+", 640, 1130);

        font.getData().setScale(0.6f, 0.6f);
        font.setColor(lightGold);
        font.draw(batcher, "Speed", 440, 1120);
        if (speed == 1)
            font.setColor(lightGold);
        else font.setColor(230 / 255f, 95 / 255f, 28 / 255f, 1);
        font.getData().setScale(0.5f, 0.5f);
        font.draw(batcher, "X" + (float) speed, 460, 1165);
        batcher.end();

        if(speed!=1)
        {
            shaper.setColor(230 / 255f, 95 / 255f, 28 / 255f, 1);
            shaper.begin(ShapeRenderer.ShapeType.Line);
            shaper.rect(5,1120,310,75);
            shaper.end();

            batcher.begin();
            font.getData().setScale(0.25f,0.25f);
            font.draw(batcher,"We strongly reccomend you"+'\n'+"to use x1 speed unless "+'\n'+"you know the transmitter's "+'\n' +"exact speed",10,1125);
            batcher.end();


        }


    }

    private void renderClearScreenButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(410, 920, 210, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(415, 925, 200, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.6f, 0.6f);
        font.draw(batcher, "Clear" + '\n' + "Screen", 430, 935);
        batcher.end();
    }

    private  void renderTextScreen(SpriteBatch batcher, ShapeRenderer shaper) {
        //mini-screen for text
        shaper.begin();
        shaper.setColor(lightGold);
        shaper.set(ShapeRenderer.ShapeType.Filled);

        shaper.rect(30, 240, gameWidth * 2 - 2 * 30, 650);
        shaper.setColor(Color.BLACK);
        shaper.rect(30 + 10, 240 + 10, gameWidth * 2 - 2 * (30 + 10), 650 - 2 * 10);
        shaper.end();

        //text
        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(1f, 1f);
        for (int i = 1; i <= posLetter; i++)
                     font.draw(batcher, String.valueOf(currentText[i]), 60 + (i%13!=0 ? i % 13 - 1:13-1) * 50, 260 + ((i / 13)) * 60);
        if(receivingLight || receivingShadow) {
            nextLetter = posLetter ;
            font.draw(batcher, String.valueOf(currentText[posLetter]), 60 + (posLetter%13!=0 ? posLetter % 13 - 1:13-1) * 50, 260 + ((posLetter / 13)) * 60);
            System.out.println("XX");
        }
        batcher.end();
    }

    private void renderReSetUpButton(SpriteBatch batcher,ShapeRenderer shaper){

        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(70, 920, 210, 110);
        shaper.setColor(Color.BLACK);
        shaper.rect(75, 925, 200, 100);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.6f, 0.6f);
        font.draw(batcher, "Reset" + '\n' + "Set-Up", 90, 935);
        batcher.end();
    }

    //others

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
