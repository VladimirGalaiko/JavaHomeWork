package com.pb.galaiko.hw14;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


import javax.swing.JTextArea;


public class MainchatThread extends Thread{
    private OutputStream out;
    private BufferedReader brd;
    private Socket socket;
    private int port;
    private String ip;
    private JTextArea jta;


    public MainchatThread(String ip,int port,JTextArea jta){
        this.jta=jta;
        this.ip=ip;
        this.port=port;

    }

    public boolean runing(){
        try{
            Socket socket=new Socket(this.ip,this.port);
            System.out.println ("Подключиться успешно");
            InputStream ins = socket.getInputStream (); // Получить объект ввода и вывода потока
            out=socket.getOutputStream();
            brd = new BufferedReader (new InputStreamReader (ins)); // читать строку строки
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }return false;
    }


    // Метод чтения информации о сервере
    public void readMsg(){
        try{
            String input=brd.readLine();
            while(!"bye".equals(input)){
                System.out.println ( "Сервер" + input);
                jta.append(input +"\r\n");
                System.out.println ( "Hello");
                input=brd.readLine();
            }
        }catch(Exception ef){}
    }
    // Вывод информации
    public void sendMsg(String msg){
        try{
            msg+="\r\n";
            this.out.write(msg.getBytes());
            this.out.flush();
        }catch(Exception ef){}
    }

    public void run(){
        readMsg();
    }
}