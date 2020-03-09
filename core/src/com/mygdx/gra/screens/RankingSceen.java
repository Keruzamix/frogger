package com.mygdx.gra.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.gra.Gra;

public class RankingSceen implements Screen {

    private final Texture logo;
    private final BitmapFont rankingText;
    private final Texture tlo;

    private String[] m1;
    private String[] m2;
    private String[] m3;
    private String[] m4;
    private String[] m5;

    Gra gra;

    public RankingSceen(Gra gra){
        this.gra = gra;

        logo = new Texture("logo.png");
        rankingText = new BitmapFont();

        tlo = new Texture("tlo_2.png");


        try{

            m1 = Gra.ranking[1].split("=");
            m2 = Gra.ranking[2].split("=");
            m3 = Gra.ranking[3].split("=");
            m4 = Gra.ranking[4].split("=");
            m5 = Gra.ranking[5].split("=");
        }catch (Exception e){

        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gra.batch.begin();

        gra.batch.draw(tlo, 0,0, Gra.SZEROKOSC_OKNA, Gra.WYSOKOSC_OKNA);

        gra.batch.draw(logo, Gra.SZEROKOSC_OKNA/2-150, 650, 300, 200);

        try{
            rankingText.getData().setScale(3,3);
            rankingText.draw(gra.batch, "RANKING", 300, 600);
            rankingText.draw(gra.batch, "1: "+m1[0], 200, 500);
            rankingText.draw(gra.batch, "2: "+m2[0], 200, 450);
            rankingText.draw(gra.batch, "3: "+m3[0], 200, 400);
            rankingText.draw(gra.batch, "4: "+m4[0], 200, 350);
            rankingText.draw(gra.batch, "5: "+m5[0], 200, 300);

            rankingText.draw(gra.batch, m1[1], 500, 500);
            rankingText.draw(gra.batch, m2[1], 500, 450);
            rankingText.draw(gra.batch, m3[1], 500, 400);
            rankingText.draw(gra.batch, m4[1], 500, 350);
            rankingText.draw(gra.batch, m5[1], 500, 300);

        }catch (Exception e){
            e.printStackTrace();
        }


        gra.batch.end();

    }

    private void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            gra.setScreen(new MainMenuScreen(gra));
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
        logo.dispose();
        rankingText.dispose();
        tlo.dispose();
    }
}
