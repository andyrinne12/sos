package com.ideaproj.sos.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.ideaproj.sos.tools.DeviceControl;
import com.ideaproj.sos.tools.GameRenderer;

public class KeyScreen {

    private final Color lightGold = new Color(161 / 255f, 128 / 255f, 77 / 255f, 1);
    private Input.TextInputListener messageBox;
    private boolean vibrationEnabled, lightEnabled, soundEnabled;
    private boolean keyboardFocus, messageFocus, characterSent, characterSendStarted;
    private BitmapFont font;
    private MainScreen screen;
    private float gameWidth, gameHeight;
    private Texture backgrounT;
    private TextureRegion background;
    private float watch, cont;
    private char ch = ' ';
    private DeviceControl deviceControl;
    private float speed;
    private int coords[][];
    private char[] messageText;
    private int textLength;
    private final int maxLength = 31 * 6;
    private int currentLetter, messageLength;

    public KeyScreen(MainScreen screen) {
        this.screen = screen;
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        this.screen = screen;
        this.font = screen.getGameRenderer().morse;

        initializeTextures();
        initializeCoords();

        this.watch = 0;
        this.speed = 1;
        this.vibrationEnabled = false;
        this.lightEnabled = true;
        this.soundEnabled = false;
        this.keyboardFocus = true;
        this.messageFocus = false;
        messageText = new char[maxLength];

        this.deviceControl = screen.getDeviceControl();
        //  if(deviceControl.isCamera())
        deviceControl.getCamera();
        deviceControl.readyAltitudeSensor();

        messageBox = new Input.TextInputListener() {
            @Override
            public void input(String text) {
                char[] tempText;
                tempText = text.toCharArray();

                int beg = -1, end = -1;

                for (int i = 0; i <= tempText.length - 1; i++) {
                    int z = tempText[i];
                    if (z >= 97 && z <= 122)
                        tempText[i] -= 32;
                }
                text = String.copyValueOf(tempText);

                for (int i = 0; i <= tempText.length - 1; i++) {
                    int z = tempText[i];
                    if ((z >= 48 && z <= 57) || (z >= 65 && z <= 90) || z == 32) {
                        if (beg == -1)
                            beg = i;
                        end = i;
                    }
                }
                if (beg == -1) beg = 0;
                if (end == -1) end = 0;

                String newText = text.substring(beg, end + 1);
                messageText = newText.toCharArray();

                int length = messageText.length;

                for (int i = 0; i <= length - 1; i++) {
                    int z = messageText[i];
                    if (!((z >= 48 && z <= 57) || (z >= 65 && z <= 90)))
                        messageText[i] = ' ';
                }

                for (int i = 0; i <= length - 1; i++) {
                    int z = messageText[i];
                    if (i <= length - 2 && z == messageText[i + 1] && z == ' ') {
                        for (int j = i; j <= length - 2; j++)
                            messageText[j] = messageText[j + 1];
                        i--;
                        length--;
                    }
                }

                System.out.println(messageText);

            }

            @Override
            public void canceled() {

            }
        };
    }

    //initializations

    private void initializeCoords() {

        coords = new int[37][3];

        coords[1][1] = 640;
        coords[1][2] = 390;

        coords[2][1] = 20;
        coords[2][2] = 390;

        coords[3][1] = 88;
        coords[3][2] = 390;

        coords[4][1] = 160;
        coords[4][2] = 390;

        coords[5][1] = 230;
        coords[5][2] = 390;

        coords[6][1] = 305;
        coords[6][2] = 390;

        coords[7][1] = 375;
        coords[7][2] = 390;

        coords[8][1] = 445;
        coords[8][2] = 390;

        coords[9][1] = 510;
        coords[9][2] = 390;

        coords[10][1] = 580;
        coords[10][2] = 390;


        //

        coords[11][1] = 20;
        coords[11][2] = 455;

        coords[12][1] = 88;
        coords[12][2] = 455;

        coords[13][1] = 160;
        coords[13][2] = 455;

        coords[14][1] = 230;
        coords[14][2] = 455;

        coords[15][1] = 305;
        coords[15][2] = 455;

        coords[16][1] = 375;
        coords[16][2] = 455;

        coords[17][1] = 445;
        coords[17][2] = 455;

        coords[18][1] = 510;
        coords[18][2] = 455;

        coords[19][1] = 580;
        coords[19][2] = 455;

        coords[20][1] = 640;
        coords[20][2] = 455;

        //rand 2

        coords[21][1] = 50;
        coords[21][2] = 520;

        coords[22][1] = 120;
        coords[22][2] = 520;

        coords[23][1] = 190;
        coords[23][2] = 520;

        coords[24][1] = 260;
        coords[24][2] = 520;

        coords[25][1] = 335;
        coords[25][2] = 520;

        coords[26][1] = 405;
        coords[26][2] = 520;

        coords[27][1] = 475;
        coords[27][2] = 520;

        coords[28][1] = 540;
        coords[28][2] = 520;

        coords[29][1] = 610;
        coords[29][2] = 520;

        //rand 3

        coords[30][1] = 120;
        coords[30][2] = 588;

        coords[31][1] = 188;
        coords[31][2] = 588;

        coords[32][1] = 258;
        coords[32][2] = 588;

        coords[33][1] = 330;
        coords[33][2] = 588;

        coords[34][1] = 405;
        coords[34][2] = 588;

        coords[35][1] = 475;
        coords[35][2] = 588;

        coords[36][1] = 545;
        coords[36][2] = 588;


    }

    private void initializeTextures() {

        backgrounT = new Texture(Gdx.files.internal("keyBackground.jpg"));
        background = new TextureRegion(backgrounT);
        background.flip(false, true);


    }

    //render

    public void render(GameRenderer renderer) {
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        //se deseneaza fundalul

        BitmapFont morse = renderer.morse;
        morse.getData().setScale(1.5f, 1.5f);
        batcher.end();

        renderTextScreen(batcher, shaper);
        renderEnableLightButton(batcher, shaper);
        renderEnableSoundButton(batcher, shaper);
        renderEnableVibrationButton(batcher, shaper);
        renderEditTextButton(batcher, shaper);
        renderStartTransmittButton(batcher, shaper);
        renderAddAltitudeButton(batcher,shaper);
    }//aici desenezi butoanele? aici desenez tot da

    private void renderTextScreen(SpriteBatch batcher, ShapeRenderer shaper) {
        //mini-screen for text
        shaper.begin();
        shaper.setColor(lightGold);
        shaper.set(ShapeRenderer.ShapeType.Filled);

        shaper.rect(30, 680, gameWidth * 2 - 2 * 30, 240);
        shaper.setColor(Color.BLACK);
        shaper.rect(30 + 10, 680 + 10, gameWidth * 2 - 2 * (30 + 10), 240 - 2 * 10);
        shaper.end();

        //text

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.5f, 0.5f);
        for (int i = 0; i <= Math.min(maxLength - 1, messageText.length - 1); i++) {
            if (i > currentLetter)
                font.setColor(Color.LIGHT_GRAY);
            else
                font.setColor(lightGold);
            font.draw(batcher, String.valueOf(messageText[i]), 50 + i % 31 * 20, 700 + ((i / 31)) * 35);
        }
            batcher.end();
    }//..ecranul e 720 latime pe 1280 i daca acum e 490 si pana jos e 1280 iti dai seama ca 10 unitati e nesemnificativ

    private void renderEnableLightButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(Color.BLACK);
        shaper.circle(320, 1180, 65);
        if (!lightEnabled)
            shaper.setColor(Color.LIGHT_GRAY);
        else
            shaper.setColor(lightGold);
        shaper.circle(320, 1180, 60);
        shaper.end();

        batcher.begin();
        font.setColor(Color.BLACK);
        font.getData().setScale(0.5f, 0.5f);
        font.draw(batcher, "Light", 265, 1165);
        batcher.end();
    }

    private void renderEnableSoundButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(Color.BLACK);
        shaper.circle(470, 1180, 65);
        if (!soundEnabled)
            shaper.setColor(Color.LIGHT_GRAY);
        else
            shaper.setColor(lightGold);
        shaper.circle(470, 1180, 60);
        shaper.end();

        batcher.begin();
        font.setColor(Color.BLACK);
        font.getData().setScale(0.45f, 0.45f);
        font.draw(batcher, "Sound", 415, 1165);
        batcher.end();
    }

    private void renderEnableVibrationButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(Color.BLACK);
        shaper.circle(620, 1180, 65);
        if (!vibrationEnabled)
            shaper.setColor(Color.LIGHT_GRAY);
        else
            shaper.setColor(lightGold);
        shaper.circle(620, 1180, 60);
        shaper.end();

        batcher.begin();
        font.setColor(Color.BLACK);
        font.getData().setScale(0.35f, 0.35f);
        font.draw(batcher, "Vibrate", 565, 1165);
        batcher.end();
    }

    private void renderEditTextButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(320, 960, 150, 100);
        shaper.setColor(Color.BLACK);
        shaper.rect(320 + 5, 960 + 5, 140, 90);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.draw(batcher, " Edit" + '\n' + "Message", 335, 985);
        batcher.end();

    }

    private void renderStartTransmittButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(500, 960, 190, 100);
        shaper.setColor(Color.BLACK);
        shaper.rect(500 + 5, 960 + 5, 180, 90);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.3f, 0.3f);
        font.draw(batcher, "   Start" + '\n' + "Transmission", 510, 985);
        batcher.end();

    }

    private void renderAddAltitudeButton(SpriteBatch batcher, ShapeRenderer shaper) {
        shaper.begin(ShapeRenderer.ShapeType.Filled);
        shaper.setColor(lightGold);
        shaper.rect(60, 960, 170, 100);
        shaper.setColor(Color.BLACK);
        shaper.rect(60 + 5, 960 + 5, 160, 90);
        shaper.end();

        batcher.begin();
        font.setColor(lightGold);
        font.getData().setScale(0.4f,0.4f);
        font.draw(batcher, " Add" + '\n' + "Altitude", 70, 985);
        batcher.end();

    }

    //touch

    public void touch(float screenX, float screenY, int pointer, int button) {
        float ratioX = screen.screenWidth / (gameWidth * 2);
        float ratioY = screen.screenHeight / (gameHeight * 2);
        int touchX = (int) (screenX / ratioX);
        int touchY = (int) (screenY / ratioY);

        // se detecteaza ce buton a fost apasat si se incepe afisarea

        verifyLetters(' ', screenX, screenY, ratioX, ratioY);


        double rad1 = Math.sqrt((touchX - 320) * (touchX - 320) + (touchY - 1180) * (touchY - 1180));
        double rad2 = Math.sqrt((touchX - 470) * (touchX - 470) + (touchY - 1180) * (touchY - 1180));
        double rad3 = Math.sqrt((touchX - 620) * (touchX - 620) + (touchY - 1180) * (touchY - 1180));

        if (rad1 <= 65) {
            if (lightEnabled) {
                lightEnabled = false;
                deviceControl.turnOffFlash();
            }
            else lightEnabled = true;
        } else if (rad2 <= 65) {
            if (soundEnabled)
                soundEnabled = false;
            else soundEnabled = true;
        } else if (rad3 <= 65) {
            if (vibrationEnabled) {
                vibrationEnabled = false;
                Gdx.input.cancelVibrate();
            }
            else vibrationEnabled = true;
        } else if (touchX >= 320 && touchX <= 470 && touchY >= 960 && touchY <= 1060)
            Gdx.input.getTextInput(messageBox, "Enter your message here:", String.copyValueOf(messageText), null);
        else if (touchX >= 500 && touchX <= 690 && touchY >= 960 && touchY <= 1060) {
            if (!messageFocus) {
                messageFocus = true;
                keyboardFocus = false;
                characterSendStarted = false;
                characterSent = false;
                watch = 0;
                currentLetter = 0;
            } else {
                messageFocus = false;
                keyboardFocus = true;
                ch='\0';
            }
        }
        else if(touchX >=60 && touchX <=230 && touchY >=960 && touchY <=1060){
         float height = deviceControl.getHeight();
            String tempText = String.copyValueOf(messageText);
            tempText = tempText + String.valueOf(height);
            messageText = tempText.toCharArray();
        }
    }

    // ciclul principal infinit

    public void update(float delta) {

        System.out.println("Keyboard: " + keyboardFocus);
        System.out.println("Message: " + messageFocus);
        System.out.println("Character: " + ch);
        System.out.println("Sent:" + characterSent);
        System.out.println("Started sending: " + characterSendStarted);
        System.out.println("Time: " + watch);


        //se actualizeaza cronometrul
        watch += delta;
        if (watch > 100) watch = 0;


        if (keyboardFocus) {
            // / daca nu este apasat nimic se opresc vibratia si lumina
            if (ch == ' ') {
                cont = 0;
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
            }
            // pentru fiecare litera se contorizeaza timpul de la ultima aprindere/stingere ptr simularea semnalelor luminoase
            else if (ch == 'Q') handleQ();
            else if (ch == 'W') handleW();
            else if (ch == 'E') handleE();
            else if (ch == 'R') handleR();
            else if (ch == 'T') handleT();
            else if (ch == 'Y') handleY();
            else if (ch == 'U') handleU();
            else if (ch == 'I') handleI();
            else if (ch == 'O') handleO();
            else if (ch == 'P') handleP();
            else if (ch == 'A') handleA();
            else if (ch == 'S') handleS();
            else if (ch == 'D') handleD();
            else if (ch == 'F') handleF();
            else if (ch == 'G') handleG();
            else if (ch == 'H') handleH();
            else if (ch == 'J') handleJ();
            else if (ch == 'K') handleK();
            else if (ch == 'L') handleL();
            else if (ch == 'Z') handleZ();
            else if (ch == 'X') handleX();
            else if (ch == 'C') handleC();
            else if (ch == 'V') handleV();
            else if (ch == 'B') handleB();
            else if (ch == 'N') handleN();
            else if (ch == 'M') handleM();
            else if (ch == '1') handle1();
            else if (ch == '2') handle2();
            else if (ch == '3') handle3();
            else if (ch == '4') handle4();
            else if (ch == '5') handle5();
            else if (ch == '6') handle6();
            else if (ch == '7') handle7();
            else if (ch == '8') handle8();
            else if (ch == '9') handle9();
            else if (ch == '0') handle0();

            // aceste instructiuni se vor executa la infinit cat timp este deschis ecranul cu tastatura
        } else if (messageFocus) {

            if (!characterSent) {

                if (!characterSendStarted) {
                    ch = messageText[currentLetter];
                    if (ch == ' ')
                        watch = 0;
                    else verifyLetters(ch, 0, 0, 0, 0);
                    characterSendStarted = true;
                } else {
                    if (ch == ' ') {
                        if (watch >= 7 / speed) {
                            characterSent = true;
                            watch = 0;
                        }
                    } else
                        handleLetters(ch);
                }

            } else {
                if (currentLetter == messageText.length - 1) {
                    currentLetter = 0;
                    characterSendStarted = false;
                    characterSent = false;
                    messageFocus = false;
                    keyboardFocus = true;
                } else {
                    if (messageText[currentLetter+1] != ' ' &&  messageText[currentLetter] !=' ') {
                        if (watch >= 3 / speed) {
                            deviceControl.turnOffFlash();
                            characterSendStarted = false;
                            characterSent = false;
                            currentLetter++;
                            watch = 0;
                        }
                    } else {
                        deviceControl.turnOffFlash();
                        characterSendStarted = false;
                        characterSent = false;
                        currentLetter++;
                        watch = 0;
                    }
                }
            }

        }

    }

    //verifies & handle

    private void verifyLetters(char a, float screenX, float screenY, float ratioX, float ratioY) {
        if (messageFocus) {
            if (a == '0') verify0(screenX, screenY, ratioX, ratioY);
            if (a == '1') verify1(screenX, screenY, ratioX, ratioY);
            if (a == '2') verify2(screenX, screenY, ratioX, ratioY);
            if (a == '3') verify3(screenX, screenY, ratioX, ratioY);
            if (a == '4') verify4(screenX, screenY, ratioX, ratioY);
            if (a == '5') verify5(screenX, screenY, ratioX, ratioY);
            if (a == '6') verify6(screenX, screenY, ratioX, ratioY);
            if (a == '7') verify7(screenX, screenY, ratioX, ratioY);
            if (a == '8') verify8(screenX, screenY, ratioX, ratioY);
            if (a == '9') verify9(screenX, screenY, ratioX, ratioY);
            if (a == 'Q') verifyQ(screenX, screenY, ratioX, ratioY);
            if (a == 'W') verifyW(screenX, screenY, ratioX, ratioY);
            if (a == 'E') verifyE(screenX, screenY, ratioX, ratioY);
            if (a == 'R') verifyR(screenX, screenY, ratioX, ratioY);
            if (a == 'T') verifyT(screenX, screenY, ratioX, ratioY);
            if (a == 'Y') verifyY(screenX, screenY, ratioX, ratioY);
            if (a == 'U') verifyU(screenX, screenY, ratioX, ratioY);
            if (a == 'I') verifyI(screenX, screenY, ratioX, ratioY);
            if (a == 'O') verifyO(screenX, screenY, ratioX, ratioY);
            if (a == 'P') verifyP(screenX, screenY, ratioX, ratioY);
            if (a == 'A') verifyA(screenX, screenY, ratioX, ratioY);
            if (a == 'S') verifyS(screenX, screenY, ratioX, ratioY);
            if (a == 'D') verifyD(screenX, screenY, ratioX, ratioY);
            if (a == 'F') verifyF(screenX, screenY, ratioX, ratioY);
            if (a == 'G') verifyG(screenX, screenY, ratioX, ratioY);
            if (a == 'H') verifyH(screenX, screenY, ratioX, ratioY);
            if (a == 'J') verifyJ(screenX, screenY, ratioX, ratioY);
            if (a == 'K') verifyK(screenX, screenY, ratioX, ratioY);
            if (a == 'L') verifyL(screenX, screenY, ratioX, ratioY);
            if (a == 'Z') verifyZ(screenX, screenY, ratioX, ratioY);
            if (a == 'X') verifyX(screenX, screenY, ratioX, ratioY);
            if (a == 'C') verifyC(screenX, screenY, ratioX, ratioY);
            if (a == 'V') verifyV(screenX, screenY, ratioX, ratioY);
            if (a == 'B') verifyB(screenX, screenY, ratioX, ratioY);
            if (a == 'N') verifyN(screenX, screenY, ratioX, ratioY);
            if (a == 'M') verifyM(screenX, screenY, ratioX, ratioY);
        } else if (keyboardFocus) {
            verify0(screenX, screenY, ratioX, ratioY);
            verify1(screenX, screenY, ratioX, ratioY);
            verify2(screenX, screenY, ratioX, ratioY);
            verify3(screenX, screenY, ratioX, ratioY);
            verify4(screenX, screenY, ratioX, ratioY);
            verify5(screenX, screenY, ratioX, ratioY);
            verify6(screenX, screenY, ratioX, ratioY);
            verify7(screenX, screenY, ratioX, ratioY);
            verify8(screenX, screenY, ratioX, ratioY);
            verify9(screenX, screenY, ratioX, ratioY);
            verifyQ(screenX, screenY, ratioX, ratioY);
            verifyW(screenX, screenY, ratioX, ratioY);
            verifyE(screenX, screenY, ratioX, ratioY);
            verifyR(screenX, screenY, ratioX, ratioY);
            verifyT(screenX, screenY, ratioX, ratioY);
            verifyY(screenX, screenY, ratioX, ratioY);
            verifyU(screenX, screenY, ratioX, ratioY);
            verifyI(screenX, screenY, ratioX, ratioY);
            verifyO(screenX, screenY, ratioX, ratioY);
            verifyP(screenX, screenY, ratioX, ratioY);
            verifyA(screenX, screenY, ratioX, ratioY);
            verifyS(screenX, screenY, ratioX, ratioY);
            verifyD(screenX, screenY, ratioX, ratioY);
            verifyF(screenX, screenY, ratioX, ratioY);
            verifyG(screenX, screenY, ratioX, ratioY);
            verifyH(screenX, screenY, ratioX, ratioY);
            verifyJ(screenX, screenY, ratioX, ratioY);
            verifyK(screenX, screenY, ratioX, ratioY);
            verifyL(screenX, screenY, ratioX, ratioY);
            verifyZ(screenX, screenY, ratioX, ratioY);
            verifyX(screenX, screenY, ratioX, ratioY);
            verifyC(screenX, screenY, ratioX, ratioY);
            verifyV(screenX, screenY, ratioX, ratioY);
            verifyB(screenX, screenY, ratioX, ratioY);
            verifyN(screenX, screenY, ratioX, ratioY);
            verifyM(screenX, screenY, ratioX, ratioY);
        }
    }

    private void handleLetters(char ch) {
        if (ch == 'Q') handleQ();
        else if (ch == 'W') handleW();
        else if (ch == 'E') handleE();
        else if (ch == 'R') handleR();
        else if (ch == 'T') handleT();
        else if (ch == 'Y') handleY();
        else if (ch == 'U') handleU();
        else if (ch == 'I') handleI();
        else if (ch == 'O') handleO();
        else if (ch == 'P') handleP();
        else if (ch == 'A') handleA();
        else if (ch == 'S') handleS();
        else if (ch == 'D') handleD();
        else if (ch == 'F') handleF();
        else if (ch == 'G') handleG();
        else if (ch == 'H') handleH();
        else if (ch == 'J') handleJ();
        else if (ch == 'K') handleK();
        else if (ch == 'L') handleL();
        else if (ch == 'Z') handleZ();
        else if (ch == 'X') handleX();
        else if (ch == 'C') handleC();
        else if (ch == 'V') handleV();
        else if (ch == 'B') handleB();
        else if (ch == 'N') handleN();
        else if (ch == 'M') handleM();
        else if (ch == '1') handle1();
        else if (ch == '2') handle2();
        else if (ch == '3') handle3();
        else if (ch == '4') handle4();
        else if (ch == '5') handle5();
        else if (ch == '6') handle6();
        else if (ch == '7') handle7();
        else if (ch == '8') handle8();
        else if (ch == '9') handle9();
        else if (ch == '0') handle0();
    }

    //all verifies etc.

    private void verifyQ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[11][1];
        int x2 = x + 60;
        int y = coords[11][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'Q' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'Q';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleQ() {

        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verifyW(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[12][1];
        int x2 = x + 60;
        int y = coords[12][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'W' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'W';
                watch = 0;
                cont = 0;

                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleW() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyE(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[13][1];
        int x2 = x + 60;
        int y = coords[13][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'E' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'E';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleE() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyR(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[14][1];
        int x2 = x + 60;
        int y = coords[14][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'R' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'R';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleR() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyT(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[15][1];
        int x2 = x + 60;
        int y = coords[15][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'T' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'T';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleT() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyY(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[16][1];
        int x2 = x + 60;
        int y = coords[16][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'Y' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'Y';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleY() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verifyU(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[17][1];
        int x2 = x + 60;
        int y = coords[17][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'U' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'U';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleU() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verifyI(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[18][1];
        int x2 = x + 60;
        int y = coords[18][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'I' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'I';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleI() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verifyO(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[19][1];
        int x2 = x + 60;
        int y = coords[19][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'O' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'O';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleO() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verifyP(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[20][1];
        int x2 = x + 60;
        int y = coords[20][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'P' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'P';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleP() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyA(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[21][1];
        int x2 = x + 60;
        int y = coords[21][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'A' && keyboardFocus)
                ch = ' ';
                // daca cand apesi butonul si este deja apasat...se anuleaza
            else {
                ch = 'A';
                watch = 0;
                cont = 0;
                // initializeaza cronometrul si contorul
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                // incepe primul semnal luminos
                //1000 = 1 secunda = punct
            }
        }
    }

    private void handleA() {
        // variabila cont se va actualiza cu 1 de fiecare daca cand se va trece la alta etapa
        // cont 0 - cand se termina punctul ( primul element se incepe in verify()
        //cont 1 = cand incepe urmatorul ( linia)
        //cont 2 - cand se termina linia
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (lightEnabled) deviceControl.turnOffFlash();
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyS(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[22][1];
        int x2 = x + 60;
        int y = coords[22][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'S' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'S';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleS() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyD(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[23][1];
        int x2 = x + 60;
        int y = coords[23][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'D' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'D';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleD() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 4;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyF(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[24][1];
        int x2 = x + 60;
        int y = coords[24][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'F' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'F';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleF() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyG(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[25][1];
        int x2 = x + 60;
        int y = coords[25][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'G' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'G';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleG() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyH(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[26][1];
        int x2 = x + 60;
        int y = coords[26][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'H' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleH() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyJ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[27][1];
        int x2 = x + 60;
        int y = coords[27][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'H' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleJ() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyK(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[28][1];
        int x2 = x + 60;
        int y = coords[28][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'K' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'K';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleK() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyL(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[29][1];
        int x2 = x + 60;
        int y = coords[29][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'L' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'L';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleL() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyZ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[30][1];
        int x2 = x + 60;
        int y = coords[30][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'Z' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'Z';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleZ() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyX(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[31][1];
        int x2 = x + 60;
        int y = coords[31][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'X' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'X';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleX() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyC(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[32][1];
        int x2 = x + 60;
        int y = coords[32][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'C' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'C';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleC() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyV(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[33][1];
        int x2 = x + 60;
        int y = coords[33][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'V' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'V';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleV() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyB(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[34][1];
        int x2 = x + 60;
        int y = coords[34][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'B' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'B';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleB() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyN(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[35][1];
        int x2 = x + 60;
        int y = coords[35][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'N' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'N';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleN() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    private void verifyM(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[36][1];
        int x2 = x + 60;
        int y = coords[36][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == 'M' && keyboardFocus)
                ch = ' ';
            else {
                ch = 'M';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleM() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }
    }

    //

    private void verify0(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[1][1];
        int x2 = x + 60;
        int y = coords[1][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '0' && keyboardFocus)
                ch = ' ';
            else {
                ch = '0';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle0() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify1(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[2][1];
        int x2 = x + 60;
        int y = coords[2][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '1' && keyboardFocus)
                ch = ' ';
            else {
                ch = '1';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle1() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify2(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[3][1];
        int x2 = x + 60;
        int y = coords[3][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '2' && keyboardFocus)
                ch = ' ';
            else {
                ch = '2';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle2() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify3(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[4][1];
        int x2 = x + 60;
        int y = coords[4][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '3' && keyboardFocus)
                ch = ' ';
            else {
                ch = '3';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle3() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify4(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[5][1];
        int x2 = x + 60;
        int y = coords[5][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '4' && keyboardFocus)
                ch = ' ';
            else {
                ch = '4';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle4() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify5(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[6][1];
        int x2 = x + 60;
        int y = coords[6][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '5' && keyboardFocus)
                ch = ' ';
            else {
                ch = '5';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle5() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 1 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify6(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[7][1];
        int x2 = x + 60;
        int y = coords[7][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '6' && keyboardFocus)
                ch = ' ';
            else {
                ch = '6';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle6() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 1 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify7(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[8][1];
        int x2 = x + 60;
        int y = coords[8][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '7' && keyboardFocus)
                ch = ' ';
            else {
                ch = '7';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle7() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 1 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify8(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[9][1];
        int x2 = x + 60;
        int y = coords[9][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '8' && keyboardFocus)
                ch = ' ';
            else {
                ch = '8';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle8() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 1 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

    private void verify9(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[10][1];
        int x2 = x + 60;
        int y = coords[10][2];
        int y2 = y + 60;

        if (messageFocus || (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY)) {
            if (ch == '9' && keyboardFocus)
                ch = ' ';
            else {
                ch = '9';
                watch = 0;
                cont = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.cancelVibrate();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle9() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                if (lightEnabled) deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 7) {
            if (watch >= 1 / speed) {
                watch = 0;
                if (lightEnabled) deviceControl.turnOnFlash();
                if (vibrationEnabled) Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 8) {
            if (watch >= 1 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                if (messageFocus) characterSent = true;
            }
        }


    }

}