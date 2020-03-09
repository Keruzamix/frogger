package com.mygdx.gra.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.gra.Gra;

import static com.mygdx.gra.Gra.imie;
import static com.mygdx.gra.Gra.punkty;

public class PodsumowującyScreen implements Screen {

    private final Texture tlo;
    Gra gra;

    private BitmapFont tytul;
    private float PRZYCISK_WYSOKOSC=100;
    private float PRZYCISK_SZEROKOSC=200;

    private int flagaaa=0;

    Texture przyciskGrajAkt;
    Texture przyciskGrajNieakt;
    Texture przyciskZamknijAkt;
    Texture przyciskZamknijNieakt;



    public PodsumowującyScreen(Gra gra){
        this.gra = gra;

        tytul = new BitmapFont();
        przyciskGrajAkt = new Texture("start_a.png");
        przyciskGrajNieakt = new Texture("start_n.png");
        przyciskZamknijAkt = new Texture("exit_a.png");
        przyciskZamknijNieakt = new Texture("exit_n.png");

        tlo = new Texture("tlo_2.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gra.batch.begin();
        gra.batch.draw(tlo, 0,0, Gra.SZEROKOSC_OKNA, Gra.WYSOKOSC_OKNA);


        tytul.getData().setScale(3,3);
        tytul.draw(gra.batch, "Liczba zdobytych punktów:", 150, 800);
        tytul.draw(gra.batch, punkty+"", 800/2-15, 725);

        //Gra.wiadomosc += ";"+punkty;
        if(flagaaa==0){
            Gra.wiadomosc = "zdobyl = "+punkty;
            flagaaa=1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            gra.setScreen(new MainMenuScreen(gra));
        }

        if(Gdx.input.getX()>=Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC-25 && Gdx.input.getX()<=Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC-25+200 && Gdx.input.getY()>=350 && Gdx.input.getY()<=450){
            gra.batch.draw(przyciskGrajNieakt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC-25, 550, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
            if(Gdx.input.isTouched()){
                gra.setScreen(new MainGameSceen(gra));
            }
        }
        else{
            gra.batch.draw(przyciskGrajAkt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC-25, 550, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);

        }

        if(Gdx.input.getX()>=Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC+250 && Gdx.input.getX()<=Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC+250+200 && Gdx.input.getY()>=350 && Gdx.input.getY()<=450){
            gra.batch.draw(przyciskZamknijNieakt , Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC+250, 550, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
            if(Gdx.input.isTouched()){
                gra.setScreen(new MainMenuScreen(gra));
            }
        }
        else{
            gra.batch.draw(przyciskZamknijAkt , Gra.SZEROKOSC_OKNA/2-PRZYCISK_SZEROKOSC+250, 550, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);

        }

        gra.batch.end();
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
        tytul.dispose();
        przyciskGrajAkt.dispose();
        przyciskGrajNieakt.dispose();
        przyciskZamknijAkt.dispose();
        przyciskZamknijNieakt.dispose();
    }
}
