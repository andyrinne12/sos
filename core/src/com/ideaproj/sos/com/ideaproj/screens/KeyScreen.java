package com.ideaproj.sos.com.ideaproj.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ideaproj.sos.DeviceCameraControl;

public class KeyScreen {

    private MainScreen screen;
    private float gameWidth, gameHeight;
    private Texture backgrounT;
    private TextureRegion background;
    private float watch, cont;
    private char ch = ' ';
    private DeviceCameraControl cam;
    private float speed=2;
    private int coords[][];

    public KeyScreen(float gameWidth, float gameHeight, MainScreen screen) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.screen = screen;
        initializeTextures();
        this.watch = 0;
        this.cam=screen.cameraControl;


    }

    private void initializeCoords(){

        coords[1][1]=20;
        coords[1][2]=455;

        coords[2][1]=20;
        coords[2][2]=455;

        coords[3][1]=20;
        coords[3][2]=455;

        coords[4][1]=20;
        coords[4][2]=455;

        coords[5][1]=20;
        coords[5][2]=455;

        coords[6][1]=20;
        coords[6][2]=455;

        coords[7][1]=20;
        coords[7][2]=455;

        coords[8][1]=20;
        coords[8][2]=455;

        coords[9][1]=20;
        coords[9][2]=455;

        coords[10][1]=20;
        coords[10][2]=455;

        coords[11][1]=20;
        coords[11][2]=455;

        coords[12][1]=90;
        coords[12][2]=455;

        coords[13][1]=160;
        coords[13][2]=455;

        coords[14][1]=230;
        coords[14][2]=455;

        coords[15][1]=310;
        coords[15][2]=455;

        coords[16][1]=375;
        coords[16][2]=455;

        coords[17][1]=445;
        coords[17][2]=455;

        coords[18][1]=510;
        coords[18][2]=455;

        coords[19][1]=575;
        coords[19][2]=455;

        coords[20][1]=640;
        coords[20][2]=455;

        //rand 2
        
        coords[21][1]=50;
        coords[21][2]=520;

        coords[22][1]=120;
        coords[22][2]=520;

        coords[23][1]=20;
        coords[23][2]=520;

        coords[24][1]=20;
        coords[24][2]=520;

        coords[25][1]=20;
        coords[25][2]=520;

        coords[26][1]=20;
        coords[26][2]=520;

        coords[27][1]=20;
        coords[27][2]=520;

        coords[28][1]=20;
        coords[28][2]=520;

        coords[29][1]=20;
        coords[29][2]=520;

        coords[30][1]=20;
        coords[30][2]=455;

        coords[31][1]=20;
        coords[31][2]=455;

        coords[32][1]=20;
        coords[32][2]=455;

        coords[33][1]=20;
        coords[33][2]=455;

        coords[34][1]=20;
        coords[34][2]=455;

        coords[35][1]=20;
        coords[35][2]=455;

        coords[36][1]=20;
        coords[36][2]=455;


    }

    private void initializeTextures() {

        backgrounT = new Texture(Gdx.files.internal("keyBackground.jpg"));
        background = new TextureRegion(backgrounT);
        background.flip(false, true);


    }

    public void render(GameRenderer renderer) {
        SpriteBatch batcher = renderer.batcher;
        ShapeRenderer shaper = renderer.shapeRenderer;

        batcher.draw(background, 0, 0, gameWidth * 2, gameHeight * 2);
        //se deseneaza fundalul


        BitmapFont morse = renderer.felix;
        morse.getData().setScale(3,3);

        shaper.rect(190,520,60,60);
        shaper.rect(260,520,60,60);
        shaper.rect(335,520,60,60);
        shaper.rect(405,520,60,60);
        shaper.rect(475,520,60,60);
        shaper.rect(540,520,60,60);
        shaper.rect(610,520,60,60);

        shaper.rect(120,590,60,60);
        shaper.rect(20,590,60,60);
        shaper.rect(20,590,60,60);
        shaper.rect(20,590,60,60);
        shaper.rect(20,590,60,60);
        shaper.rect(20,590,60,60);


        // se afiseaza litera care este apasata

        if (ch == 'Q')morse.draw(batcher,"Q",350,900);
        else if(ch  == 'W')morse.draw(batcher,"W",350,900);
        else if(ch == 'E')morse.draw(batcher,"E",350,900);
        else if(ch == 'R')morse.draw(batcher,"R",350,900);
        else if(ch == 'T')morse.draw(batcher,"T",350,900);
        else if(ch == 'Y')morse.draw(batcher,"Y",350,900);
        else if(ch == 'U')morse.draw(batcher,"U",350,900);
        else if(ch == 'I')morse.draw(batcher,"I",350,900);
        else if(ch == 'O')morse.draw(batcher,"O",350,900);
        else if(ch == 'P')morse.draw(batcher,"P",350,900);
        else if(ch == 'A')morse.draw(batcher,"A",350,900);
        else if(ch == 'S')morse.draw(batcher,"S",350,900);
        else if(ch == 'D')morse.draw(batcher,"D",350,900);
        else if(ch == 'F')morse.draw(batcher,"F",350,900);
        else if(ch == 'G')morse.draw(batcher,"G",350,900);
        else if(ch == 'H')morse.draw(batcher,"H",350,900);
        else if(ch == 'J')morse.draw(batcher,"J",350,900);
        else if(ch == 'K')morse.draw(batcher,"K",350,900);
        else if(ch == 'L')morse.draw(batcher,"L",350,900);
        else if(ch == 'Z')morse.draw(batcher,"Z",350,900);
        else if(ch == 'X')morse.draw(batcher,"X",350,900);
        else if(ch == 'C')morse.draw(batcher,"C",350,900);
        else if(ch == 'V')morse.draw(batcher,"V",350,900);
        else if(ch == 'B')morse.draw(batcher,"B",350,900);
        else if(ch == 'N')morse.draw(batcher,"N",350,900);
        else if(ch == 'M')morse.draw(batcher,"M",350,900);





    }

    public void touch(float screenX, float screenY, int pointer, int button) {
        float ratioX = screen.screenWidth / (gameWidth*2);
        float ratioY = screen.screenHeight / (gameHeight*2);


        // se detecteaza ce buton a fost apasat si se incepe afisarea

        verifyQ(screenX,screenY,ratioX,ratioY);
        verifyW(screenX,screenY,ratioX,ratioY);
        verifyE(screenX,screenY,ratioX,ratioY);
        verifyR(screenX,screenY,ratioX,ratioY);
        verifyT(screenX,screenY,ratioX,ratioY);
        verifyY(screenX,screenY,ratioX,ratioY);
        verifyU(screenX,screenY,ratioX,ratioY);
        verifyI(screenX,screenY,ratioX,ratioY);
        verifyO(screenX,screenY,ratioX,ratioY);
        verifyP(screenX,screenY,ratioX,ratioY);
        verifyA(screenX,screenY,ratioX,ratioY);
        verifyS(screenX,screenY,ratioX,ratioY);
        verifyD(screenX,screenY,ratioX,ratioY);
        verifyF(screenX,screenY,ratioX,ratioY);
        verifyG(screenX,screenY,ratioX,ratioY);
        verifyH(screenX,screenY,ratioX,ratioY);

        verifyK(screenX,screenY,ratioX,ratioY);
        verifyL(screenX,screenY,ratioX,ratioY);
        verifyZ(screenX,screenY,ratioX,ratioY);
        verifyX(screenX,screenY,ratioX,ratioY);
        verifyC(screenX,screenY,ratioX,ratioY);
        verifyV(screenX,screenY,ratioX,ratioY);
        verifyB(screenX,screenY,ratioX,ratioY);
        verifyN(screenX,screenY,ratioX,ratioY);
        verifyM(screenX,screenY,ratioX,ratioY);




    }

    // ciclul principal infinit

    public void updateStop(float delta) {

        //se actualizeaza cronometrul
        watch += delta;
        if(watch>100)watch=0;

    // daca nu este apasat nimic se opresc vibratia si lumina
            if(ch == ' '){
                cont=0;
                watch=0;
                cam.turnOffFlash();
                Gdx.input.cancelVibrate();
            }

            // pentru fiecare litera se contorizeaza timpul de la ultima aprindere/stingere ptr simularea semnalelor luminoase
            else if (ch == 'Q')handleQ();
            else if(ch  == 'W')handleW();
            else if(ch == 'E')handleE();
            else if(ch == 'R')handleR();
            else if(ch == 'T')handleT();
            else if(ch == 'Y')handleY();
            else if(ch == 'U')handleU();
            else if(ch == 'I')handleI();
            else if(ch == 'O')handleO();
            else if(ch == 'P')handleP();
            else if(ch == 'A')handleA();
            else if(ch == 'S')handleS();
            else if(ch == 'D')handleD();
            else if(ch == 'F')handleF();
            else if(ch == 'G')handleG();
            else if(ch == 'H')handleH();
            else if(ch == 'J')handleJ();
            else if(ch == 'K')handleK();
            else if(ch == 'L')handleL();
            else if(ch == 'Z')handleZ();
            else if(ch == 'X')handleX();
            else if(ch == 'C')handleC();
            else if(ch == 'V')handleV();
            else if(ch == 'B')handleB();
            else if(ch == 'N')handleN();
            else if(ch == 'M')handleM();

    // aceste instructiuni se vor executa la infinit cat timp este deschis ecranul cu tastatura

    }

    private void verifyQ(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[11][1];
        int x2=x+60;
        int y=coords[11][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='Q')
                ch=' ';
            else {
                ch = 'Q';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleQ() {

        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyW(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[12][1];
        int x2=x+60;
        int y=coords[12][2];
        int y2=y+60;

        if(screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'W')
                ch = ' ';
            else {
                ch = 'W';
                watch = 0;
                cont = 0;

                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleW(){
        if(cont==0){
            if(watch>=1/speed)
            {
                watch=0;
                cam.turnOffFlash();
                cont++;
            }
        }
        else if(cont==1){
            if(watch>=1/speed)
            {
                watch=0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        }
        else if(cont ==2){
            if(watch>=3/speed){
                watch=0;
                cam.turnOffFlash();
                cont++;
            }
        }
        else if(cont==3){
            if(watch>=1/speed){
                watch=0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        }
        else if(cont==4){
            if(watch>=3/speed){
                watch=0;
                cam.turnOffFlash();
                cont=0;
                ch=' ';
            }
        }
    }

    private void verifyE(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[13][1];
        int x2=x+60;
        int y=coords[13][2];
        int y2=y+60;

        if(screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'E')
                ch = ' ';
            else {
                ch = 'E';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleE(){
        if(cont==0){
            if(watch>=1/speed)
            {
                watch=0;
                cam.turnOffFlash();
                cont=0;
                ch = ' ';
            }
        }
    }

    private void verifyR(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[14][1];
        int x2=x+60;
        int y=coords[14][2];
        int y2=y+60;

        if(screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'R')
                ch = ' ';
            else {
                ch = 'R';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleR(){
        if(cont==0){
            if(watch>=1/speed)
            {
                watch=0;
                cam.turnOffFlash();
                cont++;
            }
        }
        else if(cont==1){
            if(watch>=1/speed)
            {
                watch=0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        }
        else if(cont ==2){
            if(watch>=3/speed){
                watch=0;
                cam.turnOffFlash();
                cont++;
            }
        }
        else if(cont==3){
            if(watch>=1/speed){
                watch=0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        }
        else if(cont==4){
            if(watch>=1/speed){
                watch=0;
                cam.turnOffFlash();
                cont=0;
                ch=' ';
            }
        }
    }

    private void verifyT(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[15][1];
        int x2=x+60;
        int y=coords[15][2];
        int y2=y+60;

        if(screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if (ch == 'T')
                ch = ' ';
            else {
                ch = 'T';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleT(){
        if(cont==0){
            if(watch>=3/speed)
            {
                watch=0;
                cam.turnOffFlash();
                cont=0;
                ch = ' ';
            }
        }
    }

    private void verifyY(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[16][1];
        int x2=x+60;
        int y=coords[16][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='Y')
                ch=' ';
            else {
                ch = 'Y';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleY() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyU(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[17][1];
        int x2=x+60;
        int y=coords[17][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='U')
                ch=' ';
            else {
                ch = 'U';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleU() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3 / speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyI(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[18][1];
        int x2=x+60;
        int y=coords[18][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='I')
                ch=' ';
            else {
                ch = 'I';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleI() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1 / speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }


    }

    private void verifyO(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[19][1];
        int x2=x+60;
        int y=coords[19][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='O')
                ch=' ';
            else {
                ch = 'O';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleO() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont=0;
                ch = ' ';
            }
        }


    }

    private void verifyP(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[20][1];
        int x2=x+60;
        int y=coords[20][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= y * ratioY && screenY <= y2 * ratioY) {
            if(ch=='Y')
                ch=' ';
            else {
                ch = 'Y';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleP() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyA(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[21][1];
        int x2=x+60;
        int y=coords[21][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='A')
                ch=' ';
            // daca cand apesi butonul si este deja apasat...se anuleaza
            else {
                ch = 'A';
                watch = 0;
                cont = 0;
                // initializeaza cronometrul si contorul
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
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
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cont = 0;
                ch = ' ';
                cam.turnOffFlash();
            }
        }
    }

    private void verifyS(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[22][1];
        int x2=x+60;
        int y=coords[22][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='S')
                ch=' ';
            else {
                ch = 'S';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleS() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont=0;
                ch = ' ';
            }
        }
    }

    private void verifyD(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[23][1];
        int x2=x+60;
        int y=coords[23][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='D')
                ch=' ';
            else {
                ch = 'D';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleD() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont=4;
                ch =' ';
            }
        }
    }

    private void verifyF(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[24][1];
        int x2=x+60;
        int y=coords[24][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='F')
                ch=' ';
            else {
                ch = 'F';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleF() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyG(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[25][1];
        int x2=x+60;
        int y=coords[25][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='G')
                ch=' ';
            else {
                ch = 'G';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleG() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont=0;
                ch =' ';
            }
        }
    }

    private void verifyH(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[26][1];
        int x2=x+60;
        int y=coords[26][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='H')
                ch=' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleH() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyJ(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[27][1];
        int x2=x+60;
        int y=coords[27][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='H')
                ch=' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleJ() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyK(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[28][1];
        int x2=x+60;
        int y=coords[28][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='K')
                ch=' ';
            else {
                ch = 'K';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleK() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyL(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[29][1];
        int x2=x+60;
        int y=coords[29][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 520 * ratioY && screenY <= 580 * ratioY) {
            if(ch=='L')
                ch=' ';
            else {
                ch = 'L';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleL() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyZ(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[30][1];
        int x2=x+60;
        int y=coords[30][2];
        int y2=y+60;

        if (screenX >=x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='Z')
                ch=' ';
            else {
                ch = 'Z';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleZ() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyX(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[31][1];
        int x2=x+60;
        int y=coords[31][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='X')
                ch=' ';
            else {
                ch = 'X';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleX() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyC(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[32][1];
        int x2=x+60;
        int y=coords[32][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='C')
                ch=' ';
            else {
                ch = 'C';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleC() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(3000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyV(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[33][1];
        int x2=x+60;
        int y=coords[33][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='V')
                ch=' ';
            else {
                ch = 'V';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleV() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(3000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyB(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[34][1];
        int x2=x+60;
        int y=coords[34][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='B')
                ch=' ';
            else {
                ch = 'B';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(3000/speed));
            }
        }
    }
    private void handleB() {
        if (cont == 0) {
            if (watch >= 3/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyN(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[35][1];
        int x2=x+60;
        int y=coords[35][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='H')
                ch=' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleN() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }

    private void verifyM(float screenX,float screenY,float ratioX,float ratioY){
        int x=coords[36][1];
        int x2=x+60;
        int y=coords[36][2];
        int y2=y+60;

        if (screenX >= x * ratioX && screenX <= x2 * ratioX && screenY >= 590 * ratioY && screenY <= 650 * ratioY) {
            if(ch=='H')
                ch=' ';
            else {
                ch = 'H';
                watch = 0;
                cont = 0;
                cam.turnOnFlash();
                Gdx.input.cancelVibrate();
                Gdx.input.vibrate((int)(1000/speed));
            }
        }
    }
    private void handleM() {
        if (cont == 0) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 1) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 2) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 3) {
            if (watch >= 1/speed) {
                watch = 0;
                Gdx.input.vibrate((int)(1000/speed));
                cam.turnOnFlash();
                cont++;
            }
        } else if (cont == 4) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont++;
            }
        } else if (cont == 5) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOnFlash();
                Gdx.input.vibrate((int)(1000/speed));
                cont++;
            }
        } else if (cont == 6) {
            if (watch >= 1/speed) {
                watch = 0;
                cam.turnOffFlash();
                cont = 0;
                ch = ' ';
            }
        }
    }



}