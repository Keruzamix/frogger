package com.mygdx.gra.Serwer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Serwer {

    ArrayList klientArraylist;
    PrintWriter printWriter;
    String[] new_str;
    String[] imie;

    private static int serverPort;

    private static String ranking[] = new String[5];



    public static void main(String[] arg){

        for(int i=0;i<5;i++)
            ranking[i] = "PUSTE=0";

        loadServerConfig();
        Serwer s = new Serwer();
        s.startSerwer();
    }

    public void startSerwer(){
        klientArraylist = new ArrayList();

        try{
            //System.out.println(serverPort);
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Słucham: " + serverSocket);
                printWriter = new PrintWriter(socket.getOutputStream());
                klientArraylist.add(printWriter);

                Thread t = new Thread(new SerwerKlient(socket));
                t.start();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    class SerwerKlient implements Runnable{

        Socket socket;
        BufferedReader bufferedReader;

        public SerwerKlient(Socket socketKlient){
            try{
                System.out.println("Połączony: " + socketKlient);
                socket = socketKlient;
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String str;
            PrintWriter pw = null;


            try{
                while((str=bufferedReader.readLine()) != null){
                    System.out.println("Odebrano >> " + str);
                    new_str = str.split(";");

                    int flaga_wstawione = 0;

                    for(int i=0; i<5; i++){
                        imie = str.split(":");
                        String[] new_ranking;
                        new_ranking = ranking[i].split("=");

                        if(Integer.parseInt(new_ranking[1]) < Integer.parseInt(new_str[1]) && flaga_wstawione==0){
                            for(int n=4; n>i; n--){
                                ranking[n] = ranking[n-1];
                            }
                            ranking[i] = imie[0] +"="+ new_str[1];
                            flaga_wstawione=1;
                        }else if(Integer.parseInt(new_ranking[1]) == Integer.parseInt(new_str[1]) && flaga_wstawione==0 && Integer.parseInt(new_ranking[1])>0) {
                            for(int n=4; n>i+1; n--){
                                ranking[n] = ranking[n-1];
                            }
                            if(i+1<=4) {
                                ranking[i+1] = imie[0] +"="+ new_str[1];
                            }

                            flaga_wstawione=1;

                        }

                            System.out.println(i+":"+ranking[i]);
                    }

                    Iterator it = klientArraylist.iterator();
                    while(it.hasNext()){
                        pw = (PrintWriter) it.next();
                        pw.println(new_str[0]+">"+ranking[0]+">"+ranking[1]+">"+ranking[2]+">"+ranking[3]+">"+ranking[4]);
                        pw.flush();
                    }
                }

            }catch (Exception e){

            }
        }
    }

    public static void loadServerConfig() {
        LoadConfigServerXML loadConfig = new LoadConfigServerXML();
        serverPort = loadConfig.portNumber;
        System.out.println("Serwer pracuje na porcie: " + serverPort);
    }

}
