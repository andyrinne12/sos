package com.ideaproj.sos.com.ideaproj.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.DeviceControl;

public class KeyScreen {

    private MainScreen screen;
    private float gameWidth, gameHeight;
    private Texture backgrounT;
    private TextureRegion background;
    private float watch, cont;
    private char ch = ' ';
    private DeviceControl deviceControl;
    private float speed = 2;
    private int coords[][];

    public KeyScreen( MainScreen screen) {
        this.gameWidth = screen.getGameWidth();
        this.gameHeight = screen.getGameHeight();
        this.screen = screen;
        initializeTextures();
        initializeCoords();
        this.watch = 0;
        this.deviceControl = screen.getDeviceControl();
        deviceControl.getCamera();


    }

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

    public void render(GameRenderer renderer) {
        SpriteBatch batcher = renderer.getBatcher();
        ShapeRenderer shaper = renderer.getShapeRenderer();

        batcher.begin();
        batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        batcher.end();
        //se deseneaza fundalul


        BitmapFont morse = renderer.felix;
        morse.getData().setScale(1.5f, 1.5f);

    //    for (int i = 1; i <= coords.length - 1; i++)
    //        shaper.rect(coords[i][1], coords[i][2], 60, 60);


        // se afiseaza litera care este apasata


        batcher.begin();

        if (ch == '0') morse.draw(batcher, "0", 150, 770);
        else if (ch == '1') morse.draw(batcher, "1", 150, 770);
        else if (ch == '2') morse.draw(batcher, "2", 150, 770);
        else if (ch == '3') morse.draw(batcher, "3", 150, 770);
        else if (ch == '4') morse.draw(batcher, "4", 150, 770);
        else if (ch == '5') morse.draw(batcher, "5", 150, 770);
        else if (ch == '6') morse.draw(batcher, "6", 150, 770);
        else if (ch == '7') morse.draw(batcher, "7", 150, 770);
        else if (ch == '8') morse.draw(batcher, "8", 150, 770);
        else if (ch == '9') morse.draw(batcher, "9", 150, 770);
        else if (ch == 'Q') morse.draw(batcher, "Q", 150, 770);
        else if (ch == 'W') morse.draw(batcher, "W", 150, 770);
        else if (ch == 'E') morse.draw(batcher, "E", 150, 770);
        else if (ch == 'R') morse.draw(batcher, "R", 150, 770);
        else if (ch == 'T') morse.draw(batcher, "T", 150, 770);
        else if (ch == 'Y') morse.draw(batcher, "Y", 150, 770);
        else if (ch == 'U') morse.draw(batcher, "U", 150, 770);
        else if (ch == 'I') morse.draw(batcher, "I", 150, 770);
        else if (ch == 'O') morse.draw(batcher, "O", 150, 770);
        else if (ch == 'P') morse.draw(batcher, "P", 150, 770);
        else if (ch == 'A') morse.draw(batcher, "A", 150, 770);
        else if (ch == 'S') morse.draw(batcher, "S", 150, 770);
        else if (ch == 'D') morse.draw(batcher, "D", 150, 770);
        else if (ch == 'F') morse.draw(batcher, "F", 150, 770);
        else if (ch == 'G') morse.draw(batcher, "G", 150, 770);
        else if (ch == 'H') morse.draw(batcher, "H", 150, 770);
        else if (ch == 'J') morse.draw(batcher, "J", 150, 770);
        else if (ch == 'K') morse.draw(batcher, "K", 150, 770);
        else if (ch == 'L') morse.draw(batcher, "L", 150, 770);
        else if (ch == 'Z') morse.draw(batcher, "Z", 150, 770);
        else if (ch == 'X') morse.draw(batcher, "X", 150, 770);
        else if (ch == 'C') morse.draw(batcher, "C", 150, 770);
        else if (ch == 'V') morse.draw(batcher, "V", 150, 770);
        else if (ch == 'B') morse.draw(batcher, "B", 150, 770);
        else if (ch == 'N') morse.draw(batcher, "N", 150, 770);
        else if (ch == 'M') morse.draw(batcher, "M", 150, 770);
        batcher.end();

    }

    public void touch(float screenX, float screenY, int pointer, int button) {
        float ratioX = screen.screenWidth / (gameWidth * 2);
        float ratioY = screen.screenHeight / (gameHeight * 2);


        // se detecteaza ce buton a fost apasat si se incepe afisarea

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

    // ciclul principal infinit

    public void updateStop(float delta) {

        //se actualizeaza cronometrul
        watch += delta;
        if (watch > 100) watch = 0;

        // daca nu este apasat nimic se opresc vibratia si lumina
        if (ch == ' ') {
            cont = 0;
            watch = 0;
            deviceControl.turnOffFlash();
            Gdx.input.cancelVibrate();
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

    }

    private void verifyQ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[11][1];
        int x2 = x + 60;
        int y = coords[11][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'Q')
                ch = ' ';
            else {
                ch = 'Q';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleQ() {

        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyW(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[12][1];
        int x2 = x + 60;
        int y = coords[12][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'W')
                ch = ' ';
            else {
                ch = 'W';
                watch = 0;
                cont = 0;

                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleW() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyE(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[13][1];
        int x2 = x + 60;
        int y = coords[13][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'E')
                ch = ' ';
            else {
                ch = 'E';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleE() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyR(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[14][1];
        int x2 = x + 60;
        int y = coords[14][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'R')
                ch = ' ';
            else {
                ch = 'R';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleR() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyT(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[15][1];
        int x2 = x + 60;
        int y = coords[15][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'T')
                ch = ' ';
            else {
                ch = 'T';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleT() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyY(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[16][1];
        int x2 = x + 60;
        int y = coords[16][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'Y')
                ch = ' ';
            else {
                ch = 'Y';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleY() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyU(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[17][1];
        int x2 = x + 60;
        int y = coords[17][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'U')
                ch = ' ';
            else {
                ch = 'U';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleU() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyI(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[18][1];
        int x2 = x + 60;
        int y = coords[18][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'I')
                ch = ' ';
            else {
                ch = 'I';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleI() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyO(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[19][1];
        int x2 = x + 60;
        int y = coords[19][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'O')
                ch = ' ';
            else {
                ch = 'O';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleO() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyP(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[20][1];
        int x2 = x + 60;
        int y = coords[20][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'P')
                ch = ' ';
            else {
                ch = 'P';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleP() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyA(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[21][1];
        int x2 = x + 60;
        int y = coords[21][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'A')
                ch = ' ';
                // daca cand apesi butonul si este deja apasat...se anuleaza
            else {
                ch = 'A';
                watch = 0;
                cont = 0;
                // initializeaza cronometrul si contorul
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
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
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                deviceControl.turnOffFlash();
            }
        }
    }

    private void verifyS(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[22][1];
        int x2 = x + 60;
        int y = coords[22][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'S')
                ch = ' ';
            else {
                ch = 'S';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleS() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyD(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[23][1];
        int x2 = x + 60;
        int y = coords[23][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'D')
                ch = ' ';
            else {
                ch = 'D';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleD() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 4;
                ch = ' ';
            }
        }
    }

    private void verifyF(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[24][1];
        int x2 = x + 60;
        int y = coords[24][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'F')
                ch = ' ';
            else {
                ch = 'F';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleF() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyG(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[25][1];
        int x2 = x + 60;
        int y = coords[25][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'G')
                ch = ' ';
            else {
                ch = 'G';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleG() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyH(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[26][1];
        int x2 = x + 60;
        int y = coords[26][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'H')
                ch = ' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleH() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyJ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[27][1];
        int x2 = x + 60;
        int y = coords[27][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'H')
                ch = ' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleJ() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyK(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[28][1];
        int x2 = x + 60;
        int y = coords[28][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'K')
                ch = ' ';
            else {
                ch = 'K';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleK() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyL(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[29][1];
        int x2 = x + 60;
        int y = coords[29][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'L')
                ch = ' ';
            else {
                ch = 'L';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleL() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyZ(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[30][1];
        int x2 = x + 60;
        int y = coords[30][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'Z')
                ch = ' ';
            else {
                ch = 'Z';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleZ() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyX(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[31][1];
        int x2 = x + 60;
        int y = coords[31][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'X')
                ch = ' ';
            else {
                ch = 'X';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleX() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyC(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[32][1];
        int x2 = x + 60;
        int y = coords[32][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'C')
                ch = ' ';
            else {
                ch = 'C';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleC() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyV(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[33][1];
        int x2 = x + 60;
        int y = coords[33][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'V')
                ch = ' ';
            else {
                ch = 'V';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleV() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyB(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[34][1];
        int x2 = x + 60;
        int y = coords[34][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'B')
                ch = ' ';
            else {
                ch = 'B';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handleB() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyN(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[35][1];
        int x2 = x + 60;
        int y = coords[35][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'N')
                ch = ' ';
            else {
                ch = 'N';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleN() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyM(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[36][1];
        int x2 = x + 60;
        int y = coords[36][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'M')
                ch = ' ';
            else {
                ch = 'M';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handleM() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    //

    private void verify0(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[1][1];
        int x2 = x + 60;
        int y = coords[1][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '0')
                ch = ' ';
            else {
                ch = '0';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle0() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=3/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify1(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[2][1];
        int x2 = x + 60;
        int y = coords[2][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '1')
                ch = ' ';
            else {
                ch = '1';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle1() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=3/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify2(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[3][1];
        int x2 = x + 60;
        int y = coords[3][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '2')
                ch = ' ';
            else {
                ch = '2';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle2() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=3/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify3(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[4][1];
        int x2 = x + 60;
        int y = coords[4][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '3')
                ch = ' ';
            else {
                ch = '3';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle3() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=3/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify4(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[5][1];
        int x2 = x + 60;
        int y = coords[5][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '4')
                ch = ' ';
            else {
                ch = '4';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle4() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=3/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify5(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[6][1];
        int x2 = x + 60;
        int y = coords[6][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '5')
                ch = ' ';
            else {
                ch = '5';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (1000 / speed));
            }
        }
    }

    private void handle5() {
        if (cont == 0) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=1/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify6(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[7][1];
        int x2 = x + 60;
        int y = coords[7][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '6')
                ch = ' ';
            else {
                ch = '6';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle6() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=1/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify7(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[8][1];
        int x2 = x + 60;
        int y = coords[8][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '7')
                ch = ' ';
            else {
                ch = '7';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle7() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (1000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=1/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify8(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[9][1];
        int x2 = x + 60;
        int y = coords[9][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '8')
                ch = ' ';
            else {
                ch = '8';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle8() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=1/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }

    private void verify9(float screenX, float screenY, float ratioX, float ratioY) {
        int x = coords[10][1];
        int x2 = x + 60;
        int y = coords[10][2];
        int y2 = y + 60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == '9')
                ch = ' ';
            else {
                ch = '9';
                watch = 0;
                cont = 0;
                deviceControl.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int) (3000 / speed));
            }
        }
    }

    private void handle9() {
        if (cont == 0) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1 / speed) {
                watch = 0;
                Gdx.input.vibrate((int) (3000 / speed));
                deviceControl.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1 / speed) {
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (3000 / speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3 / speed) {
                watch = 0;
                deviceControl.turnOffFlash();
                cont++;
            }
        }else if (cont == 7){
            if (watch>=1/speed){
                watch = 0;
                deviceControl.turnOnFlash();
                Gdx.input.vibrate((int) (1000 / speed));
                cont++;
            }
        }else if (cont ==8){
            if (watch >=1/speed){
                watch=0;
                cont =0;
                ch=' ';
            }
        }


    }
}