package com.mygdx.gra.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.gra.Gra;

public class ChatScereen implements Screen {

    Gra gra;

    private Skin skin;

    private Stage stage;
    private TextField pole;


    public ChatScereen(Gra gra){
        this.gra = gra;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        pole = new TextField("",skin);
        pole.setPosition(800/2,800/2);
        pole.setSize(200,100);
        stage.addActor(pole);
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
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && pole.getText().length()>0) {
            System.out.println(pole.getText());
            Gra.imie = pole.getText();
            gra.setScreen(new MainMenuScreen(gra));
            //pole.setText("--");
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

    }
}
