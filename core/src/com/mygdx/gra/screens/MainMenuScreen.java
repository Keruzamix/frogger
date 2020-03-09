package com.mygdx.gra.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.gra.Gra;

import static com.mygdx.gra.Gra.flaga_glowana;

public class MainMenuScreen implements Screen {

    private final Texture przyciskRankingAkt;
    private final Texture przyciskRankingNieakt;
    private final Texture logo;
    private final BitmapFont podaj_nikc;
    private final Texture tlo;
    private boolean wpisany_nick = false;
    Gra gra;

    Texture przyciskGrajAkt;
    Texture przyciskGrajNieakt;
    Texture przyciskZamknijAkt;
    Texture przyciskZamknijNieakt;

    private float PRZYCISK_WYSOKOSC=100;
    private float PRZYCISK_SZEROKOSC=200;


    private Skin skin;
    private Stage stage;
    private TextField pole;

    public MainMenuScreen(Gra gra){
        this.gra = gra;
        przyciskGrajAkt = new Texture("start_a.png");
        przyciskGrajNieakt = new Texture("start_n.png");
        przyciskZamknijAkt = new Texture("exit_a.png");
        przyciskZamknijNieakt = new Texture("exit_n.png");

        przyciskRankingAkt = new Texture("ranking_a.png");
        przyciskRankingNieakt = new Texture("ranking_n.png");

        logo = new Texture("logo.png");
        tlo = new Texture("tlo.png");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        pole = new TextField("",skin);
        pole.setPosition(800/2-100,500);
        pole.setSize(200,50);
        stage.addActor(pole);

        podaj_nikc = new BitmapFont();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if(flaga_glowana==0){
            Gra.wiadomosc = "Zaczyna rozgrywke";
            flaga_glowana=1;
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gra.batch.begin();


        gra.batch.draw(tlo, 0,0, Gra.SZEROKOSC_OKNA, Gra.WYSOKOSC_OKNA);

        gra.batch.draw(logo, Gra.SZEROKOSC_OKNA/2-150, 700, 300, 200);

        if(wpisany_nick==true || Gra.imie!=null)
        {
            if(Gdx.input.getX()>=300 && Gdx.input.getX()<=500 && Gdx.input.getY()>=450 && Gdx.input.getY()<=550){
                gra.batch.draw(przyciskGrajNieakt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 450, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
                if(Gdx.input.isTouched()){
                    gra.setScreen(new MainGameSceen(gra));
                }
            }
            else{
                gra.batch.draw(przyciskGrajAkt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 450, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);

            }

            if(Gdx.input.getX()>=300 && Gdx.input.getX()<=500 && Gdx.input.getY()>=600 && Gdx.input.getY()<=700){
                gra.batch.draw(przyciskRankingNieakt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 300, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
                if(Gdx.input.isTouched()) {
                    gra.setScreen(new RankingSceen(gra));
                }
            }
            else{
                gra.batch.draw(przyciskRankingAkt, Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 300, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
            }

            if(Gdx.input.getX()>=300 && Gdx.input.getX()<=500 && Gdx.input.getY()>=750 && Gdx.input.getY()<=850){
                gra.batch.draw(przyciskZamknijNieakt , Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 150, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);
                if(Gdx.input.isTouched()){
                    Gdx.app.exit();
                }
            }
            else{
                gra.batch.draw(przyciskZamknijAkt , Gra.SZEROKOSC_OKNA/2-PRZYCISK_WYSOKOSC, 150, PRZYCISK_SZEROKOSC, PRZYCISK_WYSOKOSC);

            }

            podaj_nikc.getData().setScale(3,3);
            podaj_nikc.draw(gra.batch, "Nazwa gracza: " + Gra.imie, 800/2-200, 650);


            gra.batch.end();

        }else{
            /*---------wpisywanie-nicku--------------*/

            podaj_nikc.getData().setScale(3,3);
            podaj_nikc.draw(gra.batch, "Podaj nick i wcisni ENTER:", 150, 600);


            gra.batch.end();

            stage.draw();
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && pole.getText().length()>0) {
                Gra.imie = pole.getText();
                wpisany_nick = true;
                //System.out.println(pole.getText());
                //gra.setScreen(new MainMenuScreen(gra));
                //pole.setText("--");
            }

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
        przyciskGrajAkt.dispose();
        przyciskGrajNieakt.dispose();
        logo.dispose();
        podaj_nikc.dispose();
        tlo.dispose();
        przyciskRankingAkt.dispose();
        przyciskRankingNieakt.dispose();
        przyciskZamknijAkt.dispose();
        przyciskZamknijNieakt.dispose();
        skin.dispose();
        stage.dispose();

    }
}
