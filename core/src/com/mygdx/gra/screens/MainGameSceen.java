package com.mygdx.gra.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.gra.GameObject;
import com.mygdx.gra.Gra;


import java.awt.*;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;
import static com.mygdx.gra.Gra.punkty;


public class MainGameSceen implements Screen {


    private final Stage stage;
    private final Skin skin;
    private final TextField pole;
    private Texture zaba;
    private int szybkosc_ruchu_zaby = 300;
    private int wspolrzedne_klody = -150;
    private int szybkosc_ruchu_zolwi = 3;
    private int wspolrzedne_zolwi = 800;
    private int wspolrzedne_klody_2 = -150;
    private Texture platforma, woda, nic;
    private GameObject objekt_woda;
    private Texture ciezarowka_niebieska, ciezarowka_rozowa, auto_pomaranczowe, auto_zolte, kloda;
    private GameObject objekt_zaba, objekt_niebieska_ciezarowka, objekt_ciezarowka_rozowa, objekt_auto_pomaranczowe, objekt_auto_zolte, objekt_auto_pomaranczowe_2;
    private GameObject objekt_pustka_1, objekt_pustka_2, objekt_pustka_3, objekt_kloda_1, objekt_kloda_2;
    private Texture zolwie;
    private GameObject objekt_zolwie, objekt_pustka_zolwie, objekt_pustka_zolwie_2;
    private GameObject objekt_pustka_poziom2_1, objekt_pustka_poziom2_2, objekt_pustka_poziom2_3;
    private GameObject objekt_kloda_poziom2_1, objekt_kloda_poziom2_2;
    private GameObject objekt_zolwie_poziom2, objekt_pustka_zolwie_poziom2, objekt_pustka_zolwie_poziom2_2;
    private GameObject objekt_auto_zolte_2;
    private GameObject objekt_auto_zolte_3;
    private Texture lisc;
    private Texture krzak;
    private GameObject objekt_krzak;
    private GameObject objekt_krzak_nic_1;
    private GameObject objekt_krzak_nic_2;
    private GameObject meta;
    private Texture auto_sportowe_1;
    private Texture auto_zielone;
    private Texture autko_ferrari;



    private boolean[] flaga = new boolean[12];
    private int zycia = 3;

    Gra gra;
    private BitmapFont zycia_text;
    private BitmapFont czas_text;
    private BitmapFont punkty_text;
    private float zegar = 60;


    private int f1=0, f2=0, f3=0;




    public MainGameSceen (Gra gra){
        this.gra = gra;

        punkty=0;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        pole = new TextField("",skin);
        pole.setPosition(0,800);
        pole.setSize(800,50);
        stage.addActor(pole);

    }

    @Override
    public void show() {
        zaba = new Texture("80sFrogger.png");
        platforma = new Texture("platforma.png");
        ciezarowka_niebieska = new Texture("blue_truck_r.png");
        ciezarowka_rozowa = new Texture("pink_truck.png");
        auto_pomaranczowe = new Texture("orange_car.png");
        auto_zolte = new Texture("taxi.png");
        auto_sportowe_1 = new Texture("sport_1.png");
        auto_zielone = new Texture("autko_zielone.png");
        autko_ferrari = new Texture("ferrari.png");
        kloda = new Texture("log.png");
        woda = new Texture("woda.png");
        nic = new Texture("nic.png");

        lisc = new Texture("lisc.png");
        krzak = new Texture("krzak.png");


        zolwie = new Texture("turtle_t.png");

        zycia_text = new BitmapFont();
        czas_text = new BitmapFont();
        punkty_text = new BitmapFont();




        /* Tworzenie objektow */
        objekt_zaba = new GameObject(zaba);
        objekt_zaba.x = 400;
        objekt_zaba.y = 0;
        objekt_zaba.width = 50;
        objekt_zaba.height = 50;



        objekt_woda = new GameObject(woda);
        objekt_woda.x = 0;
        objekt_woda.y = 400;
        objekt_woda.width = 800;
        objekt_woda.height = 350;


        objekt_niebieska_ciezarowka = new GameObject(ciezarowka_niebieska);
        objekt_niebieska_ciezarowka.x = 0;
        objekt_niebieska_ciezarowka.y = 90;
        objekt_niebieska_ciezarowka.width = 150;
        objekt_niebieska_ciezarowka.height = 50;

        objekt_ciezarowka_rozowa = new GameObject(ciezarowka_rozowa);
        objekt_ciezarowka_rozowa.x = 800;
        objekt_ciezarowka_rozowa.y = 145;
        objekt_ciezarowka_rozowa.width = 150;
        objekt_ciezarowka_rozowa.height = 50;


        /*----------------zolte-autka------------------*/
        objekt_auto_zolte = new GameObject(auto_zolte);
        objekt_auto_zolte.x = 750;
        objekt_auto_zolte.y = 210;
        objekt_auto_zolte.width = 90;
        objekt_auto_zolte.height = 50;


        objekt_auto_zolte_2 = new GameObject(auto_zielone);
        objekt_auto_zolte_2.x = 100;
        objekt_auto_zolte_2.y = 210;
        objekt_auto_zolte_2.width = 85;
        objekt_auto_zolte_2.height = 50;


        objekt_auto_zolte_3 = new GameObject(autko_ferrari);
        objekt_auto_zolte_3.x = 350;
        objekt_auto_zolte_3.y = 210;
        objekt_auto_zolte_3.width = 85;
        objekt_auto_zolte_3.height = 50;

        objekt_auto_pomaranczowe_2 = new GameObject(auto_pomaranczowe);
        objekt_auto_pomaranczowe_2.x = 400;
        objekt_auto_pomaranczowe_2.y = 270;
        objekt_auto_pomaranczowe_2.width = 100;
        objekt_auto_pomaranczowe_2.height = 50;

        objekt_auto_pomaranczowe = new GameObject(auto_sportowe_1);
        objekt_auto_pomaranczowe.x = 100;
        objekt_auto_pomaranczowe.y = 270;
        objekt_auto_pomaranczowe.width = 95;
        objekt_auto_pomaranczowe.height = 50;

        objekt_kloda_1 = new GameObject(kloda);
        objekt_kloda_1.x = 0;
        objekt_kloda_1.y = 400;
        objekt_kloda_1.width = 150;
        objekt_kloda_1.height = 55;

        objekt_kloda_2 = new GameObject(kloda);
        objekt_kloda_2.x = 400;
        objekt_kloda_2.y = 400;
        objekt_kloda_2.width = 150;
        objekt_kloda_2.height = 55;

        objekt_pustka_1 = new GameObject(nic);
        objekt_pustka_1.width = 200;
        objekt_pustka_1.height = 20;
        objekt_pustka_1.y = 417;
        objekt_pustka_1.x = 175;


        objekt_pustka_2 = new GameObject(nic);
        objekt_pustka_2.width = 200;
        objekt_pustka_2.height = 20;
        objekt_pustka_2.y = 417;
        objekt_pustka_2.x = 575;

        objekt_pustka_3 = new GameObject(nic);
        objekt_pustka_3.width = 200;
        objekt_pustka_3.height = 20;
        objekt_pustka_3.y = 417;
        objekt_pustka_3.x = -250;

        /*----------------zolwie-------------*/
        objekt_zolwie = new GameObject(zolwie);
        objekt_zolwie.width = 400;
        objekt_zolwie.height = 50;
        objekt_zolwie.y = 467;
        objekt_zolwie.x = 0;

        objekt_pustka_zolwie = new GameObject(nic);
        objekt_pustka_zolwie.width = 350;
        objekt_pustka_zolwie.height = 20;
        objekt_pustka_zolwie.y = 480;
        objekt_pustka_zolwie.x = 420;

        objekt_pustka_zolwie_2 = new GameObject(nic);
        objekt_pustka_zolwie_2.width = 350;
        objekt_pustka_zolwie_2.height = 20;
        objekt_pustka_zolwie_2.y = 480;
        objekt_pustka_zolwie_2.x = -420;

        /*------------------klody-2------------------*/
        objekt_kloda_poziom2_1 = new GameObject(kloda);
        objekt_kloda_poziom2_1.x = 250; //+250
        objekt_kloda_poziom2_1.y = 525;
        objekt_kloda_poziom2_1.width = 150;
        objekt_kloda_poziom2_1.height = 55;

        objekt_kloda_poziom2_2 = new GameObject(kloda);
        objekt_kloda_poziom2_2.x = 650;
        objekt_kloda_poziom2_2.y = 525;
        objekt_kloda_poziom2_2.width = 150;
        objekt_kloda_poziom2_2.height = 55;

        objekt_pustka_poziom2_1 = new GameObject(nic);
        objekt_pustka_poziom2_1.x = 425;
        objekt_pustka_poziom2_1.y = 540;
        objekt_pustka_poziom2_1.width = 200;
        objekt_pustka_poziom2_1.height = 20;


        objekt_pustka_poziom2_2 = new GameObject(nic);
        objekt_pustka_poziom2_2.x = 825;
        objekt_pustka_poziom2_2.y = 540;
        objekt_pustka_poziom2_2.width = 200;
        objekt_pustka_poziom2_2.height = 20;

        objekt_pustka_poziom2_3 = new GameObject(nic);
        objekt_pustka_poziom2_3.x = 0;
        objekt_pustka_poziom2_3.y = 540;
        objekt_pustka_poziom2_3.width = 200;
        objekt_pustka_poziom2_3.height = 20;

        /*----------------zolwie-------------*/
        objekt_zolwie_poziom2 = new GameObject(zolwie);
        objekt_zolwie_poziom2.width = 400;
        objekt_zolwie_poziom2.height = 50;
        objekt_zolwie_poziom2.y = 585;
        objekt_zolwie_poziom2.x = 300;

        objekt_pustka_zolwie_poziom2 = new GameObject(nic);
        objekt_pustka_zolwie_poziom2.width = 350;
        objekt_pustka_zolwie_poziom2.height = 20;
        objekt_pustka_zolwie_poziom2.y = 600;
        objekt_pustka_zolwie_poziom2.x = 720;

        objekt_pustka_zolwie_poziom2_2 = new GameObject(nic);
        objekt_pustka_zolwie_poziom2_2.width = 350;
        objekt_pustka_zolwie_poziom2_2.height = 20;
        objekt_pustka_zolwie_poziom2_2.y = 600;
        objekt_pustka_zolwie_poziom2_2.x = -100;


        objekt_krzak = new GameObject(krzak);
        objekt_krzak.width = 100;
        objekt_krzak.height = 100;
        objekt_krzak.y = 600;

        objekt_krzak_nic_1 = new GameObject(nic);
        objekt_krzak_nic_1.width = 340;
        objekt_krzak_nic_1.height = 80;
        objekt_krzak_nic_1.y = 660;
        objekt_krzak_nic_1.x = 0;

        objekt_krzak_nic_2 = new GameObject(nic);
        objekt_krzak_nic_2.width = 340;
        objekt_krzak_nic_2.height = 80;
        objekt_krzak_nic_2.y = 660;
        objekt_krzak_nic_2.x = 460;


        meta = new GameObject(nic);
        meta.width = 70;
        meta.height = 60;
        meta.y = 660;
        meta.x = 375;

    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




        gra.batch.begin();

        gra.batch.draw(platforma, 0, 0, 800, 80);
        gra.batch.draw(platforma, 0, 320, 800, 80);
        gra.batch.draw(objekt_woda.getTexture(), objekt_woda.x, objekt_woda.y, objekt_woda.width, objekt_woda.height);
        gra.batch.draw(lisc, 350, 640, 100, 100);
        gra.batch.draw(objekt_krzak.getTexture(), 0, 640, 100, 100);
        gra.batch.draw(objekt_krzak.getTexture(), 120, 640, 100, 100);
        gra.batch.draw(objekt_krzak.getTexture(), 240, 640, 100, 100);

        gra.batch.draw(objekt_krzak.getTexture(), 470, 640, 100, 100);
        gra.batch.draw(objekt_krzak.getTexture(), 700, 640, 100, 100);
        gra.batch.draw(objekt_krzak.getTexture(), 590, 640, 100, 100);

        gra.batch.draw(objekt_krzak_nic_1.getTexture(), objekt_krzak_nic_1.x, objekt_krzak_nic_1.y, objekt_krzak_nic_1.width, objekt_krzak_nic_1.height);
        gra.batch.draw(objekt_krzak_nic_2.getTexture(), objekt_krzak_nic_2.x, objekt_krzak_nic_2.y, objekt_krzak_nic_2.width, objekt_krzak_nic_2.height);


        gra.batch.draw(objekt_ciezarowka_rozowa.getTexture(), objekt_ciezarowka_rozowa.x, objekt_ciezarowka_rozowa.y, objekt_ciezarowka_rozowa.width, objekt_ciezarowka_rozowa.height);
        gra.batch.draw(objekt_niebieska_ciezarowka.getTexture(), objekt_niebieska_ciezarowka.x, objekt_niebieska_ciezarowka.y, objekt_niebieska_ciezarowka.width, objekt_niebieska_ciezarowka.height);
        gra.batch.draw(objekt_auto_pomaranczowe.getTexture(), objekt_auto_pomaranczowe.x, objekt_auto_pomaranczowe.y, objekt_auto_pomaranczowe.width, objekt_auto_pomaranczowe.height);

        gra.batch.draw(objekt_auto_zolte.getTexture(), objekt_auto_zolte.x, objekt_auto_zolte.y, objekt_auto_zolte.width, objekt_auto_zolte.height);
        gra.batch.draw(objekt_auto_zolte_2.getTexture(), objekt_auto_zolte_2.x, objekt_auto_zolte_2.y, objekt_auto_zolte_2.width, objekt_auto_zolte_2.height);
        gra.batch.draw(objekt_auto_zolte_3.getTexture(), objekt_auto_zolte_3.x, objekt_auto_zolte_3.y, objekt_auto_zolte_3.width, objekt_auto_zolte_3.height);

        gra.batch.draw(objekt_auto_pomaranczowe_2.getTexture(), objekt_auto_pomaranczowe_2.x, objekt_auto_pomaranczowe_2.y, objekt_auto_pomaranczowe_2.width, objekt_auto_pomaranczowe_2.height);

        /*-----------------klody-1---------------------------*/
        gra.batch.draw(objekt_kloda_1.getTexture(), objekt_kloda_1.x, objekt_kloda_1.y, objekt_kloda_1.width, objekt_kloda_1.height);
        gra.batch.draw(objekt_kloda_2.getTexture(), objekt_kloda_2.x, objekt_kloda_2.y, objekt_kloda_2.width, objekt_kloda_2.height);
        gra.batch.draw(objekt_pustka_1.getTexture(), objekt_pustka_1.x, objekt_pustka_1.y, objekt_pustka_1.width, objekt_pustka_1.height);
        gra.batch.draw(objekt_pustka_2.getTexture(), objekt_pustka_2.x, objekt_pustka_2.y, objekt_pustka_2.width, objekt_pustka_2.height);
        gra.batch.draw(objekt_pustka_3.getTexture(), objekt_pustka_3.x, objekt_pustka_3.y, objekt_pustka_3.width, objekt_pustka_3.height);

        /*-------------------------------------------------*/
        /*------------------zolwie-------------------------------*/
        gra.batch.draw(objekt_zolwie.getTexture(), objekt_zolwie.x, objekt_zolwie.y, objekt_zolwie.width, objekt_zolwie.height);
        gra.batch.draw(objekt_pustka_zolwie.getTexture(), objekt_pustka_zolwie.x, objekt_pustka_zolwie.y, objekt_pustka_zolwie.width, objekt_pustka_zolwie.height);
        gra.batch.draw(objekt_pustka_zolwie_2.getTexture(), objekt_pustka_zolwie_2.x, objekt_pustka_zolwie_2.y, objekt_pustka_zolwie_2.width, objekt_pustka_zolwie_2.height);

        /*-------------------------------------------------*/
        /*-----------------klody-2---------------------------*/
        gra.batch.draw(objekt_kloda_poziom2_1.getTexture(), objekt_kloda_poziom2_1.x, objekt_kloda_poziom2_1.y, objekt_kloda_poziom2_1.width, objekt_kloda_poziom2_1.height);
        gra.batch.draw(objekt_kloda_poziom2_2.getTexture(), objekt_kloda_poziom2_2.x, objekt_kloda_poziom2_2.y, objekt_kloda_poziom2_2.width, objekt_kloda_poziom2_2.height);
        gra.batch.draw(objekt_pustka_poziom2_1.getTexture(), objekt_pustka_poziom2_1.x, objekt_pustka_poziom2_1.y, objekt_pustka_poziom2_1.width, objekt_pustka_poziom2_1.height);
        gra.batch.draw(objekt_pustka_poziom2_2.getTexture(), objekt_pustka_poziom2_2.x, objekt_pustka_poziom2_2.y, objekt_pustka_poziom2_2.width, objekt_pustka_poziom2_2.height);
        gra.batch.draw(objekt_pustka_poziom2_3.getTexture(), objekt_pustka_poziom2_3.x, objekt_pustka_poziom2_3.y, objekt_pustka_poziom2_3.width, objekt_pustka_poziom2_3.height);

        /*-------------------------------------------------*/
        /*------------------zolwie-2------------------------------*/
        gra.batch.draw(objekt_zolwie_poziom2.getTexture(), objekt_zolwie_poziom2.x, objekt_zolwie_poziom2.y, objekt_zolwie_poziom2.width, objekt_zolwie_poziom2.height);
        gra.batch.draw(objekt_pustka_zolwie_poziom2.getTexture(), objekt_pustka_zolwie_poziom2.x, objekt_pustka_zolwie_poziom2.y, objekt_pustka_zolwie_poziom2.width, objekt_pustka_zolwie_poziom2.height);
        gra.batch.draw(objekt_pustka_zolwie_poziom2_2.getTexture(), objekt_pustka_zolwie_poziom2_2.x, objekt_pustka_zolwie_poziom2_2.y, objekt_pustka_zolwie_poziom2_2.width, objekt_pustka_zolwie_poziom2_2.height);

        /*-------------------------------------------------*/

        gra.batch.draw(meta.getTexture(), meta.x, meta.y, meta.width, meta.height);


        /*---------------hud---------------------------*/
        String zyc = "Zycia: "+ zycia;
        zycia_text.getData().setScale(3,3);
        zycia_text.draw(gra.batch, zyc, 0, 790);

        String pun = "Punkty: "+ punkty;
        punkty_text.getData().setScale(3,3);
        punkty_text.draw(gra.batch, pun, 300, 790);

        String cza = "Czas: "+ zegar;
        czas_text.getData().setScale(3,3);
        czas_text.draw(gra.batch, cza, 593, 790);

        /*------------------chat--------------------*/



       if(Gra.chat[0]!=null){
            czas_text.draw(gra.batch, Gra.chat[0], 0, 1000);
        }

        if(Gra.chat[1]!=null){
            czas_text.draw(gra.batch, Gra.chat[1], 0, 950);
        }

        if(Gra.chat[2]!=null){
            czas_text.draw(gra.batch, Gra.chat[2], 0, 900);
        }

        gra.batch.draw(objekt_zaba.getTexture(), objekt_zaba.x, objekt_zaba.y, objekt_zaba.width, objekt_zaba.height);

        gra.batch.end();

        stage.draw();

        /*------------chat------------------------*/
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && pole.getText().length()>0) {
            //System.out.println(pole.getText());
            Gra.wiadomosc = pole.getText();
            //gra.setScreen(new MainMenuScreen(gra));
            pole.setText("");
        }

    }

    private void update() {


        /*-------------------------punkty-------------------------------------*/

        if(objekt_zaba.y>=55 && objekt_zaba.y<=100 && flaga[1]==false)
        {
            punkty += 100;
            flaga[1]=true;
            System.out.println(punkty);
        }

        if(objekt_zaba.y>=95 && objekt_zaba.y<=160 && flaga[2]==false)
        {
            punkty += 100;
            flaga[2]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=150 && objekt_zaba.y<=210 && flaga[3]==false)
        {
            punkty += 100;
            flaga[3]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=200 && objekt_zaba.y<=260 && flaga[4]==false)
        {
            punkty += 100;
            flaga[4]=true;
            System.out.println(punkty);
        }

        if(objekt_zaba.y>=250 && objekt_zaba.y<=310 && flaga[5]==false)
        {
            punkty += 100;
            flaga[5]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=300 && objekt_zaba.y<=360 && flaga[6]==false)
        {
            punkty += 100;
            flaga[6]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=350 && objekt_zaba.y<=410 && flaga[7]==false)
        {
            punkty += 100;
            flaga[7]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=400 && objekt_zaba.y<=460 && flaga[8]==false)
        {
            punkty += 100;
            flaga[8]=true;
            System.out.println(punkty);
        }


        if(objekt_zaba.y>=450 && objekt_zaba.y<=510 && flaga[9]==false)
        {
            punkty += 100;
            flaga[9]=true;
            System.out.println(punkty);
        }

        if(objekt_zaba.y>=500 && objekt_zaba.y<=560 && flaga[10]==false)
        {
            punkty += 100;
            flaga[10]=true;
            System.out.println(punkty);
        }


        /*----------------------sterowanie-zaba--------------------------------------------*/

        if(objekt_zaba.x>=0)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                objekt_zaba.x -= szybkosc_ruchu_zaby * Gdx.graphics.getDeltaTime();
            }
        }

        if(objekt_zaba.x<=748)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                objekt_zaba.x += szybkosc_ruchu_zaby * Gdx.graphics.getDeltaTime();
            }

        }

        if(objekt_zaba.y<=748){
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                objekt_zaba.y += szybkosc_ruchu_zaby * Gdx.graphics.getDeltaTime();
            }

        }

        if(objekt_zaba.y>=0){
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                objekt_zaba.y -= szybkosc_ruchu_zaby * Gdx.graphics.getDeltaTime();
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            gra.setScreen(new MainMenuScreen(gra));

        }


        /*----------------ciezarowka-niebieska--------------------------------------------------*/

        if(objekt_niebieska_ciezarowka.x<800)
        {
            objekt_niebieska_ciezarowka.x += 5;
        }
        else{
            objekt_niebieska_ciezarowka.x=-100;

        }


        /*---------------ciezarowka-rozowa---------------------------------------------------*/


        if(objekt_ciezarowka_rozowa.x>= -150)
        {
            objekt_ciezarowka_rozowa.x -= 2;
        }
        else{
            objekt_ciezarowka_rozowa.x=+800;

        }


        /*---------------autko-pomatanczowe---------------------------------------------------*/

        if(objekt_auto_pomaranczowe.x<800)
        {
            objekt_auto_pomaranczowe.x += 5;
        }
        else{
            objekt_auto_pomaranczowe.x=-100;
        }


        if(objekt_auto_pomaranczowe_2.x<800)
        {
            objekt_auto_pomaranczowe_2.x += 5;
        }
        else{
            objekt_auto_pomaranczowe_2.x=-100;
        }


        /*----------------------autko-zolte---------------------------------------------*/

        if(objekt_auto_zolte.x>= -150)
        {
            objekt_auto_zolte.x -= 6;
        }
        else{
            objekt_auto_zolte.x=+800;
        }


        if(objekt_auto_zolte_2.x>= -150)
        {
            objekt_auto_zolte_2.x -= 6;
        }
        else{
            objekt_auto_zolte_2.x=+800;
        }


        if(objekt_auto_zolte_3.x>= -150)
        {
            objekt_auto_zolte_3.x -= 6;
        }
        else{
            objekt_auto_zolte_3.x=+800;
        }


        /*--------------klody-zwijanie-----------------------------------------------------*/

        if(objekt_pustka_1.x<=800)
            objekt_pustka_1.x += 4;
        else
            objekt_pustka_1.x = wspolrzedne_klody;

        if(objekt_pustka_2.x<=800)
            objekt_pustka_2.x += 4;
        else
            objekt_pustka_2.x = wspolrzedne_klody;

        if(objekt_pustka_3.x<=800)
            objekt_pustka_3.x += 4;
        else
            objekt_pustka_3.x = wspolrzedne_klody;

        if(objekt_kloda_2.x<= 800)
            objekt_kloda_2.x += 4;
        else
            objekt_kloda_2.x = wspolrzedne_klody;

        if(objekt_kloda_1.x<=800) {
            objekt_kloda_1.x += 4;
        }
        else {
            objekt_kloda_1.x = wspolrzedne_klody;
        }

        /*------------------------zolwie-zawijanie-----------------------------*/
        if(objekt_zolwie.x>=-400)
            objekt_zolwie.x -= szybkosc_ruchu_zolwi;
        else
            objekt_zolwie.x = wspolrzedne_zolwi;

        if(objekt_pustka_zolwie.x>=-400)
            objekt_pustka_zolwie.x -= szybkosc_ruchu_zolwi;
        else
            objekt_pustka_zolwie.x = wspolrzedne_zolwi;

        if(objekt_pustka_zolwie_2.x>=-400)
            objekt_pustka_zolwie_2.x -= szybkosc_ruchu_zolwi;
        else
            objekt_pustka_zolwie_2.x = wspolrzedne_zolwi;

        /*--------------klody-zwijanie-2----------------------------------------------------*/

        if(objekt_pustka_poziom2_1.x<=800)
            objekt_pustka_poziom2_1.x += 2;
        else
            objekt_pustka_poziom2_1.x = wspolrzedne_klody_2;

        if(objekt_pustka_poziom2_2.x<=800)
            objekt_pustka_poziom2_2.x += 2;
        else
            objekt_pustka_poziom2_2.x = wspolrzedne_klody_2;

        if(objekt_pustka_poziom2_3.x<=800)
            objekt_pustka_poziom2_3.x += 2;
        else
            objekt_pustka_poziom2_3.x = wspolrzedne_klody_2;

        if(objekt_kloda_poziom2_2.x<= 800)
            objekt_kloda_poziom2_2.x += 2;
        else
            objekt_kloda_poziom2_2.x = wspolrzedne_klody_2;

        if(objekt_kloda_poziom2_1.x<=800) {
            objekt_kloda_poziom2_1.x += 2;
        }
        else {
            objekt_kloda_poziom2_1.x = wspolrzedne_klody_2;
        }

        /*------------------------zolwie-zawijanie-2----------------------------*/
        if(objekt_zolwie_poziom2.x>=-400)
            objekt_zolwie_poziom2.x -= szybkosc_ruchu_zolwi;
        else
            objekt_zolwie_poziom2.x = wspolrzedne_zolwi;

        if(objekt_pustka_zolwie_poziom2.x>=-400)
            objekt_pustka_zolwie_poziom2.x -= szybkosc_ruchu_zolwi;
        else
            objekt_pustka_zolwie_poziom2.x = wspolrzedne_zolwi;

        if(objekt_pustka_zolwie_poziom2_2.x>=-400)
            objekt_pustka_zolwie_poziom2_2.x -= szybkosc_ruchu_zolwi;
        else
            objekt_pustka_zolwie_poziom2_2.x = wspolrzedne_zolwi;


        /*--------------kolizje----------------------------------------------------*/

        if(objekt_krzak_nic_1.overlaps(objekt_zaba) || objekt_krzak_nic_2.overlaps(objekt_zaba) || objekt_auto_zolte_2.overlaps(objekt_zaba) || objekt_auto_zolte_3.overlaps(objekt_zaba) || objekt_pustka_zolwie_poziom2_2.overlaps(objekt_zaba)  ||objekt_pustka_zolwie_poziom2.overlaps(objekt_zaba) || objekt_pustka_poziom2_1.overlaps(objekt_zaba) || objekt_pustka_poziom2_2.overlaps(objekt_zaba) || objekt_pustka_poziom2_3.overlaps(objekt_zaba) || objekt_pustka_poziom2_1.overlaps(objekt_zaba) || objekt_pustka_poziom2_2.overlaps(objekt_zaba) || objekt_pustka_poziom2_3.overlaps(objekt_zaba) || objekt_pustka_zolwie_2.overlaps(objekt_zaba)  ||objekt_pustka_zolwie.overlaps(objekt_zaba) || objekt_pustka_1.overlaps(objekt_zaba) || objekt_pustka_2.overlaps(objekt_zaba) || objekt_pustka_3.overlaps(objekt_zaba) || objekt_niebieska_ciezarowka.overlaps(objekt_zaba) || objekt_ciezarowka_rozowa.overlaps(objekt_zaba) || objekt_auto_zolte.overlaps(objekt_zaba) || objekt_auto_pomaranczowe_2.overlaps(objekt_zaba) || objekt_auto_pomaranczowe.overlaps(objekt_zaba)){

            if(zycia==1){
                //Gdx.app.exit();
                gra.setScreen(new PodsumowującyScreen(gra));
            }
            else{
                objekt_zaba.x = 400;
                objekt_zaba.y = 0;
                zycia -= 1;

                punkty=0;
                for(int i=1; i<12; i++)
                    flaga[i]=false;
            }
        }

        if(objekt_kloda_1.overlaps(objekt_zaba) || objekt_kloda_2.overlaps(objekt_zaba)){
                if(objekt_zaba.x<=750)
                    objekt_zaba.x += 4;
        }

        if(objekt_zolwie.overlaps(objekt_zaba)){
            if(objekt_zaba.x>=0)
                objekt_zaba.x -= 3;
        }


        if(objekt_kloda_poziom2_1.overlaps(objekt_zaba) || objekt_kloda_poziom2_2.overlaps(objekt_zaba)){
            if(objekt_zaba.x<=750)
                objekt_zaba.x += 2;
        }


        if(objekt_zolwie_poziom2.overlaps(objekt_zaba)){
            if(objekt_zaba.x>=0)
                objekt_zaba.x -= 3;
        }

        if( meta.overlaps(objekt_zaba)){
            System.out.println("Wygrales!");
            punkty+=(200+100*zycia);
            gra.setScreen(new PodsumowującyScreen(gra));

        }

        /*-----------------zegar-------------------------*/
        zegar -= Gdx.graphics.getDeltaTime();

        if(zegar <= 0){
            gra.setScreen(new PodsumowującyScreen(gra));
        }


    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gra.batch.dispose();
        zaba.dispose();
        platforma.dispose();
        woda.dispose();
        nic.dispose();
        ciezarowka_niebieska.dispose();
        ciezarowka_rozowa.dispose();
        auto_pomaranczowe.dispose();
        auto_zolte.dispose();
        kloda.dispose();
        lisc.dispose();
        krzak.dispose();
        auto_sportowe_1.dispose();
        auto_zielone.dispose();
        autko_ferrari.dispose();
        zycia_text.dispose();
        czas_text.dispose();
        punkty_text.dispose();
    }
}
