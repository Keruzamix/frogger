package com.mygdx.gra;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gra.screens.MainGameSceen;
import com.mygdx.gra.screens.MainMenuScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Gra extends Game {
	public SpriteBatch batch;
	public static int WYSOKOSC_OKNA=1000;
	public static int SZEROKOSC_OKNA=800;
	public static String[] chat=new String[3];
	public static String[] ranking;

	public static int flaga_glowana = 0;

	public static int punkty=-1;

	public static String imie;
	public static String wiadomosc;



	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();

	}

	@Override
	public void dispose () {
			}




}
