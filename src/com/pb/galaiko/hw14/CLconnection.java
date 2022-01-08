package com.pb.galaiko.hw14;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class CLconnection {
    private final Socket socket;
    private final Thread thread;
    private final BufferedReader in;
    private final BufferedWriter out;


    public CLconnection (String ipadres , int port) throws IOException{
        this(new Socket(ipadres, port ));
    }

    public CLconnection (Socket socket) throws IOException{
        this.socket =socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8")));

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.isInterrupted()){
                    try {
                        String msg = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                  String msg =in.readLine();
                }
                catch (IOException e){
                 }
                finally {

                }

            }
        });
        thread.start();
    }

    public synchronized void sendString(String value) throws IOException {
        out.write(value + "\r\n");
        out.flush();
        disconnect();

    }
    public synchronized void disconnect() throws IOException {
        thread.isInterrupted();
        socket.close();
    }
    @Override
    public  String toString(){
        return "CLconnection: " +socket.getInetAddress() +":" + socket.getPort();
    }
}
