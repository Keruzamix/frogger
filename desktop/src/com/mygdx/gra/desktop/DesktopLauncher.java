package com.mygdx.gra.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.gra.Gra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class DesktopLauncher {


	/*----------------Kient-------------------*/
	public static final int PORT = 5000;
	public static String IP ="127.0.0.1";
	public static String imie;
	public static String str;

	BufferedReader bufferedReader;

	//uruchomienie klienta
	public void startKlient(){
		Scanner sc = new Scanner(System.in);
		//System.out.println("Podaj imie: ");

		try{

			Socket socket = new Socket(IP, PORT);
			System.out.println("Podlaczona do " + socket);

			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Thread t = new Thread(new DesktopLauncher.Odbiorca());
			t.start();

			while(true){
				System.out.println(">> ");
				//str = sc.nextLine();

				str = Gra.wiadomosc;
				imie = Gra.imie;
				//printWriter.println();
				if(imie!=null && str!=null)
				{
					printWriter.println(imie + ": " + str + ";" + Gra.punkty);
					printWriter.flush();
					Gra.wiadomosc = null;
					str = null;

					System.out.println("ZLE");
				}

			}

		}catch (Exception e){

		}
	}

	/*-------------------------------------------*/


	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Gra.WYSOKOSC_OKNA;
		config.width = Gra.SZEROKOSC_OKNA;
		config.foregroundFPS = 60;
		config.resizable = false;

		new LwjglApplication(new Gra(), config);

		DesktopLauncher k = new DesktopLauncher();
		k.startKlient();

	}


	class Odbiorca implements Runnable{


		@Override
		public void run() {
			String wiadomosci;
			try{
				int i=0;
				int flaga1=0;
				String tym;
				while((wiadomosci = bufferedReader.readLine())!= null){
					String subString[] = wiadomosci.split(":");

					tym = wiadomosci;

					Gra.ranking = tym.split(">");

					tym = Gra.ranking[0];

					System.out.println(wiadomosci);
					System.out.println(">>");

					i++;

					if(i<3){
						Gra.chat[i]=tym;
					}

					if(i==3 && flaga1==0)
						flaga1=1;

					if(flaga1==1){
						Gra.chat[0]=Gra.chat[1];
						Gra.chat[1]=Gra.chat[2];
						Gra.chat[2]=tym;


					}


				}
			} catch (Exception e){
				System.out.println("Połączenie zakonczone.");
			}

		}
	}
}
